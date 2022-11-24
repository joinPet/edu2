<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

.card-header.card-header {
	font-weight: bold;
}

.nav-pills .nav-link.active {
	background-color: black;
}
</style>
<div class="row">
	<div class="col-sm-2">
		<div class="card">
			<div class="card-header">Pet Meeting</div>
			<ul class="nav nav-pills flex-column">
				<li class="nav-item"><a
					class="nav-link text-decoration-none link-light active ${path eq 'map/mapHos.do' ? 'active':''}"
					href="/petmeeting/list.do">펫 미팅</a></li>
			</ul>
		</div>
	</div>
	<div class="col-sm-10">
		<div class="wrap-matching">
			<h2 class="bd-title border-bottom pb-3 mb-3">펫 미팅</h2>
			<div class="select" style="margin-bottom: 10px">
				<select class="form-select-sm" aria-label="Default select example">
					<option selected>동물 유형</option>
					<option value="1">강아지</option>
					<option value="2">고양이</option>
				</select>
			</div>
			<c:choose>
				<c:when test="${fn:length(petListAll) > 0}">
					<c:forEach items="${petListAll}" var="petListAll">
						<div class="row"  style="align-items:center;">
							<div class="col" style="height: 200px; width:300px">
								<div class="img-container"
									style="height:100%; background-color: white; cursor:pointer;"
									align="center"
									onClick="<c:out value="location.href = '/profile/viewpetprofile.do?pet_id=${petListAll.pet_id}'"/>">
									<c:forEach items="${petListAll.getFileDetailList}"
										var="getFileDetailInfo">
										<img alt="" src="/upload/edu2/post/${getFileDetailInfo.fileName}" style="height:constraint;">
										<%-- <c:choose>
											<c:when test="${getFileDetailInfo.fileName eq ''}">
												<!-- onerror="this.style.display='none'"  -->
												

											</c:when>
											<c:otherwise>
												<img alt="no-image"
													src="/upload/edu2/post/POST_16687488952341.jpg">
											</c:otherwise>
										</c:choose> --%>
									</c:forEach>
								</div>
							</div>
							<div class="col-sm-6">
								<div class="d-flex align-items-center">
									<span class="bg-org" style="width: 24%">
									<c:out value="${petListAll.pet_name}" /></span>
										<span class="ps-4" style="width: 20%"> 
										<c:out value="${petListAll.pet_age}세" /></span>
										<span class="ps-4">
										<c:out value="성격 : ${petListAll.pet_character}" />
									</span>
								</div>
								<div>
									<p class="text-capitalize fs5 my-4 fw-bolder">우리아이를 소개합니다!

									<p class="bg-org">
										<c:out value="${petListAll.pet_intro}" />
								</div>


							</div>
							<div class="col-sm-2"
								 onClick="<c:out value="location.href = '/profile/viewpetprofile.do?pet_id=${petListAll.pet_id}'"/>"
								 style="cursor:pointer; height:100%">
								<input type="button" value="프로필 구경하기" class="btn btn-dark"/>
							</div>

						</div>
						
						<div class="empty" style="height: 30px;"></div>
					</c:forEach>
				</c:when>
			</c:choose>
		</div>
	</div>
</div>