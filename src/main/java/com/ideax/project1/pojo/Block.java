package com.ideax.project1.pojo;

import java.util.List;
import java.io.Serializable;

/**
 *
 * @author 王永玲
 */
public class Block implements Serializable{

	/** 序列化ID */
	private static final long serialVersionUID = 1L;

	/** id **/
    private Integer id;
	/** block_group **/
    private String blockGroup;
	/** block_name **/
    private String blockName;
	/** url **/
    private String url;
	/** title **/
    private String title;
	/** html **/
    private String html;

	
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
   public String getBlockGroup() {
       return blockGroup;
   }
   /**
    * 设置属性:blockGroup
    * block_group
    * @param blockGroup
    */
   public void setBlockGroup(String blockGroup) {
       this.blockGroup = blockGroup;
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