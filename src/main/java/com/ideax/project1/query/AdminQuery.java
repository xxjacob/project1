package com.ideax.project1.query;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xuxin03
 */
public class AdminQuery extends BaseQuery {
	
	/** ====================查询唯一单条记录使用==========================**/
	
	/**==============================批量查询、更新、删除时的Where条件设置==================================**/
	/** id **/
    private Integer id;
	/**
    * 获取属性:id
    * id
    * @return id
    */
	public Integer getId () {
    	return id;
   	}
   	/**
     * 设置属性:id
     * id
     * @param id
     */
    public AdminQuery setId(Integer id) {
    	this.id = id;
    	return this;
    }
	/** username **/
    private String username;
	/**
    * 获取属性:username
    * username
    * @return username
    */
	public String getUsername () {
    	return username;
   	}
   	/**
     * 设置属性:username
     * username
     * @param username
     */
    public AdminQuery setUsername(String username) {
    	this.username = username;
    	return this;
    }
	/** password **/
    private String password;
	/**
    * 获取属性:password
    * password
    * @return password
    */
	public String getPassword () {
    	return password;
   	}
   	/**
     * 设置属性:password
     * password
     * @param password
     */
    public AdminQuery setPassword(String password) {
    	this.password = password;
    	return this;
    }
	/**==============================批量查询时的Order条件顺序设置==================================**/
	public class OrderField{
		public OrderField(String fieldName, String order) {
			super();
			this.fieldName = fieldName;
			this.order = order;
		}
		private String fieldName;
		private String order;
		public String getFieldName() {
			return fieldName;
		}
		public OrderField setFieldName(String fieldName) {
			this.fieldName = fieldName;
			return this;
		}
		public String getOrder() {
			return order;
		}
		public OrderField setOrder(String order) {
			this.order = order;
			return this;
		}
	}

	/**==============================批量查询时的Order条件顺序设置==================================**/
	/**排序列表字段**/
	private List<OrderField> orderFields = new ArrayList<OrderField>();
	/**
	 * 设置排序按属性：id
	 * @param isAsc 是否升序，否则为降序
	 */	
	public AdminQuery orderbyId(boolean isAsc){
		orderFields.add(new OrderField("id",isAsc?"ASC":"DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：username
	 * @param isAsc 是否升序，否则为降序
	 */	
	public AdminQuery orderbyUsername(boolean isAsc){
		orderFields.add(new OrderField("username",isAsc?"ASC":"DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：password
	 * @param isAsc 是否升序，否则为降序
	 */	
	public AdminQuery orderbyPassword(boolean isAsc){
		orderFields.add(new OrderField("password",isAsc?"ASC":"DESC"));
		return this;
	}
}
