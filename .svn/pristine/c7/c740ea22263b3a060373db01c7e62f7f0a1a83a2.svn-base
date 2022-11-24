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
				sample2
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
	    <input type="hidden" id="post_seq" name="post_seq" value="<c:out value="${paramMap.post_seq }"/>">
	    
		<!-- 검색입력 -->
		<div class="head border-bottom pb-3 mb-3">
            <h3 id="post_title" ></h3>
            <span id="regist_id" class="text-muted"></span>
            <span class="text-muted">|</span>
            <span id="regist_date" class="text-muted"></span>
		</div>
        
        <div id="body" class="body pb-3"></div>

		<div class="pt-3 border-top">
			<div class="col-12 d-flex justify-content-end align-items-center">
				<a class="btn btn-md btn-outline-dark ms-2" href="<c:url value="/sample2/list.do"/>" >목록</a>
	            <a class="btn btn-md btn-danger ms-2" href="<c:url value="javascript:fnDelete(${paramMap.post_seq})"/>" >삭제</a>
	            <a class="btn btn-md btn-primary ms-2" href="<c:url value="/sample2/form.do?post_seq=${paramMap.post_seq}"/>">수정</a>
			</div>
		</div>
	</div>
</div>
<!-- //contents -->

<script>
	//화면 로드시
	$(document).ready(function() {
		var seq = $('#post_seq').val();
		ajaxForm('get', '/sample2/api-sample-info', {'post_seq' : seq}, '', function(result) {
	        //게시글 상세 정보
			let getSample2Info = result.data.getSample2Info;
	        $('#post_title').html(getSample2Info.post_title);
	        $('#regist_id').html(getSample2Info.regist_id);
	        $('#regist_date').html(getSample2Info.regist_date);
	        $('#body').html(getSample2Info.post_content.replaceAll('\n','<br/>'));
		});
	});

	//삭제 버튼 클릭시
    function fnDelete(seq){
    	if (confirm("게시글을 삭제 하시겠습니까?")) {
			ajaxForm('post', '/sample2/api-sample-delete', {"post_seq" : seq}, '', function(result) {
				if(result.status == '200'){
    				alert("삭제에 성공 하였습니다.");
    				location.href = "/sample2/list.do";
    			}else{
    				alert("삭제에 실패 하였습니다.");
    				location.href = "/sample2/list.do";
    			}
    		});
	    }
	}
	
</script>