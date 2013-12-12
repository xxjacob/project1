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
    private Integer blockGroup;
	/**
    * 获取属性:blockGroup
    * block_group
    * @return blockGroup
    */
	public Integer getBlockGroup () {
    	return blockGroup;
   	}
   	/**
     * 设置属性:blockGroup
     * block_group
     * @param blockGroup
     */
    public BlockQuery setBlockGroup(Integer blockGroup) {
    	this.blockGroup = blockGroup;
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
    public BlockQuery setOrderNum(Integer orderNum) {
    	this.orderNum = orderNum;
    	return this;
    }
	/** 1首页 **/
    private Integer pageId;
	/**
    * 获取属性:pageId
    * 1首页
    * @return pageId
    */
	public Integer getPageId () {
    	return pageId;
   	}
   	/**
     * 设置属性:pageId
     * 1首页
     * @param pageId
     */
    public BlockQuery setPageId(Integer pageId) {
    	this.pageId = pageId;
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
	/** template **/
    private String template;
	/**
    * 获取属性:template
    * template
    * @return template
    */
	public String getTemplate () {
    	return template;
   	}
   	/**
     * 设置属性:template
     * template
     * @param template
     */
    public BlockQuery setTemplate(String template) {
    	this.template = template;
    	return this;
    }
	/** newsid **/
    private Integer newsId;
	/**
    * 获取属性:newsId
    * newsid
    * @return newsId
    */
	public Integer getNewsId () {
    	return newsId;
   	}
   	/**
     * 设置属性:newsId
     * newsid
     * @param newsId
     */
    public BlockQuery setNewsId(Integer newsId) {
    	this.newsId = newsId;
    	return this;
    }
	/** image_url **/
    private String img;
	/**
    * 获取属性:img
    * image_url
    * @return img
    */
	public String getImg () {
    	return img;
   	}
   	/**
     * 设置属性:img
     * image_url
     * @param img
     */
    public BlockQuery setImg(String img) {
    	this.img = img;
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
    public BlockQuery setCreateTime(Integer createTime) {
    	this.createTime = createTime;
    	return this;
    }
	/** modify_time **/
    private Integer modifyTime;
	/**
    * 获取属性:modifyTime
    * modify_time
    * @return modifyTime
    */
	public Integer getModifyTime () {
    	return modifyTime;
   	}
   	/**
     * 设置属性:modifyTime
     * modify_time
     * @param modifyTime
     */
    public BlockQuery setModifyTime(Integer modifyTime) {
    	this.modifyTime = modifyTime;
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
	 * 设置排序按属性：order_num
	 * @param isAsc 是否升序，否则为降序
	 */	
	public BlockQuery orderbyOrderNum(boolean isAsc){
		orderFields.add(new OrderField("order_num",isAsc?"ASC":"DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：1首页
	 * @param isAsc 是否升序，否则为降序
	 */	
	public BlockQuery orderbyPageId(boolean isAsc){
		orderFields.add(new OrderField("page_id",isAsc?"ASC":"DESC"));
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
	/**
	 * 设置排序按属性：template
	 * @param isAsc 是否升序，否则为降序
	 */	
	public BlockQuery orderbyTemplate(boolean isAsc){
		orderFields.add(new OrderField("template",isAsc?"ASC":"DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：0其他链接, 1其他图片链接, 2本站新闻链接,3本站图片新闻链接 4 静态块
	 * @param isAsc 是否升序，否则为降序
	 */	
	public BlockQuery orderbyType(boolean isAsc){
		orderFields.add(new OrderField("type",isAsc?"ASC":"DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：0 false 1 true
	 * @param isAsc 是否升序，否则为降序
	 */	
	public BlockQuery orderbyIsBold(boolean isAsc){
		orderFields.add(new OrderField("is_bold",isAsc?"ASC":"DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：newsid
	 * @param isAsc 是否升序，否则为降序
	 */	
	public BlockQuery orderbyNewsId(boolean isAsc){
		orderFields.add(new OrderField("news_id",isAsc?"ASC":"DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：image_url
	 * @param isAsc 是否升序，否则为降序
	 */	
	public BlockQuery orderbyImg(boolean isAsc){
		orderFields.add(new OrderField("img",isAsc?"ASC":"DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：create_time
	 * @param isAsc 是否升序，否则为降序
	 */	
	public BlockQuery orderbyCreateTime(boolean isAsc){
		orderFields.add(new OrderField("create_time",isAsc?"ASC":"DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：modify_time
	 * @param isAsc 是否升序，否则为降序
	 */	
	public BlockQuery orderbyModifyTime(boolean isAsc){
		orderFields.add(new OrderField("modify_time",isAsc?"ASC":"DESC"));
		return this;
	}
}
