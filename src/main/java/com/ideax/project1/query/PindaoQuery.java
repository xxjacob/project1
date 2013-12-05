package com.ideax.project1.query;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 王永玲
 */
public class PindaoQuery extends BaseQuery {
	
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
    public PindaoQuery setId(Integer id) {
    	this.id = id;
    	return this;
    }
	/** name **/
    private String name;
	/**
    * 获取属性:name
    * name
    * @return name
    */
	public String getName () {
    	return name;
   	}
   	/**
     * 设置属性:name
     * name
     * @param name
     */
    public PindaoQuery setName(String name) {
    	this.name = name;
    	return this;
    }
	/** order_num **/
    private Integer orderNum;
	/**
    * 获取属性:orderNum
    * order_num
    * @return orderNum
    */
	public Integer getOrderNum () {
    	return orderNum;
   	}
   	/**
     * 设置属性:orderNum
     * order_num
     * @param orderNum
     */
    public PindaoQuery setOrderNum(Integer orderNum) {
    	this.orderNum = orderNum;
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
	public PindaoQuery orderbyId(boolean isAsc){
		orderFields.add(new OrderField("id",isAsc?"ASC":"DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：name
	 * @param isAsc 是否升序，否则为降序
	 */	
	public PindaoQuery orderbyName(boolean isAsc){
		orderFields.add(new OrderField("name",isAsc?"ASC":"DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：order_num
	 * @param isAsc 是否升序，否则为降序
	 */	
	public PindaoQuery orderbyOrderNum(boolean isAsc){
		orderFields.add(new OrderField("order_num",isAsc?"ASC":"DESC"));
		return this;
	}
}
