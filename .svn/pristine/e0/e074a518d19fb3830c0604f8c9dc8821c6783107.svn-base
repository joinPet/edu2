package egovframework.com.cmm.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import egovframework.com.cmm.paging.PaginationInfo;

public class PagingTag extends SimpleTagSupport {

	private PaginationInfo paginationInfo;
	private String type;
	private String jsFunction;

	public void setJsFunction(String jsFunction) {
		this.jsFunction = jsFunction;
	}

	public void setPaginationInfo(PaginationInfo paginationInfo) {
		this.paginationInfo = paginationInfo;
	}

	public void setType(String type) {
		this.type = type;
	}

	protected String firstPageLabel;
	protected String previousPageLabel;
	protected String currentPageLabel;
	protected String otherPageLabel;
	protected String nextPageLabel;
	protected String lastPageLabel;

	@Override
	public void doTag() throws JspException, IOException {

		try {

			StringBuffer strBuff = new StringBuffer();

			int firstPageNo = paginationInfo.getFirstPageNo();
			int firstPageNoOnPageList = paginationInfo.getFirstPageNoOnPageList();
			int totalPageCount = paginationInfo.getTotalPageCount();
			int pageSize = paginationInfo.getPageSize();
			int lastPageNoOnPageList = paginationInfo.getLastPageNoOnPageList();
			int currentPageNo = paginationInfo.getCurrentPageNo();
			int lastPageNo = paginationInfo.getLastPageNo();

			if (type.equals("admin_paging")) {
				strBuff.append("<div aria-label='Page navigation' class='paging'>");
				strBuff.append("	<ul class='pagination mt-5 '>");
				
				if (totalPageCount > pageSize) {
					if (firstPageNoOnPageList > pageSize) {
						strBuff.append("		<li class='page-item'><a class='page-link' href='javascript:"+jsFunction+"("+firstPageNo+")'><i class='fas fa-angle-double-left'></i></a></li>");
						strBuff.append("		<li class='page-item'><a class='page-link' href='javascript:"+jsFunction+"("+Integer.toString(firstPageNoOnPageList - 1)+")'><i class='fas fa-angle-left'></i></a></li>");
					} else {
						strBuff.append("		<li class='page-item'><a class='page-link' href='javascript:"+jsFunction+"("+firstPageNo+")'><i class='fas fa-angle-double-left'></i></a></li>");
						strBuff.append("		<li class='page-item'><a class='page-link' href='javascript:"+jsFunction+"("+firstPageNo+")'><i class='fas fa-angle-left'></i></a></li>");
					}
				}
	
				for (int i = firstPageNoOnPageList; i <= lastPageNoOnPageList; i++) {
					if (i == currentPageNo) {
						strBuff.append("		<li class='page-item active'><span class='page-link'>"+i+"</span></li>");
					} else {
						
						strBuff.append("		<li class='page-item'><a class='page-link' href='javascript:"+jsFunction+"("+i+")'>"+i+"</a></li>");
					}
				}
	
				if (totalPageCount > pageSize) {
					if (lastPageNoOnPageList < totalPageCount) {
						strBuff.append("		<li class='page-item'><a class='page-link' href='javascript:"+jsFunction+"("+Integer.toString(firstPageNoOnPageList + pageSize)+")'><i class='fas fa-angle-right'></i></a></li>");
						strBuff.append("		<li class='page-item'><a class='page-link' href='javascript:"+jsFunction+"("+lastPageNo+")'><i class='fas fa-angle-double-right'></i></a></li>");
					} else {
						strBuff.append("		<li class='page-item'><a class='page-link' href='javascript:"+jsFunction+"("+lastPageNo+")'><i class='fas fa-angle-right'></i></a></li>");
						strBuff.append("		<li class='page-item'><a class='page-link' href='javascript:"+jsFunction+"("+lastPageNo+")'><i class='fas fa-angle-double-right'></i></a></li>");
					}
				}
				
				strBuff.append("	</ul>");
				strBuff.append("</div>");
			} else {
				strBuff.append("<nav aria-label='Page navigation'>");
				strBuff.append("<ul class='pagination'>");
				if(totalPageCount > 0){
					if (currentPageNo <= pageSize) {
						if(currentPageNo == 1){
							strBuff.append("	<li class='disable page-item'><a class='page-link ' href='javascript:void(0)'>&lt;&lt;</a></li>");
						}else{
							strBuff.append("	<li class='page-item'><a class='page-link ' href='javascript:"+jsFunction+"(1)'>&lt;&lt;</a></li>");
						}
					} else {
						strBuff.append("	<li class='page-item'><a class='page-link ' href='javascript:"+jsFunction+"("+(firstPageNoOnPageList - pageSize)+")'>&lt;</a></li>");
					}
				}
	
				for (int i = firstPageNoOnPageList; i <= lastPageNoOnPageList; i++) {
					if (i == currentPageNo) {
						strBuff.append("	<li class='active page-item' ><a class='page-link bg-secondary border-secondary' href=javascript:void(0)>"+i+"</a></li>");
					} else {
						
						strBuff.append("	<li  class='page-item' ><a class='page-link ' href=javascript:"+jsFunction+"("+i+")>"+i+"</a></li>");
					}
				}
	
				if(totalPageCount > 0){
					if(currentPageNo >= (totalPageCount - pageSize)){
						if(currentPageNo == totalPageCount){
							strBuff.append("	<li class=\"disable page-item\"><a class='page-link ' href=\"javascript:void(0)\">&gt;&gt;</a></li>");
						}else{
							strBuff.append("	<li class='page-item'><a class='page-link ' href=\"javascript:"+jsFunction+"("+totalPageCount+")\">&gt;&gt;</a></li>");
						}
					} else {
						strBuff.append("	<li class='page-item'><a class='page-link ' href=\"javascript:"+jsFunction+"("+(firstPageNoOnPageList + pageSize)+")\">&gt;</a></li>");
					}
				}
				strBuff.append("</ul>");
				strBuff.append("</nav>");
			}
			
			// 출력
			getJspContext().getOut().write(strBuff.toString());

		} catch (Exception e) {
			e.printStackTrace();
			throw new SkipPageException("Exception");
		}

	}

}
