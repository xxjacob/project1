package com.ideax.project1.dao;

import java.util.List;

import javax.annotation.Resource;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ideax.project1.pojo.Pindao;
import java.util.Collections;
import com.ideax.project1.common.Result;
import com.ideax.project1.query.PindaoQuery;
/**
 * @author xuxin03
 */
@Repository
public class PindaoDAO {
	
	@Resource
	SqlMapClient sqlMapClientTemplate;
	
	public Integer addPindao(Pindao pindao) throws SQLException{
		return (Integer)this.sqlMapClientTemplate.insert("Pindao.insertPindao", pindao);
	}
	
	public Pindao getPindaobyKey(Integer id) throws SQLException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		Pindao result = (Pindao) this.sqlMapClientTemplate.queryForObject(
				"Pindao.getPindao", params);
		return result;
	}
	
    public List<Pindao> getPindaosByKeys(List<Integer> ids) throws SQLException {
		if (ids.isEmpty()) {
			return Collections.emptyList();
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("keys", ids);
		return  (List<Pindao>)this.sqlMapClientTemplate.queryForList("Pindao.getPindaosByKeys", params);
	}	
	
	public Integer deleteByKey(Integer id) throws SQLException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", id);
		Integer row = (Integer) this.sqlMapClientTemplate.delete("Pindao.deleteByKey", params);
		return row;
	}
	
    public Integer deleteByKeys(List<Integer> ids) throws SQLException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("keys", ids);
		Integer row = (Integer) this.sqlMapClientTemplate.delete("Pindao.deleteByKeys", params);
		return row;
	}
	
    public Integer updatePindao(Pindao pindao) throws SQLException{
		return (Integer) this.sqlMapClientTemplate.update("Pindao.updatePindao", pindao);
	}
	
	/**
	 * 成批更新对象，需要设置对象中的keys。
	 */
    public Integer updatePindaosByKeys(Pindao pindao) throws SQLException{
		return (Integer) sqlMapClientTemplate.update("Pindao.updatePindaosByKeys", pindao);
	}

    	
		@SuppressWarnings("unchecked")
    public Result<Pindao> getPindaoListWithPage(PindaoQuery pindaoQuery){
	    Result<Pindao> rs = new Result<Pindao>(); 
		try{		
			rs.setCount((Integer) this.sqlMapClientTemplate.queryForObject("Pindao.getPindaoListCount",pindaoQuery));
			rs.setList((List<Pindao>)this.sqlMapClientTemplate.queryForList("Pindao.getPindaoListWithPage", pindaoQuery));
		}catch(SQLException e){
			rs.setSuccess(false);
			rs.setCount(0);
			rs.setList(Collections.EMPTY_LIST);
			rs.setErrorMsg(e.toString());
		}
		return rs;
	}
        
    @SuppressWarnings("unchecked")
    public List<Pindao> getPindaoList(PindaoQuery pindaoQuery) throws SQLException{
		return (List<Pindao>)this.sqlMapClientTemplate.queryForList("Pindao.getPindaoList", pindaoQuery);
	}

}
