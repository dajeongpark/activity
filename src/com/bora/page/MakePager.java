package com.bora.page;

import com.bora.page.Pager;
import com.bora.page.RowNumber;
import com.bora.page.Search;

public class MakePager {
	
	private int curPage;
	private int perPage;
	private RowNumber rowNumber;
	private Search search;
	
	public MakePager(int curPage, String search, String kind) {
		this(curPage, 9, search, kind); //생성자 안에서 다른 생성자 호출하기 // use this one instead
		
		/*this.curPage = curPage;
		this.search = new Search();
		this.search.setKind(kind);
		this.search.setSearch(search);
		this.perPage = 10; // 안 받아오면 기본값 10 */
	}
	
	public MakePager(int curPage, int perPage, String search, String kind) {
		this.curPage = curPage;
		this.search = new Search();
		this.search.setKind(kind);
		this.search.setSearch(search);
		this.perPage = perPage; // perPage 받아오기
	}
	
	public RowNumber makeRow() {
		rowNumber = new RowNumber();
		rowNumber.setStartRow((this.curPage-1)*this.perPage+1);
		rowNumber.setLastRow(this.curPage*this.perPage);
		rowNumber.setSearch(this.search);
		return rowNumber;
	}
				
	public Pager makePager(int totalCount) {
		//1. totalPage
		int totalPage = totalCount/this.perPage;
		if(totalCount%this.perPage != 0) {
			totalPage++;
		}
		
		//2. totalBlock
		int perBlock = 5;
		int totalBlock = totalPage/perBlock;
		if(totalPage%perBlock != 0) {
			totalBlock++;
		}
		
		//3. curBlock
		int curBlock = this.curPage/perBlock;
		if(curPage%perBlock != 0) {
			curBlock++;
		}
		
		//4. startNum, lastNum
		int startNum = (curBlock-1)*perBlock+1;
		int lastNum = curBlock*perBlock;
		
		//5. curBlock 마지막 Block
		if(curBlock == totalBlock) {
			lastNum = totalPage;
		}
		
		Pager pager = new Pager();
		pager.setCurBlock(curBlock);
		pager.setTotalBlock(totalBlock);
		pager.setStartNum(startNum);
		pager.setLastNum(lastNum);
		pager.setSearch(this.search);
		pager.setTotalPage(totalPage);
		
		return pager;
	}

}
