package com.ideax.project1.query;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xuxin03
 */
public class UserQuery extends BaseQuery {
	
	/** ====================查询唯一单条记录使用==========================**/
	
	/**==============================批量查询、更新、删除时的Where条件设置==================================**/
	/** uid **/
    private Integer id;
	/**
    * 获取属性:id
    * uid
    * @return id
    */
	public Integer getId () {
    	return id;
   	}
   	/**
     * 设置属性:id
     * uid
     * @param id
     */
    public UserQuery setId(Integer id) {
    	this.id = id;
    	return this;
    }
	/** 用户openid **/
    private String openid;
	/**
    * 获取属性:openid
    * 用户openid
    * @return openid
    */
	public String getOpenid () {
    	return openid;
   	}
   	/**
     * 设置属性:openid
     * 用户openid
     * @param openid
     */
    public UserQuery setOpenid(String openid) {
    	this.openid = openid;
    	return this;
    }
	/** 昵称 **/
    private String nickname;
	/**
    * 获取属性:nickname
    * 昵称
    * @return nickname
    */
	public String getNickname () {
    	return nickname;
   	}
   	/**
     * 设置属性:nickname
     * 昵称
     * @param nickname
     */
    public UserQuery setNickname(String nickname) {
    	this.nickname = nickname;
    	return this;
    }
	/** 出生年 **/
    private Integer birthY;
	/**
    * 获取属性:birthY
    * 出生年
    * @return birthY
    */
	public Integer getBirthY () {
    	return birthY;
   	}
   	/**
     * 设置属性:birthY
     * 出生年
     * @param birthY
     */
    public UserQuery setBirthY(Integer birthY) {
    	this.birthY = birthY;
    	return this;
    }
	/** 出生月日 1005 **/
    private Integer birthMd;
	/**
    * 获取属性:birthMd
    * 出生月日 1005
    * @return birthMd
    */
	public Integer getBirthMd () {
    	return birthMd;
   	}
   	/**
     * 设置属性:birthMd
     * 出生月日 1005
     * @param birthMd
     */
    public UserQuery setBirthMd(Integer birthMd) {
    	this.birthMd = birthMd;
    	return this;
    }
	/** 头像 **/
    private String figureurl;
	/**
    * 获取属性:figureurl
    * 头像
    * @return figureurl
    */
	public String getFigureurl () {
    	return figureurl;
   	}
   	/**
     * 设置属性:figureurl
     * 头像
     * @param figureurl
     */
    public UserQuery setFigureurl(String figureurl) {
    	this.figureurl = figureurl;
    	return this;
    }
	/** 区域代码ppcccccctttttt **/
    private Long region;
	/**
    * 获取属性:region
    * 区域代码ppcccccctttttt
    * @return region
    */
	public Long getRegion () {
    	return region;
   	}
   	/**
     * 设置属性:region
     * 区域代码ppcccccctttttt
     * @param region
     */
    public UserQuery setRegion(Long region) {
    	this.region = region;
    	return this;
    }
	/** 简介 **/
    private String introduce;
	/**
    * 获取属性:introduce
    * 简介
    * @return introduce
    */
	public String getIntroduce () {
    	return introduce;
   	}
   	/**
     * 设置属性:introduce
     * 简介
     * @param introduce
     */
    public UserQuery setIntroduce(String introduce) {
    	this.introduce = introduce;
    	return this;
    }
	/** height **/
    private Integer height;
	/**
    * 获取属性:height
    * height
    * @return height
    */
	public Integer getHeight () {
    	return height;
   	}
   	/**
     * 设置属性:height
     * height
     * @param height
     */
    public UserQuery setHeight(Integer height) {
    	this.height = height;
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
    public UserQuery setCreateTime(Integer createTime) {
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
    public UserQuery setModifyTime(Integer modifyTime) {
    	this.modifyTime = modifyTime;
    	return this;
    }
	/** 邀请者 **/
    private String invitor;
	/**
    * 获取属性:invitor
    * 邀请者
    * @return invitor
    */
	public String getInvitor () {
    	return invitor;
   	}
   	/**
     * 设置属性:invitor
     * 邀请者
     * @param invitor
     */
    public UserQuery setInvitor(String invitor) {
    	this.invitor = invitor;
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
	 * 设置排序按属性：uid
	 * @param isAsc 是否升序，否则为降序
	 */	
	public UserQuery orderbyId(boolean isAsc){
		orderFields.add(new OrderField("id",isAsc?"ASC":"DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：用户openid
	 * @param isAsc 是否升序，否则为降序
	 */	
	public UserQuery orderbyOpenid(boolean isAsc){
		orderFields.add(new OrderField("openid",isAsc?"ASC":"DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：昵称
	 * @param isAsc 是否升序，否则为降序
	 */	
	public UserQuery orderbyNickname(boolean isAsc){
		orderFields.add(new OrderField("nickname",isAsc?"ASC":"DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：性别
	 * @param isAsc 是否升序，否则为降序
	 */	
	public UserQuery orderbyGender(boolean isAsc){
		orderFields.add(new OrderField("gender",isAsc?"ASC":"DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：出生年
	 * @param isAsc 是否升序，否则为降序
	 */	
	public UserQuery orderbyBirthY(boolean isAsc){
		orderFields.add(new OrderField("birth_y",isAsc?"ASC":"DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：出生月日 1005
	 * @param isAsc 是否升序，否则为降序
	 */	
	public UserQuery orderbyBirthMd(boolean isAsc){
		orderFields.add(new OrderField("birth_md",isAsc?"ASC":"DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：头像
	 * @param isAsc 是否升序，否则为降序
	 */	
	public UserQuery orderbyFigureurl(boolean isAsc){
		orderFields.add(new OrderField("figureurl",isAsc?"ASC":"DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：区域代码ppcccccctttttt
	 * @param isAsc 是否升序，否则为降序
	 */	
	public UserQuery orderbyRegion(boolean isAsc){
		orderFields.add(new OrderField("region",isAsc?"ASC":"DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：简介
	 * @param isAsc 是否升序，否则为降序
	 */	
	public UserQuery orderbyIntroduce(boolean isAsc){
		orderFields.add(new OrderField("introduce",isAsc?"ASC":"DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：0 单身，1 恋爱中
	 * @param isAsc 是否升序，否则为降序
	 */	
	public UserQuery orderbyLoveStatus(boolean isAsc){
		orderFields.add(new OrderField("love_status",isAsc?"ASC":"DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：height
	 * @param isAsc 是否升序，否则为降序
	 */	
	public UserQuery orderbyHeight(boolean isAsc){
		orderFields.add(new OrderField("height",isAsc?"ASC":"DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：学历,1 高中，2大专，3本科，4硕士，5博士，6博士后
	 * @param isAsc 是否升序，否则为降序
	 */	
	public UserQuery orderbyEducation(boolean isAsc){
		orderFields.add(new OrderField("education",isAsc?"ASC":"DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：1 a 2b 3ab 4o 5其他
	 * @param isAsc 是否升序，否则为降序
	 */	
	public UserQuery orderbyBloodGroup(boolean isAsc){
		orderFields.add(new OrderField("blood_group",isAsc?"ASC":"DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：收入
	 * @param isAsc 是否升序，否则为降序
	 */	
	public UserQuery orderbyEarning(boolean isAsc){
		orderFields.add(new OrderField("earning",isAsc?"ASC":"DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：profession
	 * @param isAsc 是否升序，否则为降序
	 */	
	public UserQuery orderbyProfession(boolean isAsc){
		orderFields.add(new OrderField("profession",isAsc?"ASC":"DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：无房，有房，准备购房
	 * @param isAsc 是否升序，否则为降序
	 */	
	public UserQuery orderbyHouseStatus(boolean isAsc){
		orderFields.add(new OrderField("house_status",isAsc?"ASC":"DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：无车，有车，准备购车
	 * @param isAsc 是否升序，否则为降序
	 */	
	public UserQuery orderbyCarStatus(boolean isAsc){
		orderFields.add(new OrderField("car_status",isAsc?"ASC":"DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：0 未激活,1 未完善, 2,可用
	 * @param isAsc 是否升序，否则为降序
	 */	
	public UserQuery orderbyStatus(boolean isAsc){
		orderFields.add(new OrderField("status",isAsc?"ASC":"DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：create_time
	 * @param isAsc 是否升序，否则为降序
	 */	
	public UserQuery orderbyCreateTime(boolean isAsc){
		orderFields.add(new OrderField("create_time",isAsc?"ASC":"DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：modify_time
	 * @param isAsc 是否升序，否则为降序
	 */	
	public UserQuery orderbyModifyTime(boolean isAsc){
		orderFields.add(new OrderField("modify_time",isAsc?"ASC":"DESC"));
		return this;
	}
	/**
	 * 设置排序按属性：邀请者
	 * @param isAsc 是否升序，否则为降序
	 */	
	public UserQuery orderbyInvitor(boolean isAsc){
		orderFields.add(new OrderField("invitor",isAsc?"ASC":"DESC"));
		return this;
	}
}
