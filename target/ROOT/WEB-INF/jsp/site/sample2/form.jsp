<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/WEB-INF/taglib/taglib.jspf"%><%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%><%@ page session="false" %><!-- contents -->
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
	    
		<!-- 검색입력 -->
		<div class="row mb-3">
			<form id="registForm" class="join-form" action="/sample1/form-save.do" method="post">
				<input type="hidden" id="post_seq" name="post_seq" value="<c:out value="${paramMap.post_seq }"/>">
				
				<div class="col-12 mb-3">
	            	<label for="post_title" class="form-label">제목 <span class="text-danger">*</span></label>
	              	<input type="text" id="post_title" name="post_title" class="form-control" placeholder="제목을 입력해 주세요." value="">
	            </div>
	            
	            <div class="col-12 mb-3">
	            	<label for="post_title" class="form-label">내용 <span class="text-danger">*</span></label>
	              	<textarea id="post_content" name="post_content" class="form-control" rows="10"></textarea>
	            </div>
			</form>
		</div>
		
		<div class="pt-3 border-top">
			<div class="col-12 d-flex justify-content-end align-items-center">
				<a class="btn btn-md btn-outline-dark ms-2" href="<c:url value="/sample2/list.do"/>" >취소</a>
	            <c:if test="${not empty paramMap.post_seq}">
	            	<a class="btn btn-md btn-danger ms-2" href="<c:url value="javascript:fnDelete(${paramMap.post_seq})"/>" >삭제</a>
	            </c:if>
	            <a class="btn btn-md btn-primary ms-2" href="<c:url value="javascript:fnSave()"/>">저장</a>
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
            $('#post_title').val(getSample2Info.post_title);
            $('#post_content').html(getSample2Info.post_content);
		});
    });

    //저장 버튼 클릭시
    function fnSave(){
    	if (confirm("게시글을 저장 하시겠습니까?")) {
    		if($('#post_title').val() == ""){
        		alert("제목을 입력해 주세요");
        		$('#post_content').focus();
        		return;
        	}
    		
    		if($('#post_content').val() == ""){
        		alert("내용을 입력해 주세요");
        		$('#post_content').focus();
        		return;
        	}
    		
    		var formData = $("#registForm").serialize() ;
    		ajaxForm('post', '/sample2/api-sample-save', formData, '', function(result) {
    			if(result.status == '200'){
    				alert("저장에 성공 하였습니다.");
    				location.href = "/sample2/list.do";
    			}else{
    				alert("저장에 실패 하였습니다.");
    				location.href = "/sample2/list.do";
    			}
    		});
        	
        	//$("#registForm").submit();	
    	}
    }
    
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
