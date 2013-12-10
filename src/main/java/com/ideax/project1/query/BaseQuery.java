package com.ideax.project1.query;

/**
 * @author xuxin03
 */
public class BaseQuery {
	public final static int DEFAULT_SIZE = 10;
	protected Integer pageSize = DEFAULT_SIZE;
	protected Integer startRow;//起始行
	protected Integer endRow;//结束行(闭合)
	protected Integer page;
	public Integer getStartRow() {
		return startRow;
	}
	public BaseQuery setStartRow(Integer startRow) {
		this.startRow = startRow;
		return this;
	}
	public Integer getEndRow() {
		return endRow;
	}
	public BaseQuery setEndRow(Integer endRow) {
		this.endRow = endRow;
		return this;
	}
	public BaseQuery setPage(Integer page) {
		this.page = page;
		this.startRow = (page-1)*this.pageSize;
		this.endRow= this.startRow + this.pageSize - 1;
		return this;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public BaseQuery setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
		return this;
	}
	public Integer getPage() {
		return page;
	}
}
