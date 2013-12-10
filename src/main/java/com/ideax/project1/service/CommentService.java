package com.ideax.project1.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideax.common.exception.EC;
import com.ideax.common.exception.IllegalException;
import com.ideax.project1.common.Result;
import com.ideax.project1.dao.BlockDAO;
import com.ideax.project1.dao.CommentDAO;
import com.ideax.project1.dao.LanmuDAO;
import com.ideax.project1.pojo.Comment;
import com.ideax.project1.query.CommentQuery;

@Service
public class CommentService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    BlockDAO blockDAO;
    @Autowired
    LanmuDAO lanmuDAO;

    @Autowired
    CommentDAO commentDAO;

    public static final Comment MARK = new Comment();// mark as needed

    /**
     * 获取评论及引用评论
     * @param newsid
     * @return
     */
    public List<Comment> getCommentsByNewsid(int newsid, Map<Integer, Comment> requiredRef) {
        if (requiredRef == null)
            throw new IllegalException(EC.EC_PARAM);
        try {
            Result<Comment> rst = commentDAO.getCommentListWithPage(new CommentQuery().setNewsId(newsid).orderbyId(
                    false));
            if (!rst.isSuccess() || CollectionUtils.isEmpty(rst.getList()))
                return Collections.emptyList();
            List<Comment> list = rst.getList();
            for (Comment cmt : list) {
                String tos = cmt.getReplyTo();
                if (StringUtils.isNotBlank(tos)) {
                    for (String scid : tos.split(",")) {
                        int cid = Integer.valueOf(scid);
                        Comment old = requiredRef.get(cid);
                        if (old != null && old.getId() != null)
                            requiredRef.put(cid, MARK);
                    }
                }
                if (requiredRef.get(cmt.getId()) == MARK) {
                    requiredRef.put(cmt.getId(), cmt);
                }
            }
            List<Integer> elder = new ArrayList<Integer>();
            for (Entry<Integer, Comment> en : requiredRef.entrySet()) {
                if (en.getValue() != MARK) {
                    elder.add(en.getKey());
                }
            }
            if (elder.size() > 0) {
                List<Comment> eldercs = commentDAO.getCommentsByKeys(elder);
                for (Comment c : eldercs){
                    requiredRef.put(c.getId(), c);
                }
            }
            return list;
        } catch (SQLException e) {
            logger.error("", e);
            throw new IllegalException(EC.EC_DB);
        }

    }

}
