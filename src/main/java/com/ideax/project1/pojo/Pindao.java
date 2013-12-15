package com.ideax.project1.pojo;

import java.util.List;
import java.io.Serializable;

/**
 *
 * @author 王永玲
 */
public class Pindao implements Serializable{

	/** 序列化ID */
	private static final long serialVersionUID = 1L;

	/** id **/
    private Integer id;
	/** name **/
    private String name;
	/** order_num **/
    private Integer orderNum;
	/** logo **/
    private String logo;
	/** color **/
    private String color;
	/** css_style **/
    private String cssStyle;
	/** page_id **/
    private Integer pageId;

	
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
    * 获取属性:name
    * name
    * @return name
    */
   public String getName() {
       return name;
   }
   /**
    * 设置属性:name
    * name
    * @param name
    */
   public void setName(String name) {
       this.name = name;
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
    * 获取属性:logo
    * logo
    * @return logo
    */
   public String getLogo() {
       return logo;
   }
   /**
    * 设置属性:logo
    * logo
    * @param logo
    */
   public void setLogo(String logo) {
       this.logo = logo;
   }
	
   /**
    * 获取属性:color
    * color
    * @return color
    */
   public String getColor() {
       return color;
   }
   /**
    * 设置属性:color
    * color
    * @param color
    */
   public void setColor(String color) {
       this.color = color;
   }
	
   /**
    * 获取属性:cssStyle
    * css_style
    * @return cssStyle
    */
   public String getCssStyle() {
       return cssStyle;
   }
   /**
    * 设置属性:cssStyle
    * css_style
    * @param cssStyle
    */
   public void setCssStyle(String cssStyle) {
       this.cssStyle = cssStyle;
   }
	
   /**
    * 获取属性:pageId
    * page_id
    * @return pageId
    */
   public Integer getPageId() {
       return pageId;
   }
   /**
    * 设置属性:pageId
    * page_id
    * @param pageId
    */
   public void setPageId(Integer pageId) {
       this.pageId = pageId;
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