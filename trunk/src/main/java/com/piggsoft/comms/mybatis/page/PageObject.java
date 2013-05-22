/**
 * 
 */
package com.piggsoft.comms.mybatis.page;


/**
 * @author piggsoft
 * @date 2013-5-18 11:01:35
 */
public class PageObject extends AbstactPageObject{
	/**
	 * 
	 */
	private int pageSize = 10; // 每页默认10条数据
	private int currentPage = 1; // 当前页
	private int totalPages = 0; // 总页数
	private int totalRows = 0; // 总数据数
	private int pageStartRow = 0; // 每页的起始行数
	private int pageEndRow = 0; // 每页显示数据的终止行数
	private boolean pagination=false;   //是否分页
	private boolean hasNextPage = false; // 是否有下一页
	private boolean hasPreviousPage = false; // 是否有前一页
	
	public PageObject(int rows, int pageSize, Object obj) {
		this.init(rows, pageSize);
	}
	
	public PageObject(int rows, int pageSize, int currentPage) {
		this.init(rows, pageSize, currentPage);
	}

	public PageObject(int pageSize, int currentPage) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.setOffset(0);
		this.setLimit(this.pageSize);
	}
	
	public PageObject(int currentPage) {
		this.currentPage = currentPage;
		this.setOffset(0);
		this.setLimit(this.pageSize);
	}
	
	public PageObject() {
		this.setOffset(0);
		this.setLimit(this.pageSize);
	}

	/**
	 * 初始化分页参数:需要先设置totalRows
	 * 
	 */

	public void init(int rows, int pageSize) {

		this.pageSize = pageSize;

		this.totalRows = rows;

		if ((totalRows % pageSize) == 0) {
			totalPages = totalRows / pageSize;
		} else {
			totalPages = totalRows / pageSize + 1;
		}
		super.setLimit(this.pageSize);
		super.setOffset(this.pageStartRow);
	}
	
	@Override
	public void initByCountRecords(int count) {
		this.init(count, this.pageSize, this.currentPage);
	}
	
	 public void init(int rows, int pageSize,int currentPage ) {

			this.pageSize = pageSize;

			this.totalRows = rows;

			if ((totalRows % pageSize) == 0) {
				totalPages = totalRows / pageSize;
			} else {
				totalPages = totalRows / pageSize + 1;
			}
			
			gotoPage(currentPage);
	        
	        super.setLimit(this.pageSize);
			super.setOffset(this.pageStartRow);
		}
	/**
	 * 计算当前页的取值范围：pageStartRow和pageEndRow
	 * 
	 */
	private void calculatePage() {
		
		currentPage = currentPage <= 0 ? 1 : currentPage;
		currentPage = currentPage >= totalPages ? totalPages : currentPage;
		
		if ((currentPage - 1) > 0) {
			hasPreviousPage = true;
		} else {
			hasPreviousPage = false;
		}

		if (currentPage >= totalPages) {
			hasNextPage = false;
		} else {
			hasNextPage = true;
		}

		if (currentPage * pageSize < totalRows) { // 判断是否为最后一页
			pageEndRow = currentPage * pageSize;
			pageStartRow = pageEndRow - pageSize;
		} else {
			pageEndRow = totalRows;
			pageStartRow = pageSize * (totalPages - 1);
		}
		
	}
	
	/**
	 * 直接跳转到指定页数的页面
	 * 
	 * @param page
	 */
	public void gotoPage(int page) {

		currentPage = page;

		calculatePage();

	}

	/**
	 * @return
	 */
	public int getCurrentPage() {
		return currentPage;
	}

	/**
	 * @return
	 */
	public boolean isHasNextPage() {
		return hasNextPage;
	}

	/**
	 * @return
	 */
	public boolean isHasPreviousPage() {
		return hasPreviousPage;
	}

	/**
	 * @return
	 */
	public int getPageEndRow() {
		return pageEndRow;
	}

	/**
	 * @return
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @return
	 */
	public int getPageStartRow() {
		return pageStartRow;
	}

	/**
	 * @return
	 */
	public int getTotalPages() {
		return totalPages;
	}

	/**
	 * @return
	 */
	public int getTotalRows() {
		return totalRows;
	}
	
	/**
	 * @param i
	 */
	public void setTotalPages(int i) {
		totalPages = i;
	}

	/**
	 * @param i
	 */
	public void setCurrentPage(int i) {
		currentPage = i;
	}

	/**
	 * @param b
	 */
	public void setHasNextPage(boolean b) {
		hasNextPage = b;
	}

	/**
	 * @param b
	 */
	public void setHasPreviousPage(boolean b) {
		hasPreviousPage = b;
	}

	/**
	 * @param i
	 */
	public void setPageEndRow(int i) {
		pageEndRow = i;
	}

	/**
	 * @param i
	 */
	public void setPageSize(int i) {
		pageSize = i;
	}

	/**
	 * @param i
	 */
	public void setPageStartRow(int i) {
		pageStartRow = i;
	}

	

	/**
	 * @param i
	 */
	public void setTotalRows(int i) {
		totalRows = i;
	}

	public boolean isPagination() {
		return pagination;
	}

	public void setPagination(boolean pagination) {
		this.pagination = pagination;
	}
	
}
