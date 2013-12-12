package com.ideax.project1.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
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
	 * 
	 * @param newsid
	 * @return
	 */
	public List<Comment> getCommentsByNewsid(int newsid, int page, int pagesize, Map<Integer, Comment> requiredRef) {
		if (requiredRef == null)
			throw new IllegalException(EC.EC_PARAM);
		try {
			List<Comment> list = commentDAO.getCommentList((CommentQuery) new CommentQuery().setNewsId(newsid)
					.orderbyFloor(false).setPage(page).setPageSize(pagesize));
			if (CollectionUtils.isEmpty(list))
				return Collections.emptyList();
			genRefComment(list, requiredRef);
			return list;
		} catch (SQLException e) {
			logger.error("", e);
			throw new IllegalException(EC.EC_DB);
		}

	}
	
	private void genRefComment(List<Comment> list, Map<Integer, Comment> requiredRef) throws SQLException{
		for (Comment cmt : list) {
			String tos = cmt.getReplyTo();
			if (StringUtils.isNotBlank(tos)) {
				for (String scid : tos.split(",")) {
					int cid = Integer.valueOf(scid);
					Comment old = requiredRef.get(cid);
					if (old == null)
						requiredRef.put(cid, MARK);
				}
			}
			// put if we already find it
			if (requiredRef.get(cmt.getId()) == MARK) {
				requiredRef.put(cmt.getId(), cmt);
			}
		}
		List<Integer> elder = new ArrayList<Integer>();
		for (Entry<Integer, Comment> en : requiredRef.entrySet()) {
			if (en.getValue() == MARK) {
				elder.add(en.getKey());
			}
		}
		if (elder.size() > 0) {
			List<Comment> eldercs = commentDAO.getCommentsByKeys(elder);
			for (Comment c : eldercs) {
				requiredRef.put(c.getId(), c);
			}
		}
	}

	/**
	 * 获取评论及引用评论
	 * 
	 * @param newsid
	 * @return
	 */
	public Result<Comment> getCommentPageByNewsid(int newsid, int page, int pagesize, Map<Integer, Comment> requiredRef) {
		if (requiredRef == null)
			throw new IllegalException(EC.EC_PARAM);
		try {
			Result<Comment> rst = commentDAO.getCommentListWithPage((CommentQuery) new CommentQuery().setNewsId(newsid)
					.orderbyFloor(false).setPage(page).setPageSize(pagesize));
			List<Comment> list = rst.getList();
			genRefComment(list, requiredRef);
			return rst;
		} catch (SQLException e) {
			logger.error("", e);
			throw new IllegalException(EC.EC_DB);
		}

	}

	/**
	 * submit comment
	 */
	public int submitComment(Comment newc, int replyTo, int newsId) {
		try {
			if (replyTo > 0) {
				Comment comment = commentDAO.getCommentbyKey(replyTo);
				if (comment == null)
					throw new IllegalException(EC.EC_PARAM, "replied comment dose not exist");
				String rts = comment.getReplyTo();
				if (StringUtils.isBlank(rts))
					newc.setReplyTo(String.valueOf(replyTo));
				else
					newc.setReplyTo(replyTo + "," + rts);
				if (comment.getNewsId() != newsId)
					throw new IllegalException(EC.EC_PARAM, "replied comment is not belong to news:" + newsId);
			}

			newc.setNewsId(newsId);

			List<Comment> list = commentDAO.getCommentList((CommentQuery) new CommentQuery().setNewsId(newsId)
					.orderbyFloor(false).setPage(1).setPageSize(1));
			if (list == null || list.size() == 0)
				newc.setFloor(1);
			else
				newc.setFloor(list.get(0).getFloor() + 1);

			return commentDAO.addComment(newc);

		} catch (SQLException e) {
			logger.error("", e);
			throw new IllegalException(EC.EC_DB);
		}
	}

	public Comment getCommentsById(int id) {
		try {
			return commentDAO.getCommentbyKey(id);
		} catch (SQLException e) {
			logger.error("", e);
			throw new IllegalException(EC.EC_DB);
		}
	}
}
