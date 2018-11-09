package com.bora.page;

public class MakePager {
	
	private int curPage;
	private int perPage;
	private RowNumber rowNumber;
	private Search search;
	
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getPerPage() {
		return perPage;
	}
	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
	public RowNumber getRowNumber() {
		return rowNumber;
	}
	public void setRowNumber(RowNumber rowNumber) {
		this.rowNumber = rowNumber;
	}
	public Search getSearch() {
		return search;
	}
	public void setSearch(Search search) {
		this.search = search;
	}

}
