<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/taglib/taglib.jspf"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<style>
body {
	background-color: #6c757d;
}
.justify-content-center {
    background-color: black;
}
h2 {
	color: ghostwhite;
}

.card-header.card-header{
		font-weight: bold;
}
	
.nav-pills .nav-link.active {
	background-color: black;
}
</style>
<div class="row">
	<!-- 왼쪽 메뉴 -->
	<div class="col-sm-2">
		<div class="card">
			<div class="card-header">Profile</div>
			<ul class="nav nav-pills flex-column">
				<li class="nav-item">
				<a class="nav-link text-decoration-none link-dark ${path eq '/profile/profile.do' ? 'active':''}"
					href="/profile/profile.do">My profile</a></li>
				<li class="nav-item">
				<a class="nav-link text-decoration-none link-light active ${path eq '/profile/petmanage.do' ? 'active':''}"
					href="/profile/petmanage.do">Pet profile</a></li>
				<li class="nav-item"><a
					class="nav-link text-decoration-none link-dark ${path eq '' ? 'active':''}"
					href="/reservation/res_list.do">요청관리 페이지</a></li>
			</ul>
		</div>
	</div>

	<!-- /Breadcrumb -->
	<div class="col-sm-10">
		<h2 class="bd-title border-bottom pb-3 mb-3"><c:out value ="'${petInfo.pet_name}'"/> 의 Profile</h2>
		<div class="row" style="height: 542px">
			<div class="col-sm-4">
				<div class="card mb-3">
					<div class="card-body">
						<div class="d-flex flex-column align-items-center text-center">
						<c:forEach items="${getFileDetailList}" var="getFileDetailInfo">
						<img src="/upload/edu2/post/${getFileDetailInfo.fileName}" alt="Admin" width="150">
		        	</c:forEach>
							<div class="mt-3">
								<h4><c:out value ="${petInfo.pet_name}"/></h4>
								<p class="text-secondary mb-1"><c:out value ="${petInfo.pet_age}"/>살 | 
								<c:out value ="${petInfo.pet_kind}"/></p>
							</div>
						</div>
					</div>
				</div>

			</div>
			<div class="col-sm-8">
				<div class="card mb-3">
					<div class="card-body">
						<div class="row">
							<div class="col-sm-3">
								<h6 class="mb-0">반려동물</h6>
							</div>
							<div class="col-sm-9 text-secondary">
							<c:choose>
								<c:when test="${petInfo.pet_ eq true}">고양이</c:when>
								<c:otherwise>강아지</c:otherwise>
							</c:choose>
							</div>
						</div>
						<hr>
						<div class="row">
							<div class="col-sm-3">
								<h6 class="mb-0">종류</h6>
							</div>
							<div class="col-sm-9 text-secondary"><c:out value ="${petInfo.pet_kind}"/></div>
						</div>
						<hr>
						<div class="row">
							<div class="col-sm-3">
								<h6 class="mb-0">성별</h6>
							</div>
							<div class="col-sm-9 text-secondary">
							<c:choose>
								<c:when test="${petInfo.pet_kind eq true}">수컷</c:when>
								<c:otherwise>암컷</c:otherwise>
							</c:choose>
							</div>
						</div>
						<hr>
						<div class="row">
							<div class="col-sm-3">
								<h6 class="mb-0">크기</h6>
							</div>
							<div class="col-sm-9 text-secondary"><c:out value ="${petInfo.pet_size}"/></div>
						</div>
						<hr>
						<div class="row">
							<div class="col-sm-3">
								<h6 class="mb-0">성격</h6>
							</div>
							<div class="col-sm-9 text-secondary"><c:out value ="${petInfo.pet_character}"/></div>
						</div>
						<hr>
						<div class="row">
							<div class="col-sm-3">
								<h6 class="mb-0">펫 소개</h6>
							</div>
							<div class="col-sm-9 text-secondary"><c:out value ="${petInfo.pet_intro}"/></div>
						</div>
<!-- 						<div class="row">
							<div class="col-sm-12" align=center>
								<a class="btn btn-info " target="__blank" href="#">수정하기</a>
							</div>
						</div> -->
					</div>
				</div>

			</div>
		</div>
	</div>
</div>