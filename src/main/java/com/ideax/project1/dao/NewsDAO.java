package com.ideax.project1.dao;

import java.util.List;

import javax.annotation.Resource;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ideax.project1.pojo.News;
import java.util.Collections;
import com.ideax.project1.common.Result;
import com.ideax.project1.query.NewsQuery;
/**
 * @author xxjacob
 */
@Repository
public class NewsDAO {
	
	@Resource
	SqlMapClient sqlMapClientTemplate;
	
	public Integer addNews(News news) throws SQLException{
		return (Integer)this.sqlMapClientTemplate.insert("News.insertNews", news);
	}
	
	public News getNewsbyKey(Integer id) throws SQLException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		News result = (News) this.sqlMapClientTemplate.queryForObject(
				"News.getNews", params);
		return result;
	}
	
    public List<News> getNewssByKeys(List<Integer> ids) throws SQLException {
		if (ids.isEmpty()) {
			return Collections.emptyList();
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("keys", ids);
		return  (List<News>)this.sqlMapClientTemplate.queryForList("News.getNewssByKeys", params);
	}	
	
	public Integer deleteByKey(Integer id) throws SQLException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", id);
		Integer row = (Integer) this.sqlMapClientTemplate.delete("News.deleteByKey", params);
		return row;
	}
	
    public Integer deleteByKeys(List<Integer> ids) throws SQLException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("keys", ids);
		Integer row = (Integer) this.sqlMapClientTemplate.delete("News.deleteByKeys", params);
		return row;
	}
	
    public Integer updateNews(News news) throws SQLException{
		return (Integer) this.sqlMapClientTemplate.update("News.updateNews", news);
	}
	
	/**
	 * 成批更新对象，需要设置对象中的keys。
	 */
    public Integer updateNewssByKeys(News news) throws SQLException{
		return (Integer) sqlMapClientTemplate.update("News.updateNewssByKeys", news);
	}

    	
		@SuppressWarnings("unchecked")
    public Result<News> getNewsListWithPage(NewsQuery newsQuery){
	    Result<News> rs = new Result<News>(); 
		try{		
			rs.setCount((Integer) this.sqlMapClientTemplate.queryForObject("News.getNewsListCount",newsQuery));
			rs.setList((List<News>)this.sqlMapClientTemplate.queryForList("News.getNewsListWithPage", newsQuery));
		}catch(SQLException e){
			rs.setSuccess(false);
			rs.setCount(0);
			rs.setList(Collections.EMPTY_LIST);
			rs.setErrorMsg(e.toString());
		}
		return rs;
	}
        
    @SuppressWarnings("unchecked")
    public List<News> getNewsList(NewsQuery newsQuery) throws SQLException{
		return (List<News>)this.sqlMapClientTemplate.queryForList("News.getNewsList", newsQuery);
	}

}
