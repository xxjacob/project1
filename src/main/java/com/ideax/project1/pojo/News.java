package com.ideax.project1.pojo;

import java.util.List;
import java.io.Serializable;

/**
 *
 * @author 王永玲
 */
public class News implements Serializable{

	/** 序列化ID */
	private static final long serialVersionUID = 1L;

	/** id **/
    private Integer id;
	/** 首页短标题 **/
    private String shortTitle;
	/** title **/
    private String title;
	/** content **/
    private String content;
	/** 频道id **/
    private Integer pdId;
	/** 栏目id **/
    private Integer lmId;
	/** 来源 **/
    private String source;
	/** 封面图片 **/
    private String coverImg;
	/** 0不在列表页展现图片，1展现 **/
    private Byte showCover;
	/** url1,url2,url3 **/
    private String images;
	/** 0show 1disable **/
    private Byte showComment;
	/** 0 not 1yes **/
    private Byte showBold;
	/** modify_time **/
    private Integer modifyTime;
	/** create_time **/
    private Integer createTime;
	/** 新闻显示的时间 **/
    private Integer sendTime;
	/** cmt_num_lv5 **/
    private Integer cmtNumLv5;
	/** 怨 **/
    private Integer cmtNumLv4;
	/** 哀 **/
    private Integer cmtNumLv3;
	/** 怒 **/
    private Integer cmtNumLv2;
	/** 喜 **/
    private Integer cmtNumLv1;
	/** cmt_num **/
    private Integer cmtNum;
	/** 访问量 **/
    private Integer viewCount;

	
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
    * 获取属性:shortTitle
    * 首页短标题
    * @return shortTitle
    */
   public String getShortTitle() {
       return shortTitle;
   }
   /**
    * 设置属性:shortTitle
    * 首页短标题
    * @param shortTitle
    */
   public void setShortTitle(String shortTitle) {
       this.shortTitle = shortTitle;
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
    * 获取属性:pdId
    * 频道id
    * @return pdId
    */
   public Integer getPdId() {
       return pdId;
   }
   /**
    * 设置属性:pdId
    * 频道id
    * @param pdId
    */
   public void setPdId(Integer pdId) {
       this.pdId = pdId;
   }
	
   /**
    * 获取属性:lmId
    * 栏目id
    * @return lmId
    */
   public Integer getLmId() {
       return lmId;
   }
   /**
    * 设置属性:lmId
    * 栏目id
    * @param lmId
    */
   public void setLmId(Integer lmId) {
       this.lmId = lmId;
   }
	
   /**
    * 获取属性:source
    * 来源
    * @return source
    */
   public String getSource() {
       return source;
   }
   /**
    * 设置属性:source
    * 来源
    * @param source
    */
   public void setSource(String source) {
       this.source = source;
   }
	
   /**
    * 获取属性:coverImg
    * 封面图片
    * @return coverImg
    */
   public String getCoverImg() {
       return coverImg;
   }
   /**
    * 设置属性:coverImg
    * 封面图片
    * @param coverImg
    */
   public void setCoverImg(String coverImg) {
       this.coverImg = coverImg;
   }
	
   /**
    * 获取属性:showCover
    * 0不在列表页展现图片，1展现
    * @return showCover
    */
   public Byte getShowCover() {
       return showCover;
   }
   /**
    * 设置属性:showCover
    * 0不在列表页展现图片，1展现
    * @param showCover
    */
   public void setShowCover(Byte showCover) {
       this.showCover = showCover;
   }
	
   /**
    * 获取属性:images
    * url1,url2,url3
    * @return images
    */
   public String getImages() {
       return images;
   }
   /**
    * 设置属性:images
    * url1,url2,url3
    * @param images
    */
   public void setImages(String images) {
       this.images = images;
   }
	
   /**
    * 获取属性:showComment
    * 0show 1disable
    * @return showComment
    */
   public Byte getShowComment() {
       return showComment;
   }
   /**
    * 设置属性:showComment
    * 0show 1disable
    * @param showComment
    */
   public void setShowComment(Byte showComment) {
       this.showComment = showComment;
   }
	
   /**
    * 获取属性:showBold
    * 0 not 1yes
    * @return showBold
    */
   public Byte getShowBold() {
       return showBold;
   }
   /**
    * 设置属性:showBold
    * 0 not 1yes
    * @param showBold
    */
   public void setShowBold(Byte showBold) {
       this.showBold = showBold;
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
    * 获取属性:sendTime
    * 新闻显示的时间
    * @return sendTime
    */
   public Integer getSendTime() {
       return sendTime;
   }
   /**
    * 设置属性:sendTime
    * 新闻显示的时间
    * @param sendTime
    */
   public void setSendTime(Integer sendTime) {
       this.sendTime = sendTime;
   }
	
   /**
    * 获取属性:cmtNumLv5
    * cmt_num_lv5
    * @return cmtNumLv5
    */
   public Integer getCmtNumLv5() {
       return cmtNumLv5;
   }
   /**
    * 设置属性:cmtNumLv5
    * cmt_num_lv5
    * @param cmtNumLv5
    */
   public void setCmtNumLv5(Integer cmtNumLv5) {
       this.cmtNumLv5 = cmtNumLv5;
   }
	
   /**
    * 获取属性:cmtNumLv4
    * 怨
    * @return cmtNumLv4
    */
   public Integer getCmtNumLv4() {
       return cmtNumLv4;
   }
   /**
    * 设置属性:cmtNumLv4
    * 怨
    * @param cmtNumLv4
    */
   public void setCmtNumLv4(Integer cmtNumLv4) {
       this.cmtNumLv4 = cmtNumLv4;
   }
	
   /**
    * 获取属性:cmtNumLv3
    * 哀
    * @return cmtNumLv3
    */
   public Integer getCmtNumLv3() {
       return cmtNumLv3;
   }
   /**
    * 设置属性:cmtNumLv3
    * 哀
    * @param cmtNumLv3
    */
   public void setCmtNumLv3(Integer cmtNumLv3) {
       this.cmtNumLv3 = cmtNumLv3;
   }
	
   /**
    * 获取属性:cmtNumLv2
    * 怒
    * @return cmtNumLv2
    */
   public Integer getCmtNumLv2() {
       return cmtNumLv2;
   }
   /**
    * 设置属性:cmtNumLv2
    * 怒
    * @param cmtNumLv2
    */
   public void setCmtNumLv2(Integer cmtNumLv2) {
       this.cmtNumLv2 = cmtNumLv2;
   }
	
   /**
    * 获取属性:cmtNumLv1
    * 喜
    * @return cmtNumLv1
    */
   public Integer getCmtNumLv1() {
       return cmtNumLv1;
   }
   /**
    * 设置属性:cmtNumLv1
    * 喜
    * @param cmtNumLv1
    */
   public void setCmtNumLv1(Integer cmtNumLv1) {
       this.cmtNumLv1 = cmtNumLv1;
   }
	
   /**
    * 获取属性:cmtNum
    * cmt_num
    * @return cmtNum
    */
   public Integer getCmtNum() {
       return cmtNum;
   }
   /**
    * 设置属性:cmtNum
    * cmt_num
    * @param cmtNum
    */
   public void setCmtNum(Integer cmtNum) {
       this.cmtNum = cmtNum;
   }
	
   /**
    * 获取属性:viewCount
    * 访问量
    * @return viewCount
    */
   public Integer getViewCount() {
       return viewCount;
   }
   /**
    * 设置属性:viewCount
    * 访问量
    * @param viewCount
    */
   public void setViewCount(Integer viewCount) {
       this.viewCount = viewCount;
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