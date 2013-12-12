package com.ideax.project1.dao;

import java.util.List;

import javax.annotation.Resource;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ideax.project1.pojo.Lanmu;
import java.util.Collections;
import com.ideax.project1.common.Result;
import com.ideax.project1.query.LanmuQuery;
/**
 * @author 王永玲
 */
@Repository
public class LanmuDAO {
	
	@Resource
	SqlMapClient sqlMapClientTemplate;
	
	public Integer addLanmu(Lanmu lanmu) throws SQLException{
		return (Integer)this.sqlMapClientTemplate.insert("Lanmu.insertLanmu", lanmu);
	}
	
	public Lanmu getLanmubyKey(Integer id) throws SQLException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		Lanmu result = (Lanmu) this.sqlMapClientTemplate.queryForObject(
				"Lanmu.getLanmu", params);
		return result;
	}
	
    public List<Lanmu> getLanmusByKeys(List<Integer> ids) throws SQLException {
		if (ids.isEmpty()) {
			return Collections.emptyList();
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("keys", ids);
		return  (List<Lanmu>)this.sqlMapClientTemplate.queryForList("Lanmu.getLanmusByKeys", params);
	}	
	
	public Integer deleteByKey(Integer id) throws SQLException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", id);
		Integer row = (Integer) this.sqlMapClientTemplate.delete("Lanmu.deleteByKey", params);
		return row;
	}
	
    public Integer deleteByKeys(List<Integer> ids) throws SQLException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("keys", ids);
		Integer row = (Integer) this.sqlMapClientTemplate.delete("Lanmu.deleteByKeys", params);
		return row;
	}
	
    public Integer updateLanmu(Lanmu lanmu) throws SQLException{
		return (Integer) this.sqlMapClientTemplate.update("Lanmu.updateLanmu", lanmu);
	}
	
	/**
	 * 成批更新对象，需要设置对象中的keys。
	 */
    public Integer updateLanmusByKeys(Lanmu lanmu) throws SQLException{
		return (Integer) sqlMapClientTemplate.update("Lanmu.updateLanmusByKeys", lanmu);
	}

    	
		@SuppressWarnings("unchecked")
    public Result<Lanmu> getLanmuListWithPage(LanmuQuery lanmuQuery){
	    Result<Lanmu> rs = new Result<Lanmu>(); 
		try{		
			rs.setCount((Integer) this.sqlMapClientTemplate.queryForObject("Lanmu.getLanmuListCount",lanmuQuery));
			rs.setList((List<Lanmu>)this.sqlMapClientTemplate.queryForList("Lanmu.getLanmuListWithPage", lanmuQuery));
		}catch(SQLException e){
			rs.setSuccess(false);
			rs.setCount(0);
			rs.setList(Collections.EMPTY_LIST);
			rs.setErrorMsg(e.toString());
		}
		return rs;
	}
        
    @SuppressWarnings("unchecked")
    public List<Lanmu> getLanmuList(LanmuQuery lanmuQuery) throws SQLException{
		return (List<Lanmu>)this.sqlMapClientTemplate.queryForList("Lanmu.getLanmuList", lanmuQuery);
	}

}
