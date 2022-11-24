<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/taglib/taglib.jspf"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ page session="false" %>

<!-- row -->
<div class="row">
	
	<!-- 왼쪽 메뉴 -->
	<div class="col-md-2">
		<div class="card">
			<div class="card-header">
				sample1
			</div>
			<ul class="nav nav-pills flex-column">
			  <li class="nav-item">
			    <a class="nav-link text-decoration-none link-light active" href="#">게시판</a>
			  </li>
			  <li class="nav-item">
			    <a class="nav-link text-decoration-none link-dark" href="#">A second item</a>
			  </li>
			  <li class="nav-item">
			    <a class="nav-link text-decoration-none link-dark" href="#">A third item</a>
			  </li>
			</ul>
		</div>
	</div>
	
	<!-- 컨텐츠 내용 -->
	<div class="col-md-10">
	
		<!-- sub title -->
	    <h2 class="bd-title border-bottom pb-3 mb-3">게시판</h2>
	    
		<!-- 검색입력 -->
		<div class="row mb-3 flex-nowrap justify-content-between align-items-center">
			<div class="col-md-2">
				<select class="form-select" id="searchKey" name="searchKey">
					<option value="">전체</option>
					<option value="post_title" <c:out value="${paramMap.searchKey eq 'post_title' ? 'selected':'' }"/>>제목</option>
					<option value="post_content" <c:out value="${paramMap.searchKey eq 'post_content' ? 'selected':'' }"/>>내용</option>
				</select>
			</div>
	
	       	<div class="col-sm-6">
             	<input type="text" class="form-control" id="searchKeyword" name="searchKeyword" placeholder="검색어를 입력해 주세요" value="<c:out value="${paramMap.searchKeyword }"/>">
           	</div>
           
	       	<div class="col-sm-2">
				<a class="btn btn-md btn-secondary" href="javascript:fnSearch(1);">검색</a>
			</div>
			
	        <!-- 버튼 -->
	        <div class="col-sm-2 d-flex justify-content-end align-items-center">
	            <a href="<c:url value="/sample1/form.do"/>" class="btn btn-md btn-primary">글쓰기</a>
	        </div>
		</div>
		
		<!-- 리스트 정보 -->
		<table class="table table-striped table-bordered table-hover">
			<colgroup>
				<col  width="10%" >
				<col  width="70%" >
				<col  width="20%" >
			</colgroup>
			<thead>
				<tr>
					<th>순번</th>
					<th>제목</th>
	              	<th>등록일시</th>
	            </tr>
			</thead>
			<tbody>
				<c:forEach items="${getSample1List}" var="getSample1Info">
		            <tr onclick="<c:out value="location.href = '/sample1/view.do?post_seq=${getSample1Info.post_seq}'"/>">
		            	<td><c:out value="${getSample1Info.rn}"/></td>
		            	<td><c:out value="${getSample1Info.post_title}"/></td>
		            	<td><c:out value="${getSample1Info.regist_date}"/></td>
					</tr>
	       		</c:forEach>
			</tbody>
		</table>
		
       <!-- 페이징  -->
       <custom:paging paginationInfo="${paginationInfo}" type="image" jsFunction="fnSearch"/>
       
	</div>
</div>
<!-- //contents -->

<script>

    //검색 버튼 클릭시
    function fnSearch(pageIndex){
    	location.href="/sample1/list.do?pageIndex="+pageIndex+"&searchKeyword="+$('#searchKeyword').val()+"&searchKey="+$('#searchKey').val();
    }

    //검색어 엔테 입력시
    $("#searchKeyword").on("keyup",function(key){
        if(key.keyCode==13) {
            fnSearch(1);
        }
    });

</script>
