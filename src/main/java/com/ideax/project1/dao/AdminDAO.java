package com.ideax.project1.dao;

import java.util.List;

import javax.annotation.Resource;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ideax.project1.pojo.Admin;
import java.util.Collections;
import com.ideax.project1.common.Result;
import com.ideax.project1.query.AdminQuery;
/**
 * @author xxjacob
 */
@Repository
public class AdminDAO {
	
	@Resource
	SqlMapClient sqlMapClientTemplate;
	
	public Integer addAdmin(Admin admin) throws SQLException{
		return (Integer)this.sqlMapClientTemplate.insert("Admin.insertAdmin", admin);
	}
	
	public Admin getAdminbyKey(Integer id) throws SQLException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		Admin result = (Admin) this.sqlMapClientTemplate.queryForObject(
				"Admin.getAdmin", params);
		return result;
	}
	
    public List<Admin> getAdminsByKeys(List<Integer> ids) throws SQLException {
		if (ids.isEmpty()) {
			return Collections.emptyList();
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("keys", ids);
		return  (List<Admin>)this.sqlMapClientTemplate.queryForList("Admin.getAdminsByKeys", params);
	}	
	
	public Integer deleteByKey(Integer id) throws SQLException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", id);
		Integer row = (Integer) this.sqlMapClientTemplate.delete("Admin.deleteByKey", params);
		return row;
	}
	
    public Integer deleteByKeys(List<Integer> ids) throws SQLException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("keys", ids);
		Integer row = (Integer) this.sqlMapClientTemplate.delete("Admin.deleteByKeys", params);
		return row;
	}
	
    public Integer updateAdmin(Admin admin) throws SQLException{
		return (Integer) this.sqlMapClientTemplate.update("Admin.updateAdmin", admin);
	}
	
	/**
	 * 成批更新对象，需要设置对象中的keys。
	 */
    public Integer updateAdminsByKeys(Admin admin) throws SQLException{
		return (Integer) sqlMapClientTemplate.update("Admin.updateAdminsByKeys", admin);
	}

    	
		@SuppressWarnings("unchecked")
    public Result<Admin> getAdminListWithPage(AdminQuery adminQuery){
	    Result<Admin> rs = new Result<Admin>(); 
		try{		
			rs.setCount((Integer) this.sqlMapClientTemplate.queryForObject("Admin.getAdminListCount",adminQuery));
			rs.setList((List<Admin>)this.sqlMapClientTemplate.queryForList("Admin.getAdminListWithPage", adminQuery));
		}catch(SQLException e){
			rs.setSuccess(false);
			rs.setCount(0);
			rs.setList(Collections.EMPTY_LIST);
			rs.setErrorMsg(e.toString());
		}
		return rs;
	}
        
    @SuppressWarnings("unchecked")
    public List<Admin> getAdminList(AdminQuery adminQuery) throws SQLException{
		return (List<Admin>)this.sqlMapClientTemplate.queryForList("Admin.getAdminList", adminQuery);
	}

}
