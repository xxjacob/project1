package com.ideax.project1.pojo;

import java.util.List;
import java.io.Serializable;

/**
 *
 * @author 王永玲
 */
public class Admin implements Serializable{

	/** 序列化ID */
	private static final long serialVersionUID = 1L;

	/** id **/
    private Integer id;
	/** username **/
    private String username;
	/** password **/
    private String password;

	
   /**
    * 获取属性:id
    * id
    * @return id
    */
   public Integer getId() {
       return id;
   }
   /**
    * 设置属性:id
    * id
    * @param id
    */
   public void setId(Integer id) {
       this.id = id;
   }
	
   /**
    * 获取属性:username
    * username
    * @return username
    */
   public String getUsername() {
       return username;
   }
   /**
    * 设置属性:username
    * username
    * @param username
    */
   public void setUsername(String username) {
       this.username = username;
   }
	
   /**
    * 获取属性:password
    * password
    * @return password
    */
   public String getPassword() {
       return password;
   }
   /**
    * 设置属性:password
    * password
    * @param password
    */
   public void setPassword(String password) {
       this.password = password;
   }

	/**
     * 需要更新时的代码，keys 代表主键list
     */
	private List<Long> keys;
		
	public List<Long> getKeys() {
		return keys;
	}
	
	public void setIds(List<Long> keys) {
		this.keys = keys;
	}
}