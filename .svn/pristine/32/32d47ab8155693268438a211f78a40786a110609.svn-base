<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/WEB-INF/taglib/taglib.jspf"%><%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%><%@ page session="false" %><!-- contents -->
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
		<div class="row mb-3">
			<form id="registForm" class="join-form" action="/sample1/form-save.do" method="post" enctype="multipart/form-data">
				<input type="hidden" id="post_seq" name="post_seq" value="<c:out value="${getSample1Info.post_seq }"/>">
				
				<div class="col-12 mb-3">
	            	<label for="post_title" class="form-label">제목 <span class="text-danger">*</span></label>
	              	<input type="text" id="post_title" name="post_title" class="form-control" placeholder="제목을 입력해 주세요." value="<c:out value="${getSample1Info.post_title }"/>">
	            </div>
	            
	            <div class="col-12 mb-3">
	            	<label for="post_title" class="form-label">내용 <span class="text-danger">*</span></label>
	              	<textarea id="post_content" name="post_content" class="form-control" rows="10"><c:out value="${getSample1Info.post_content }"/></textarea>
	            </div>
	            
	            <div id="fileDiv" class="col-12 mb-3">
	            	<input type="hidden" id="file_seq" name="file_seq" value="<c:out value="${getSample1Info.file_seq }"/>">
	            	<label for="post_title" class="form-label">첨부 <span class="text-danger">*</span></label>
	            	<c:choose>
	            		<c:when test="${fn:length(getFileDetailList) > 0}">
		            		<c:forEach items="${getFileDetailList}" var="getFileDetailInfo">
			            		<div class="input-group mb-3">
								  <input type="text" name="fileData" class="form-control" value="<c:out value="${getFileDetailInfo.fileOriginalName }"/>" disabled="disabled"/>
								  <input type="button" class="btn btn-danger" onclick="fnFileDelete(this, '<c:out value="${getFileDetailInfo.fileSeq }"/>','<c:out value="${getFileDetailInfo.fileDetailNo }"/>')" value="삭제" />
								</div>
			            	</c:forEach>
							<div class="input-group mb-3">
							  <input type="file" name="fileData" class="form-control" value=""/>
							  <input type="button" class="btn btn-secondary" onclick="fnFileAdd()" value="추가" />
							</div>
	            		</c:when>
	            		<c:otherwise>
	            			<div class="input-group mb-3">
		            			<input type="file" name="fileData" class="form-control" value=""/>
		            			<input type="button" class="btn btn-secondary" onclick="fnFileAdd()" value="추가" />
	            			</div>
	            		</c:otherwise>
	            	</c:choose>
	            </div>
			</form>
		</div>
		
		<div class="pt-3 border-top">
			<div class="col-12 d-flex justify-content-end align-items-center">
				<a class="btn btn-md btn-outline-dark ms-2" href="<c:url value="/sample1/list.do"/>" >취소</a>
	            <c:if test="${not empty getSample1Info.post_seq}">
	            	<a class="btn btn-md btn-danger ms-2" href="<c:url value="javascript:fnDelete(${getSample1Info.post_seq})"/>" >삭제</a>
	            </c:if>
	            <a class="btn btn-md btn-primary ms-2" href="<c:url value="javascript:fnSave()"/>">저장</a>
			</div>
		</div>
	</div>
</div>
<!-- //contents -->

<script>
    //저장 버튼 클릭시
    function fnSave(){
    	if (confirm("게시글을 저장 하시겠습니까?")) {
    		if($('#post_title').val() == ""){
        		alert("제목을 입력해 주세요");
        		$('#post_title').focus();
        		return;
        	}
    		
    		if($('#post_content').val() == ""){
        		alert("내용을 입력해 주세요");
        		$('#post_content').focus();
        		return;
        	}
        	
        	$("#registForm").submit();	
    	}
    }
    
  	//삭제 버튼 클릭시
    function fnDelete(seq){
    	if (confirm("게시글을 삭제 하시겠습니까?")) {
			let f = document.createElement('form');
		    
		    let obj;
		    obj = document.createElement('input');
		    obj.setAttribute('type', 'hidden');
		    obj.setAttribute('name', 'post_seq');
		    obj.setAttribute('value', seq);
		    
		    f.appendChild(obj);
		    f.setAttribute('method', 'post');
		    f.setAttribute('action', '/sample1/form-delete.do');
		    
		    document.body.appendChild(f);
		    f.submit();
	    }
	}
    
  	//파일 추가
  	function fnFileAdd() {
  		var fileHtml = "";
  		fileHtml += "<div class=\"input-group mb-3\">";
  		fileHtml += "	<input type=\"file\" name=\"fileData\" class=\"form-control\"/>";
  		fileHtml += "	<input type=\"button\" class=\"btn btn-danger btn-file-delete\" onclick=\"fnFileDelete(this)\" value=\"삭제\" />";
  		fileHtml += "	<input type=\"button\" class=\"btn btn-secondary\" onclick=\"fnFileAdd()\" value=\"추가\" />";
  		fileHtml += "</div>";
  		
		$('#fileDiv').append(fileHtml);
	}
  	
  	//파일 삭제
  	function fnFileDelete(fileDive, seq, no) {
  		if(seq == null){
  			$(fileDive).parent().remove();	
  		}else{
  			
  			if (confirm("파일을 삭제 하시겠습니까?")) {
  				ajaxForm('post', '/egovframework/com/cmm/api-file-delete', {"seq" : seq, "no" : no}, '', function(result) {
  					if(result.status == '200'){
  	    				alert("파일 삭제에 성공 하였습니다.");
  	    				$(fileDive).parent().remove();
  	    			}else{
  	    				alert("파일 실패 하였습니다.");
  	    			}
  	    		});
  		    }
  			
  			
  		}
  		
	}
</script>
