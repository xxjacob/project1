package com.ideax.project1.dao;

import java.util.List;

import javax.annotation.Resource;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ideax.project1.pojo.Block;
import java.util.Collections;
import com.ideax.project1.common.Result;
import com.ideax.project1.query.BlockQuery;
/**
 * @author 王永玲
 */
@Repository
public class BlockDAO {
	
	@Resource
	SqlMapClient sqlMapClientTemplate;
	
	public Integer addBlock(Block block) throws SQLException{
		return (Integer)this.sqlMapClientTemplate.insert("Block.insertBlock", block);
	}
	
	public Block getBlockbyKey(Integer id) throws SQLException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		Block result = (Block) this.sqlMapClientTemplate.queryForObject(
				"Block.getBlock", params);
		return result;
	}
	
    public List<Block> getBlocksByKeys(List<Integer> ids) throws SQLException {
		if (ids.isEmpty()) {
			return Collections.emptyList();
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("keys", ids);
		return  (List<Block>)this.sqlMapClientTemplate.queryForList("Block.getBlocksByKeys", params);
	}	
	
	public Integer deleteByKey(Integer id) throws SQLException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("key", id);
		Integer row = (Integer) this.sqlMapClientTemplate.delete("Block.deleteByKey", params);
		return row;
	}
	
    public Integer deleteByKeys(List<Integer> ids) throws SQLException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("keys", ids);
		Integer row = (Integer) this.sqlMapClientTemplate.delete("Block.deleteByKeys", params);
		return row;
	}
	
    public Integer updateBlock(Block block) throws SQLException{
		return (Integer) this.sqlMapClientTemplate.update("Block.updateBlock", block);
	}
	
	/**
	 * 成批更新对象，需要设置对象中的keys。
	 */
    public Integer updateBlocksByKeys(Block block) throws SQLException{
		return (Integer) sqlMapClientTemplate.update("Block.updateBlocksByKeys", block);
	}

    	
		@SuppressWarnings("unchecked")
    public Result<Block> getBlockListWithPage(BlockQuery blockQuery){
	    Result<Block> rs = new Result<Block>(); 
		try{		
			rs.setCount((Integer) this.sqlMapClientTemplate.queryForObject("Block.getBlockListCount",blockQuery));
			rs.setList((List<Block>)this.sqlMapClientTemplate.queryForList("Block.getBlockListWithPage", blockQuery));
		}catch(SQLException e){
			rs.setSuccess(false);
			rs.setCount(0);
			rs.setList(Collections.EMPTY_LIST);
			rs.setErrorMsg(e.toString());
		}
		return rs;
	}
        
    @SuppressWarnings("unchecked")
    public List<Block> getBlockList(BlockQuery blockQuery) throws SQLException{
		return (List<Block>)this.sqlMapClientTemplate.queryForList("Block.getBlockList", blockQuery);
	}

}
