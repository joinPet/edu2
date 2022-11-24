/**
 * 자바스크립트 페이징
 * pagingInfo 	--> 페이징 데이터 정보
 * @returns html
 */
function fn_Pagination(type, pagingInfo, jsFunction, functionSeq){

	var currentPageNo 			= pagingInfo.currentPageNo;
	var recordCountPerPage		= pagingInfo.recordCountPerPage;
	var pageSize				= pagingInfo.pageSize;
	var totalRecordCount		= pagingInfo.totalRecordCount;

	var firstPageNo = getFirstPageNo();
	var firstPageNoOnPageList = getFirstPageNoOnPageList(currentPageNo, pageSize);
	var totalPageCount = getTotalPageCount(totalRecordCount, recordCountPerPage);
	var lastPageNoOnPageList = getLastPageNoOnPageList(firstPageNoOnPageList, pageSize, totalPageCount);
	var lastPageNo = getLastPageNo(totalPageCount);

	let pagingHtml = "";
	//페이징 태그정보를 담는다.
	let functionContents = "";
	if(ifNull(functionSeq) != ''){
		functionContents = functionSeq+","
	}

	if (ifNull(type) == 'admin_paging') {
		pagingHtml += "	<ul class=\"pagination\">";

		if (totalPageCount > pageSize) {
			if (firstPageNoOnPageList > pageSize) {
				pagingHtml += "		<li class=\"page-item first\"><a class=\"page-link\" href=\"javascript:"+jsFunction+"("+functionContents+firstPageNo+")\"><span aria-hidden=\"true\" class=\"mdi mdi-first-page\"/></a></li>";
				pagingHtml += "		<li class=\"page-item prev\"><a class=\"page-link\" href=\"javascript:"+jsFunction+"("+functionContents+(firstPageNoOnPageList - 1)+")\"><span aria-hidden=\"true\" class=\"mdi mdi-chevron-left\"/></a></li>";
			} else {
				pagingHtml += "		<li class=\"page-item first\"><a class=\"page-link\" href=\"javascript:"+jsFunction+"("+functionContents+firstPageNo+")\"><span aria-hidden=\"true\" class=\"mdi mdi-first-page\"/></a></li>";
				pagingHtml += "		<li class=\"page-item prev\"><a class=\"page-link\" href=\"javascript:"+jsFunction+"("+functionContents+firstPageNo+")\"><span aria-hidden=\"true\" class=\"mdi mdi-chevron-left\"/></a></li>";
			}
		}

		for (var i = firstPageNoOnPageList; i <= lastPageNoOnPageList; i++) {
			if (i == currentPageNo) {
				pagingHtml += "		<li class=\"page-item active\"><span class=\"page-link\">"+i+"</span></li>";
			} else {
				pagingHtml += "		<li class=\"page-item\"><a class=\"page-link\" href=\"javascript:"+jsFunction+"("+functionContents+i+")\">"+i+"</a></li>";
			}
		}

		if (totalPageCount > pageSize) {
			if (lastPageNoOnPageList < totalPageCount) {
				pagingHtml += "		<li class=\"page-item last\"><a class=\"page-link\" href=\"javascript:"+jsFunction+"("+functionContents+(firstPageNoOnPageList + pageSize)+")\"><span aria-hidden=\"true\" class=\"mdi mdi-chevron-right\"/></a></li>";
				pagingHtml += "		<li class=\"page-item next\"><a class=\"page-link\" href=\"javascript:"+jsFunction+"("+functionContents+lastPageNo+")\"><span aria-hidden=\"true\" class=\"mdi mdi-last-page\"/></a></li>";
			} else {
				pagingHtml += "		<li class=\"page-item last\"><a class=\"page-link\" href=\"javascript:"+jsFunction+"("+functionContents+lastPageNo+")\"><span aria-hidden=\"true\" class=\"mdi mdi-chevron-right\"/></a></li>";
				pagingHtml += "		<li class=\"page-item next\"><a class=\"page-link\" href=\"javascript:"+jsFunction+"("+functionContents+lastPageNo+")\"><span aria-hidden=\"true\" class=\"mdi mdi-last-page\"/></a></li>";
			}
		}

		pagingHtml += "	</ul>";
	}else if (ifNull(type) == 'user_paging') {
		pagingHtml += "<nav aria-label='Page navigation'>";
		pagingHtml += "<ul class='pagination'>";				
		if(totalPageCount > 0){
			if(currentPageNo <= pageSize){
				if(currentPageNo == 1){
					pagingHtml += "		<li class=\"disable page-item\"><a class=\"page-link \"  href=\"javascript:void(0)\">&lt;&lt;</a></li>";
				}else{
					pagingHtml += "		<li class=\"page-item\"><a class=\"page-link \" href=\"javascript:"+jsFunction+"("+functionContents+"1)\">&lt;&lt;</a></li>";
				}
			}else{
				pagingHtml += "		<li class=\"page-item\"><a class=\"page-link \" href=\"javascript:"+jsFunction+"("+functionContents+(firstPageNoOnPageList - pageSize)+")\">&lt;</a></li>";
			}
		}

		for (var i = firstPageNoOnPageList; i <= lastPageNoOnPageList; i++) {
			if (i == currentPageNo) {
				pagingHtml += "		<li class=\"active page-item\" ><a class=\"page-link bg-secondary border-secondary\" href=\"javascript:void(0)\">"+i+"</a></li>";
			} else {
				pagingHtml += "		<li class=\"page-item\" ><a class=\"page-link \" href=\"javascript:"+jsFunction+"("+functionContents+i+")\">"+i+"</a></li>";
			}
		}

		if(totalPageCount > 0){
			if(currentPageNo >= (totalPageCount - pageSize)){
				if(currentPageNo == totalPageCount){
					pagingHtml += "		<li class=\"disable page-item\"><a class=\"page-link \" href=\"javascript:void(0)\">&gt;&gt;</a></li>";
				}else{
					pagingHtml += "		<li class=\"page-item\"><a class=\"page-link \" href=\"javascript:"+jsFunction+"("+functionContents+totalPageCount+")\">&gt;&gt;</a></li>";
				}
			}else{
				pagingHtml += "		<li class=\"page-item\"><a class=\"page-link \" href=\"javascript:"+jsFunction+"("+functionContents+(firstPageNoOnPageList + pageSize)+")\">&gt;</a></li>";
			}
		}
		pagingHtml += "</ul>";
		pagingHtml += "</nav>";
	}

	return pagingHtml;
}




