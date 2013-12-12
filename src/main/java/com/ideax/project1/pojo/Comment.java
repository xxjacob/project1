package com.ideax.project1.pojo;

import java.util.List;
import java.io.Serializable;

/**
 *
 * @author xuxin03
 */
public class Comment implements Serializable{

	/** 序列化ID */
	private static final long serialVersionUID = 1L;

	/** id **/
    private Integer id;
	/** news_id **/
    private Integer newsId;
	/** content **/
    private String content;
	/** create_time **/
    private Integer createTime;
	/** id1,id2,id3 **/
    private String replyTo;
	/** 来自什么设备 **/
    private String device;
	/** ip **/
    private String ip;
	/** modify_time **/
    private Integer modifyTime;
	/** 楼层 **/
    private Integer floor;

	
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
    * 获取属性:newsId
    * news_id
    * @return newsId
    */
   public Integer getNewsId() {
       return newsId;
   }
   /**
    * 设置属性:newsId
    * news_id
    * @param newsId
    */
   public void setNewsId(Integer newsId) {
       this.newsId = newsId;
   }
	
   /**
    * 获取属性:content
    * content
    * @return content
    */
   public String getContent() {
       return content;
   }
   /**
    * 设置属性:content
    * content
    * @param content
    */
   public void setContent(String content) {
       this.content = content;
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
    * 获取属性:replyTo
    * id1,id2,id3
    * @return replyTo
    */
   public String getReplyTo() {
       return replyTo;
   }
   /**
    * 设置属性:replyTo
    * id1,id2,id3
    * @param replyTo
    */
   public void setReplyTo(String replyTo) {
       this.replyTo = replyTo;
   }
	
   /**
    * 获取属性:device
    * 来自什么设备
    * @return device
    */
   public String getDevice() {
       return device;
   }
   /**
    * 设置属性:device
    * 来自什么设备
    * @param device
    */
   public void setDevice(String device) {
       this.device = device;
   }
	
   /**
    * 获取属性:ip
    * ip
    * @return ip
    */
   public String getIp() {
       return ip;
   }
   /**
    * 设置属性:ip
    * ip
    * @param ip
    */
   public void setIp(String ip) {
       this.ip = ip;
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
    * 获取属性:floor
    * 楼层
    * @return floor
    */
   public Integer getFloor() {
       return floor;
   }
   /**
    * 设置属性:floor
    * 楼层
    * @param floor
    */
   public void setFloor(Integer floor) {
       this.floor = floor;
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