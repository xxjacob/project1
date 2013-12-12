package com.ideax.project1.pojo;

import java.util.List;
import java.io.Serializable;

/**
 *
 * @author 王永玲
 */
public class User implements Serializable{

	/** 序列化ID */
	private static final long serialVersionUID = 1L;

	/** uid **/
    private Integer id;
	/** 用户openid **/
    private String openid;
	/** 昵称 **/
    private String nickname;
	/** 性别 **/
    private Byte gender;
	/** 出生年 **/
    private Integer birthY;
	/** 出生月日 1005 **/
    private Integer birthMd;
	/** 头像 **/
    private String figureurl;
	/** 区域代码ppcccccctttttt **/
    private Long region;
	/** 简介 **/
    private String introduce;
	/** 0 单身，1 恋爱中 **/
    private Byte loveStatus;
	/** height **/
    private Integer height;
	/** 学历,1 高中，2大专，3本科，4硕士，5博士，6博士后 **/
    private Byte education;
	/** 1 a 2b 3ab 4o 5其他 **/
    private Byte bloodGroup;
	/** 收入 **/
    private Byte earning;
	/** profession **/
    private Byte profession;
	/** 无房，有房，准备购房 **/
    private Byte houseStatus;
	/** 无车，有车，准备购车 **/
    private Byte carStatus;
	/** 0 未激活,1 未完善, 2,可用 **/
    private Byte status;
	/** create_time **/
    private Integer createTime;
	/** modify_time **/
    private Integer modifyTime;
	/** 邀请者 **/
    private String invitor;

	
   /**
    * 获取属性:id
    * uid
    * @return id
    */
   public Integer getId() {
       return id;
   }
   /**
    * 设置属性:id
    * uid
    * @param id
    */
   public void setId(Integer id) {
       this.id = id;
   }
	
   /**
    * 获取属性:openid
    * 用户openid
    * @return openid
    */
   public String getOpenid() {
       return openid;
   }
   /**
    * 设置属性:openid
    * 用户openid
    * @param openid
    */
   public void setOpenid(String openid) {
       this.openid = openid;
   }
	
   /**
    * 获取属性:nickname
    * 昵称
    * @return nickname
    */
   public String getNickname() {
       return nickname;
   }
   /**
    * 设置属性:nickname
    * 昵称
    * @param nickname
    */
   public void setNickname(String nickname) {
       this.nickname = nickname;
   }
	
   /**
    * 获取属性:gender
    * 性别
    * @return gender
    */
   public Byte getGender() {
       return gender;
   }
   /**
    * 设置属性:gender
    * 性别
    * @param gender
    */
   public void setGender(Byte gender) {
       this.gender = gender;
   }
	
   /**
    * 获取属性:birthY
    * 出生年
    * @return birthY
    */
   public Integer getBirthY() {
       return birthY;
   }
   /**
    * 设置属性:birthY
    * 出生年
    * @param birthY
    */
   public void setBirthY(Integer birthY) {
       this.birthY = birthY;
   }
	
   /**
    * 获取属性:birthMd
    * 出生月日 1005
    * @return birthMd
    */
   public Integer getBirthMd() {
       return birthMd;
   }
   /**
    * 设置属性:birthMd
    * 出生月日 1005
    * @param birthMd
    */
   public void setBirthMd(Integer birthMd) {
       this.birthMd = birthMd;
   }
	
   /**
    * 获取属性:figureurl
    * 头像
    * @return figureurl
    */
   public String getFigureurl() {
       return figureurl;
   }
   /**
    * 设置属性:figureurl
    * 头像
    * @param figureurl
    */
   public void setFigureurl(String figureurl) {
       this.figureurl = figureurl;
   }
	
   /**
    * 获取属性:region
    * 区域代码ppcccccctttttt
    * @return region
    */
   public Long getRegion() {
       return region;
   }
   /**
    * 设置属性:region
    * 区域代码ppcccccctttttt
    * @param region
    */
   public void setRegion(Long region) {
       this.region = region;
   }
	
