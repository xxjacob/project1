package com.ideax.project1.pojo;

import java.util.List;
import java.io.Serializable;

/**
 *
 * @author xxjacob
 */
public class Lanmu implements Serializable{

	/** 序列化ID */
	private static final long serialVersionUID = 1L;

	/** id **/
    private Integer id;
	/** name **/
    private String name;
	/** pd_id **/
    private Integer pdId;
	/** order_num **/
    private Integer orderNum;
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
    * 获取属性:pdId
    * pd_id
    * @return pdId
    */
   public Integer getPdId() {
       return pdId;
   }
   /**
    * 设置属性:pdId
    * pd_id
    * @param pdId
    */
   public void setPdId(Integer pdId) {
       this.pdId = pdId;
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