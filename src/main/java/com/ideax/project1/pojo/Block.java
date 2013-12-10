package com.ideax.project1.pojo;

import java.util.List;
import java.io.Serializable;

/**
 *
 * @author xuxin03
 */
public class Block implements Serializable{

	/** 序列化ID */
	private static final long serialVersionUID = 1L;

	/** id **/
    private Integer id;
	/** block_group **/
    private Integer blockGroup;
	/** order_num **/
    private Integer orderNum;
	/** 1首页 **/
    private Integer pageId;
	/** block_name **/
    private String blockName;
	/** url **/
    private String url;
	/** title **/
    private String title;
	/** html **/
    private String html;
	/** template **/
    private String template;
	/** 0其他链接, 1其他图片链接, 2本站新闻链接,3本站图片新闻链接 4 静态块 **/
    private Byte type;
	/** 0 false 1 true **/
    private Byte isBold;
	/** newsid **/
    private Integer newsId;
	/** image_url **/
    private String img;
	/** create_time **/
    private Integer createTime;
	/** modify_time **/
    private Integer modifyTime;

	
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
    * 获取属性:blockGroup
    * block_group
    * @return blockGroup
    */
   public Integer getBlockGroup() {
       return blockGroup;
   }
   /**
    * 设置属性:blockGroup
    * block_group
    * @param blockGroup
    */
   public void setBlockGroup(Integer blockGroup) {
       this.blockGroup = blockGroup;
   }
	
   /**
    * 获取属性:orderNum
    * order_num
    * @return orderNum
    */
   public Integer getOrderNum() {
       return orderNum;
   }
   /**
    * 设置属性:orderNum
    * order_num
    * @param orderNum
    */
   public void setOrderNum(Integer orderNum) {
       this.orderNum = orderNum;
   }
	
   /**
    * 获取属性:pageId
    * 1首页
    * @return pageId
    */
   public Integer getPageId() {
       return pageId;
   }
   /**
    * 设置属性:pageId
    * 1首页
    * @param pageId
    */
   public void setPageId(Integer pageId) {
       this.pageId = pageId;
   }
	
   /**
    * 获取属性:blockName
    * block_name
    * @return blockName
    */
   public String getBlockName() {
       return blockName;
   }
   /**
    * 设置属性:blockName
    * block_name
    * @param blockName
    */
   public void setBlockName(String blockName) {
       this.blockName = blockName;
   }
	
   /**
    * 获取属性:url
    * url
    * @return url
    */
   public String getUrl() {
       return url;
   }
   /**
    * 设置属性:url
    * url
    * @param url
    */
   public void setUrl(String url) {
       this.url = url;
   }
	
   /**
    * 获取属性:title
    * title
    * @return title
    */
   public String getTitle() {
       return title;
   }
   /**
    * 设置属性:title
    * title
    * @param title
    */
   public void setTitle(String title) {
       this.title = title;
   }
	
   /**
    * 获取属性:html
    * html
    * @return html
    */
   public String getHtml() {
       return html;
   }
   /**
    * 设置属性:html
    * html
    * @param html
    */
   public void setHtml(String html) {
       this.html = html;
   }
	
   /**
    * 获取属性:template
    * template
    * @return template
    */
   public String getTemplate() {
       return template;
   }
   /**
    * 设置属性:template
    * template
    * @param template
    */
   public void setTemplate(String template) {
       this.template = template;
   }
	
   /**
    * 获取属性:type
    * 0其他链接, 1其他图片链接, 2本站新闻链接,3本站图片新闻链接 4 静态块
    * @return type
    */
   public Byte getType() {
       return type;
   }
   /**
    * 设置属性:type
    * 0其他链接, 1其他图片链接, 2本站新闻链接,3本站图片新闻链接 4 静态块
    * @param type
    */
   public void setType(Byte type) {
       this.type = type;
   }
	
   /**
    * 获取属性:isBold
    * 0 false 1 true
    * @return isBold
    */
   public Byte getIsBold() {
       return isBold;
   }
   /**
    * 设置属性:isBold
    * 0 false 1 true
    * @param isBold
    */
   public void setIsBold(Byte isBold) {
       this.isBold = isBold;
   }
	
   /**
    * 获取属性:newsId
    * newsid
    * @return newsId
    */
   public Integer getNewsId() {
       return newsId;
   }
   /**
    * 设置属性:newsId
    * newsid
    * @param newsId
    */
   public void setNewsId(Integer newsId) {
       this.newsId = newsId;
   }
	
   /**
    * 获取属性:img
    * image_url
    * @return img
    */
   public String getImg() {
       return img;
   }
   /**
    * 设置属性:img
    * image_url
    * @param img
    */
   public void setImg(String img) {
       this.img = img;
   }
	
   /**
    * 获取属性:createTime
    * create_time
    * @return createTime
    */
   public Integer getCreateTime() {
       return createTime;
   }
   /**
    * 设置属性:createTime
    * create_time
    * @param createTime
    */
   public void setCreateTime(Integer createTime) {
       this.createTime = createTime;
   }
	
   /**
    * 获取属性:modifyTime
    * modify_time
    * @return modifyTime
    */
   public Integer getModifyTime() {
       return modifyTime;
   }
   /**
    * 设置属性:modifyTime
    * modify_time
    * @param modifyTime
    */
   public void setModifyTime(Integer modifyTime) {
       this.modifyTime = modifyTime;
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