   /**
    * 获取属性:introduce
    * 简介
    * @return introduce
    */
   public String getIntroduce() {
       return introduce;
   }
   /**
    * 设置属性:introduce
    * 简介
    * @param introduce
    */
   public void setIntroduce(String introduce) {
       this.introduce = introduce;
   }
	
   /**
    * 获取属性:loveStatus
    * 0 单身，1 恋爱中
    * @return loveStatus
    */
   public Byte getLoveStatus() {
       return loveStatus;
   }
   /**
    * 设置属性:loveStatus
    * 0 单身，1 恋爱中
    * @param loveStatus
    */
   public void setLoveStatus(Byte loveStatus) {
       this.loveStatus = loveStatus;
   }
	
   /**
    * 获取属性:height
    * height
    * @return height
    */
   public Integer getHeight() {
       return height;
   }
   /**
    * 设置属性:height
    * height
    * @param height
    */
   public void setHeight(Integer height) {
       this.height = height;
   }
	
   /**
    * 获取属性:education
    * 学历,1 高中，2大专，3本科，4硕士，5博士，6博士后
    * @return education
    */
   public Byte getEducation() {
       return education;
   }
   /**
    * 设置属性:education
    * 学历,1 高中，2大专，3本科，4硕士，5博士，6博士后
    * @param education
    */
   public void setEducation(Byte education) {
       this.education = education;
   }
	
   /**
    * 获取属性:bloodGroup
    * 1 a 2b 3ab 4o 5其他
    * @return bloodGroup
    */
   public Byte getBloodGroup() {
       return bloodGroup;
   }
   /**
    * 设置属性:bloodGroup
    * 1 a 2b 3ab 4o 5其他
    * @param bloodGroup
    */
   public void setBloodGroup(Byte bloodGroup) {
       this.bloodGroup = bloodGroup;
   }
	
   /**
    * 获取属性:earning
    * 收入
    * @return earning
    */
   public Byte getEarning() {
       return earning;
   }
   /**
    * 设置属性:earning
    * 收入
    * @param earning
    */
   public void setEarning(Byte earning) {
       this.earning = earning;
   }
	
   /**
    * 获取属性:profession
    * profession
    * @return profession
    */
   public Byte getProfession() {
       return profession;
   }
   /**
    * 设置属性:profession
    * profession
    * @param profession
    */
   public void setProfession(Byte profession) {
       this.profession = profession;
   }
	
   /**
    * 获取属性:houseStatus
    * 无房，有房，准备购房
    * @return houseStatus
    */
   public Byte getHouseStatus() {
       return houseStatus;
   }
   /**
    * 设置属性:houseStatus
    * 无房，有房，准备购房
    * @param houseStatus
    */
   public void setHouseStatus(Byte houseStatus) {
       this.houseStatus = houseStatus;
   }
	
   /**
    * 获取属性:carStatus
    * 无车，有车，准备购车
    * @return carStatus
    */
   public Byte getCarStatus() {
       return carStatus;
   }
   /**
    * 设置属性:carStatus
    * 无车，有车，准备购车
    * @param carStatus
    */
   public void setCarStatus(Byte carStatus) {
       this.carStatus = carStatus;
   }
	
   /**
    * 获取属性:status
    * 0 未激活,1 未完善, 2,可用
    * @return status
    */
   public Byte getStatus() {
       return status;
   }
   /**
    * 设置属性:status
    * 0 未激活,1 未完善, 2,可用
    * @param status
    */
   public void setStatus(Byte status) {
       this.status = status;
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
    * 获取属性:invitor
    * 邀请者
    * @return invitor
    */
   public String getInvitor() {
       return invitor;
   }
   /**
    * 设置属性:invitor
    * 邀请者
    * @param invitor
    */
   public void setInvitor(String invitor) {
       this.invitor = invitor;
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