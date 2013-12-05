package com.ideax.project1.query;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 王永玲
 */
public class BlockQuery extends BaseQuery {
	
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
    public BlockQuery setId(Integer id) {
    	this.id = id;
    	return this;
    }
	/** block_group **/
    private String blockGroup;
	/**
    * 获取属性:blockGroup
    * block_group
    * @return blockGroup
    */
	public String getBlockGroup () {
    	return blockGroup;
   	}
   	/**
     * 设置属性:blockGroup
     * block_group
     * @param blockGroup
     */
    public BlockQuery setBlockGroup(String blockGroup) {
    	this.blockGroup = blockGroup;
    	return this;
    }
	/** block_name **/
    private String blockName;
	/**
    * 获取属性:blockName
    * block_name
    * @return blockName
    */
	public String getBlockName () {
    	return blockName;
   	}
   	/**
     * 设置属性:blockName
     * block_name
     * @param blockName
     */
    public BlockQuery setBlockName(String blockName) {
    	this.blockName = blockName;
    	return this;
    }
	/** url **/
    private String url;
	/**
    * 获取属性:url
    * url
    * @return url
    */
	public String getUrl () {
    	return url;
   	}
   	/**
     * 设置属性:url
     * url
     * @param url
     */
    public BlockQuery setUrl(String url) {
    	this.url = url;
    	return this;
    }
	/** title **/
    private String title;
	/**
    * 获取属性:title
    * title
    * @return title
    */
	public String getTitle () {
    	return title;
   	}
   	/**
     * 设置属性:title
     * title
     * @param title
     */
    public BlockQuery setTitle(String title) {
    	this.title = title;
    	return this;
    }
	/** html **/
    private String html;
	/**
    * 获取属性:html
    * html
    * @return html
    */
	public String getHtml () {
    	return html;
   	}
   	/**
     * 设置属性:html
     * html
     * @param html
     */
    public BlockQuery setHtml(String html) {
    	this.html = html;
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
	public BlockQuery orderbyId(boolean isAsc){
		orderFields.add(new OrderField("id",isAsc?"ASC":"DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：block_group
	 * @param isAsc 是否升序，否则为降序
	 */	
	public BlockQuery orderbyBlockGroup(boolean isAsc){
		orderFields.add(new OrderField("block_group",isAsc?"ASC":"DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：block_name
	 * @param isAsc 是否升序，否则为降序
	 */	
	public BlockQuery orderbyBlockName(boolean isAsc){
		orderFields.add(new OrderField("block_name",isAsc?"ASC":"DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：url
	 * @param isAsc 是否升序，否则为降序
	 */	
	public BlockQuery orderbyUrl(boolean isAsc){
		orderFields.add(new OrderField("url",isAsc?"ASC":"DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：title
	 * @param isAsc 是否升序，否则为降序
	 */	
	public BlockQuery orderbyTitle(boolean isAsc){
		orderFields.add(new OrderField("title",isAsc?"ASC":"DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：html
	 * @param isAsc 是否升序，否则为降序
	 */	
	public BlockQuery orderbyHtml(boolean isAsc){
		orderFields.add(new OrderField("html",isAsc?"ASC":"DESC"));
		return this;
	}
}
