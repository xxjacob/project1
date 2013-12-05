package com.ideax.project1.query;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 王永玲
 */
public class NewsQuery extends BaseQuery {
	
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
    public NewsQuery setId(Integer id) {
    	this.id = id;
    	return this;
    }
	/** 首页短标题 **/
    private String shortTitle;
	/**
    * 获取属性:shortTitle
    * 首页短标题
    * @return shortTitle
    */
	public String getShortTitle () {
    	return shortTitle;
   	}
   	/**
     * 设置属性:shortTitle
     * 首页短标题
     * @param shortTitle
     */
    public NewsQuery setShortTitle(String shortTitle) {
    	this.shortTitle = shortTitle;
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
    public NewsQuery setTitle(String title) {
    	this.title = title;
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
    public NewsQuery setContent(String content) {
    	this.content = content;
    	return this;
    }
	/** 频道id **/
    private Integer pdId;
	/**
    * 获取属性:pdId
    * 频道id
    * @return pdId
    */
	public Integer getPdId () {
    	return pdId;
   	}
   	/**
     * 设置属性:pdId
     * 频道id
     * @param pdId
     */
    public NewsQuery setPdId(Integer pdId) {
    	this.pdId = pdId;
    	return this;
    }
	/** 栏目id **/
    private Integer lmId;
	/**
    * 获取属性:lmId
    * 栏目id
    * @return lmId
    */
	public Integer getLmId () {
    	return lmId;
   	}
   	/**
     * 设置属性:lmId
     * 栏目id
     * @param lmId
     */
    public NewsQuery setLmId(Integer lmId) {
    	this.lmId = lmId;
    	return this;
    }
	/** 来源 **/
    private String source;
	/**
    * 获取属性:source
    * 来源
    * @return source
    */
	public String getSource () {
    	return source;
   	}
   	/**
     * 设置属性:source
     * 来源
     * @param source
     */
    public NewsQuery setSource(String source) {
    	this.source = source;
    	return this;
    }
	/** 封面图片 **/
    private String coverImg;
	/**
    * 获取属性:coverImg
    * 封面图片
    * @return coverImg
    */
	public String getCoverImg () {
    	return coverImg;
   	}
   	/**
     * 设置属性:coverImg
     * 封面图片
     * @param coverImg
     */
    public NewsQuery setCoverImg(String coverImg) {
    	this.coverImg = coverImg;
    	return this;
    }
	/** url1,url2,url3 **/
    private String images;
	/**
    * 获取属性:images
    * url1,url2,url3
    * @return images
    */
	public String getImages () {
    	return images;
   	}
   	/**
     * 设置属性:images
     * url1,url2,url3
     * @param images
     */
    public NewsQuery setImages(String images) {
    	this.images = images;
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
    public NewsQuery setModifyTime(Integer modifyTime) {
    	this.modifyTime = modifyTime;
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
    public NewsQuery setCreateTime(Integer createTime) {
    	this.createTime = createTime;
    	return this;
    }
	/** 新闻显示的时间 **/
    private Integer sendTime;
	/**
    * 获取属性:sendTime
    * 新闻显示的时间
    * @return sendTime
    */
	public Integer getSendTime () {
    	return sendTime;
   	}
   	/**
     * 设置属性:sendTime
     * 新闻显示的时间
     * @param sendTime
     */
    public NewsQuery setSendTime(Integer sendTime) {
    	this.sendTime = sendTime;
    	return this;
    }
	/** cmt_num_lv5 **/
    private Integer cmtNumLv5;
	/**
    * 获取属性:cmtNumLv5
    * cmt_num_lv5
    * @return cmtNumLv5
    */
	public Integer getCmtNumLv5 () {
    	return cmtNumLv5;
   	}
   	/**
     * 设置属性:cmtNumLv5
     * cmt_num_lv5
     * @param cmtNumLv5
     */
    public NewsQuery setCmtNumLv5(Integer cmtNumLv5) {
    	this.cmtNumLv5 = cmtNumLv5;
    	return this;
    }
	/** 怨 **/
    private Integer cmtNumLv4;
	/**
    * 获取属性:cmtNumLv4
    * 怨
    * @return cmtNumLv4
    */
	public Integer getCmtNumLv4 () {
    	return cmtNumLv4;
   	}
   	/**
     * 设置属性:cmtNumLv4
     * 怨
     * @param cmtNumLv4
     */
    public NewsQuery setCmtNumLv4(Integer cmtNumLv4) {
    	this.cmtNumLv4 = cmtNumLv4;
    	return this;
    }
	/** 哀 **/
    private Integer cmtNumLv3;
	/**
    * 获取属性:cmtNumLv3
    * 哀
    * @return cmtNumLv3
    */
	public Integer getCmtNumLv3 () {
    	return cmtNumLv3;
   	}
   	/**
     * 设置属性:cmtNumLv3
     * 哀
     * @param cmtNumLv3
     */
    public NewsQuery setCmtNumLv3(Integer cmtNumLv3) {
    	this.cmtNumLv3 = cmtNumLv3;
    	return this;
    }
	/** 怒 **/
    private Integer cmtNumLv2;
	/**
    * 获取属性:cmtNumLv2
    * 怒
    * @return cmtNumLv2
    */
	public Integer getCmtNumLv2 () {
    	return cmtNumLv2;
   	}
   	/**
     * 设置属性:cmtNumLv2
     * 怒
     * @param cmtNumLv2
     */
    public NewsQuery setCmtNumLv2(Integer cmtNumLv2) {
    	this.cmtNumLv2 = cmtNumLv2;
    	return this;
    }
	/** 喜 **/
    private Integer cmtNumLv1;
	/**
    * 获取属性:cmtNumLv1
    * 喜
    * @return cmtNumLv1
    */
	public Integer getCmtNumLv1 () {
    	return cmtNumLv1;
   	}
   	/**
     * 设置属性:cmtNumLv1
     * 喜
     * @param cmtNumLv1
     */
    public NewsQuery setCmtNumLv1(Integer cmtNumLv1) {
    	this.cmtNumLv1 = cmtNumLv1;
    	return this;
    }
	/** cmt_num **/
    private Integer cmtNum;
	/**
    * 获取属性:cmtNum
    * cmt_num
    * @return cmtNum
    */
	public Integer getCmtNum () {
    	return cmtNum;
   	}
   	/**
     * 设置属性:cmtNum
     * cmt_num
     * @param cmtNum
     */
    public NewsQuery setCmtNum(Integer cmtNum) {
    	this.cmtNum = cmtNum;
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
	public NewsQuery orderbyId(boolean isAsc){
		orderFields.add(new OrderField("id",isAsc?"ASC":"DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：首页短标题
	 * @param isAsc 是否升序，否则为降序
	 */	
	public NewsQuery orderbyShortTitle(boolean isAsc){
		orderFields.add(new OrderField("short_title",isAsc?"ASC":"DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：title
	 * @param isAsc 是否升序，否则为降序
	 */	
	public NewsQuery orderbyTitle(boolean isAsc){
		orderFields.add(new OrderField("title",isAsc?"ASC":"DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：content
	 * @param isAsc 是否升序，否则为降序
	 */	
	public NewsQuery orderbyContent(boolean isAsc){
		orderFields.add(new OrderField("content",isAsc?"ASC":"DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：频道id
	 * @param isAsc 是否升序，否则为降序
	 */	
	public NewsQuery orderbyPdId(boolean isAsc){
		orderFields.add(new OrderField("pd_id",isAsc?"ASC":"DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：栏目id
	 * @param isAsc 是否升序，否则为降序
	 */	
	public NewsQuery orderbyLmId(boolean isAsc){
		orderFields.add(new OrderField("lm_id",isAsc?"ASC":"DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：来源
	 * @param isAsc 是否升序，否则为降序
	 */	
	public NewsQuery orderbySource(boolean isAsc){
		orderFields.add(new OrderField("source",isAsc?"ASC":"DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：封面图片
	 * @param isAsc 是否升序，否则为降序
	 */	
	public NewsQuery orderbyCoverImg(boolean isAsc){
		orderFields.add(new OrderField("cover_img",isAsc?"ASC":"DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：0不在列表页展现图片，1展现
	 * @param isAsc 是否升序，否则为降序
	 */	
	public NewsQuery orderbyShowCover(boolean isAsc){
		orderFields.add(new OrderField("show_cover",isAsc?"ASC":"DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：url1,url2,url3
	 * @param isAsc 是否升序，否则为降序
	 */	
	public NewsQuery orderbyImages(boolean isAsc){
		orderFields.add(new OrderField("images",isAsc?"ASC":"DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：0show 1disable
	 * @param isAsc 是否升序，否则为降序
	 */	
	public NewsQuery orderbyShowComment(boolean isAsc){
		orderFields.add(new OrderField("show_comment",isAsc?"ASC":"DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：modify_time
	 * @param isAsc 是否升序，否则为降序
	 */	
	public NewsQuery orderbyModifyTime(boolean isAsc){
		orderFields.add(new OrderField("modify_time",isAsc?"ASC":"DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：create_time
	 * @param isAsc 是否升序，否则为降序
	 */	
	public NewsQuery orderbyCreateTime(boolean isAsc){
		orderFields.add(new OrderField("create_time",isAsc?"ASC":"DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：新闻显示的时间
	 * @param isAsc 是否升序，否则为降序
	 */	
	public NewsQuery orderbySendTime(boolean isAsc){
		orderFields.add(new OrderField("send_time",isAsc?"ASC":"DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：cmt_num_lv5
	 * @param isAsc 是否升序，否则为降序
	 */	
	public NewsQuery orderbyCmtNumLv5(boolean isAsc){
		orderFields.add(new OrderField("cmt_num_lv5",isAsc?"ASC":"DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：怨
	 * @param isAsc 是否升序，否则为降序
	 */	
	public NewsQuery orderbyCmtNumLv4(boolean isAsc){
		orderFields.add(new OrderField("cmt_num_lv4",isAsc?"ASC":"DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：哀
	 * @param isAsc 是否升序，否则为降序
	 */	
	public NewsQuery orderbyCmtNumLv3(boolean isAsc){
		orderFields.add(new OrderField("cmt_num_lv3",isAsc?"ASC":"DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：怒
	 * @param isAsc 是否升序，否则为降序
	 */	
	public NewsQuery orderbyCmtNumLv2(boolean isAsc){
		orderFields.add(new OrderField("cmt_num_lv2",isAsc?"ASC":"DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：喜
	 * @param isAsc 是否升序，否则为降序
	 */	
	public NewsQuery orderbyCmtNumLv1(boolean isAsc){
		orderFields.add(new OrderField("cmt_num_lv1",isAsc?"ASC":"DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：cmt_num
	 * @param isAsc 是否升序，否则为降序
	 */	
	public NewsQuery orderbyCmtNum(boolean isAsc){
		orderFields.add(new OrderField("cmt_num",isAsc?"ASC":"DESC"));
		return this;
	}
}
