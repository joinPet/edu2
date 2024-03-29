<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/taglib/taglib.jspf"%><%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ page session="false" %>
<style>
.justify-content-center {
    background-color: black;
}
</style>
<!-- row -->
<div class="row">
	
	<!-- 왼쪽 메뉴 -->
	<div class="col-md-2">
		<div class="card">
			<div class="card-header">
				Community
			</div>
			<ul class="nav nav-pills flex-column">
			  <li class="nav-item">
			    <a class="nav-link text-decoration-none link-light active" href="#">커뮤니티</a>
			  </li>
			</ul>
		</div>
	</div>
	
	<!-- 컨텐츠 내용 -->
	<div class="col-md-10">
	
		<!-- sub title -->
	    <h2 class="bd-title border-bottom pb-3 mb-3">커뮤니티</h2>
	    
		<!-- 검색입력 -->
		<div class="head border-bottom pb-3 mb-3">
            <h3><c:out value="${getSample1Info.post_title}"/></h3>
            <span id="regist-name" class="text-muted"><c:out value="${getSample1Info.regist_id}"/></span>
            <span class="text-muted">|</span>
            <span id="regist-date" class="text-muted"><c:out value="${getSample1Info.regist_date}"/></span>
		</div>
        
        <% pageContext.setAttribute("newLineChar", "\n"); %>
        <c:set var="post_content" value="${fn:replace(getSample1Info.post_content, newLineChar, '<br/>')}"/>
		<div class="body pb-3">
			${post_content}
		</div>
		 
		<div class="intro-slide">
			<div class="img-slide">
				<div class="track">
				   <c:forEach items="${getFileDetailList}" var="getFileDetailInfo">
						<div class="item"><img class="contain" src="/upload/edu2/post/${getFileDetailInfo.fileName}"></div>
		        	</c:forEach>
				</div>
			</div>
			<div class="slide-btn">
				<a href="javascript:void(0)" class="btn btn-dark intro-slide-prev"><i class="bi bi-arrow-left"></i></a>
				<a href="javascript:void(0)" class="btn btn-dark intro-slide-next"><i class="bi bi-arrow-right"></i></a>
			</div>
		</div>

		<div class="pt-3 border-top">
			<div class="col-12 d-flex justify-content-end align-items-center">
				<a class="btn btn-md btn-outline-dark ms-2" href="<c:url value="/sample1/list.do"/>" >목록</a>
	            <a class="btn btn-md btn-danger ms-2" href="<c:url value="javascript:fnDelete(${getSample1Info.post_seq})"/>" >삭제</a>
	            <a class="btn btn-md btn-primary ms-2" href="<c:url value="/sample1/form.do?post_seq=${getSample1Info.post_seq}"/>">수정</a>
			</div>
		</div>
	</div>
	<div class="blank" style="height:148px"></div>
</div>
<!-- //contents -->

<script>
$(document).ready(function () {
 
	/*슬라이더*/
	$('.img-slide .track').slick({
            dots: false,
            prevArrow: $('.intro-slide-prev'),
            nextArrow: $('.intro-slide-next'),
            infinite: true,
            speed: 500,
            slidesToShow: 1,
            slidesToScroll: 1,
            autoplay: true,
            autoplaySpeed: 5000,
            pauseOnHover: false,
            centerPadding: '0px',
            fade: false,
            dots: false
        });
});

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
	
</script>