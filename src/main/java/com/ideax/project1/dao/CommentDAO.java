package com.ideax.project1.dao;

import java.util.List;

import javax.annotation.Resource;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ideax.project1.pojo.Comment;
import java.util.Collections;
import com.ideax.project1.common.Result;
import com.ideax.project1.query.CommentQuery;
/**
 * @author 王永玲
 */
@Repository
public class CommentDAO {
	
	@Resource
	SqlMapClient sqlMapClientTemplate;
	
	public Integer addComment(Comment comment) throws SQLException{
		return (Integer)this.sqlMapClientTemplate.insert("Comment.insertComment", comment);
	}
	
	public Comment getCommentbyKey(Integer id) throws SQLException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		Comment result = (Comment) this.sqlMapClientTemplate.queryForObject(
				"Comment.getComment", params);
		return result;
	}
	
    public List<Comment> getCommentsByKeys(List<Integer> ids) throws SQLException {
		if (ids.isEmpty()) {
			return Collections.emptyList();
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("keys", ids);
		return  (List<Comment>)this.sqlMapClientTemplate.queryForList("Comment.getCommentsByKeys", params);
	}	
	
	public Integer deleteByKey(Integer id) throws SQLException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", id);
		Integer row = (Integer) this.sqlMapClientTemplate.delete("Comment.deleteByKey", params);
		return row;
	}
	
    public Integer deleteByKeys(List<Integer> ids) throws SQLException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("keys", ids);
		Integer row = (Integer) this.sqlMapClientTemplate.delete("Comment.deleteByKeys", params);
		return row;
	}
	
    public Integer updateComment(Comment comment) throws SQLException{
		return (Integer) this.sqlMapClientTemplate.update("Comment.updateComment", comment);
	}
	
	/**
	 * 成批更新对象，需要设置对象中的keys。
	 */
    public Integer updateCommentsByKeys(Comment comment) throws SQLException{
		return (Integer) sqlMapClientTemplate.update("Comment.updateCommentsByKeys", comment);
	}

    	
		@SuppressWarnings("unchecked")
    public Result<Comment> getCommentListWithPage(CommentQuery commentQuery){
	    Result<Comment> rs = new Result<Comment>(); 
		try{		
			rs.setCount((Integer) this.sqlMapClientTemplate.queryForObject("Comment.getCommentListCount",commentQuery));
			rs.setList((List<Comment>)this.sqlMapClientTemplate.queryForList("Comment.getCommentListWithPage", commentQuery));
		}catch(SQLException e){
			rs.setSuccess(false);
			rs.setCount(0);
			rs.setList(Collections.EMPTY_LIST);
			rs.setErrorMsg(e.toString());
		}
		return rs;
	}
        
    @SuppressWarnings("unchecked")
    public List<Comment> getCommentList(CommentQuery commentQuery) throws SQLException{
		return (List<Comment>)this.sqlMapClientTemplate.queryForList("Comment.getCommentList", commentQuery);
	}

}
