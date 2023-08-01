package em.domain;

import java.util.List;

public class PageBean<thing> {
	private int currPage; 
	private int pageSize; // num of records per page
	private int totalCount;
	private int totalPage;
	
	private List<thing> list;

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<thing> getList() {
		return list;
	}

	public void setList(List<thing> list) {
		this.list = list;
	}
	
}
