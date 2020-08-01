package edu.lin.emp.util;

import java.util.List;

public class Pager<T> {
	private List<T> list;

	private Integer totalNum;

	private Integer totalPage;

	private Integer currentPage;

	private Integer pageSize;


	private Integer start;

	public Pager(Integer totalNum, Integer currentPage, Integer pageSize) {
		this.totalNum = totalNum;
		this.currentPage = currentPage;
		this.pageSize = pageSize;


		this.totalPage = totalNum % this.pageSize == 0 ? totalNum
				/ this.pageSize : (totalNum / this.pageSize) + 1;

		this.start = currentPage;

		//this.pageNo = pageNo + currentPage - 1 >= this.totalPage ? pageNo
		//		: this.totalPage - currentPage + 1;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public Integer getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

//	public Integer getPageNo() {
//		return pageNo;
//	}
//
//	public void setPageNo(Integer pageNo) {
//		this.pageNo = pageNo;
//	}

	@Override
	public String toString() {
		return "Pager [list=" + list + ", totalNum=" + totalNum
				+ ", totalPage=" + totalPage + ", currentPage=" + currentPage
				+ ", pageSize=" + pageSize + ", start=" + start + "]";
	}
	

}