/**
 * Not Required Fields
 * - 이 필드들은 Required Fields 값을 바탕으로 계산해서 정해지는 필드 값이다.
 *
 * totalPageCount: 페이지 개수
 * firstPageNoOnPageList : 페이지 리스트의 첫 페이지 번호
 * lastPageNoOnPageList : 페이지 리스트의 마지막 페이지 번호
 * firstRecordIndex : 페이징 SQL의 조건절에 사용되는 시작 rownum.
 * lastRecordIndex : 페이징 SQL의 조건절에 사용되는 마지막 rownum.
 */

/**
 * 첫 페이지 번호
 */
function getFirstPageNo() {
	firstPageNo = 1;
	return firstPageNo;
}

/**
 * 페이지 리스트의 첫 페이지 번호
 */
function getFirstPageNoOnPageList(currentPageNo, pageSize) {
	firstPageNoOnPageList = Math.floor(((currentPageNo - 1) / pageSize)) * pageSize + 1;
	return firstPageNoOnPageList;
}

/**
 * 페이지 개수
 */
function getTotalPageCount(totalRecordCount, recordCountPerPage) {
	totalPageCount = Math.floor(((totalRecordCount - 1) / recordCountPerPage)) + 1;
	return totalPageCount;
}

/**
 *  페이지 리스트의 마지막 페이지 번호
 */
function getLastPageNoOnPageList(firstPageNoOnPageList, pageSize, totalPageCount) {
	lastPageNoOnPageList = firstPageNoOnPageList + pageSize - 1;
	if (lastPageNoOnPageList > totalPageCount) {
		lastPageNoOnPageList = totalPageCount;
	}
	return lastPageNoOnPageList;
}

/**
 * 마지막 페이지 번호
 */
function getLastPageNo(totalPageCount) {
	lastPageNo = totalPageCount;
	return lastPageNo;
}
