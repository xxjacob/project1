package com.ideax.project1.query;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 王永玲
 */
public class CommentQuery extends BaseQuery {
	
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
    public CommentQuery setId(Integer id) {
    	this.id = id;
    	return this;
    }
	/** content **/
    private String content;
	/**
    * 获取属性:content
    * content
    * @return content
    */
	public String getContent () {
    	return content;
   	}
   	/**
     * 设置属性:content
     * content
     * @param content
     */
    public CommentQuery setContent(String content) {
    	this.content = content;
    	return this;
    }
	/** create_time **/
    private Integer createTime;
	/**
    * 获取属性:createTime
    * create_time
    * @return createTime
    */
	public Integer getCreateTime () {
    	return createTime;
   	}
   	/**
     * 设置属性:createTime
     * create_time
     * @param createTime
     */
    public CommentQuery setCreateTime(Integer createTime) {
    	this.createTime = createTime;
    	return this;
    }
	/** id1,id2,id3 **/
    private String replyTo;
	/**
    * 获取属性:replyTo
    * id1,id2,id3
    * @return replyTo
    */
	public String getReplyTo () {
    	return replyTo;
   	}
   	/**
     * 设置属性:replyTo
     * id1,id2,id3
     * @param replyTo
     */
    public CommentQuery setReplyTo(String replyTo) {
    	this.replyTo = replyTo;
    	return this;
    }
	/** 来自什么设备 **/
    private String device;
	/**
    * 获取属性:device
    * 来自什么设备
    * @return device
    */
	public String getDevice () {
    	return device;
   	}
   	/**
     * 设置属性:device
     * 来自什么设备
     * @param device
     */
    public CommentQuery setDevice(String device) {
    	this.device = device;
    	return this;
    }
	/** ip **/
    private String ip;
	/**
    * 获取属性:ip
    * ip
    * @return ip
    */
	public String getIp () {
    	return ip;
   	}
   	/**
     * 设置属性:ip
     * ip
     * @param ip
     */
    public CommentQuery setIp(String ip) {
    	this.ip = ip;
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
	public CommentQuery orderbyId(boolean isAsc){
		orderFields.add(new OrderField("id",isAsc?"ASC":"DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：content
	 * @param isAsc 是否升序，否则为降序
	 */	
	public CommentQuery orderbyContent(boolean isAsc){
		orderFields.add(new OrderField("content",isAsc?"ASC":"DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：create_time
	 * @param isAsc 是否升序，否则为降序
	 */	
	public CommentQuery orderbyCreateTime(boolean isAsc){
		orderFields.add(new OrderField("create_time",isAsc?"ASC":"DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：id1,id2,id3
	 * @param isAsc 是否升序，否则为降序
	 */	
	public CommentQuery orderbyReplyTo(boolean isAsc){
		orderFields.add(new OrderField("reply_to",isAsc?"ASC":"DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：来自什么设备
	 * @param isAsc 是否升序，否则为降序
	 */	
	public CommentQuery orderbyDevice(boolean isAsc){
		orderFields.add(new OrderField("device",isAsc?"ASC":"DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：ip
	 * @param isAsc 是否升序，否则为降序
	 */	
	public CommentQuery orderbyIp(boolean isAsc){
		orderFields.add(new OrderField("ip",isAsc?"ASC":"DESC"));
		return this;
	}
}
