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
	<!-- 왼쪽 메뉴 -->
	<div class="col-sm-2">
		<div class="card">
			<div class="card-header">Profile</div>
			<ul class="nav nav-pills flex-column">
				<li class="nav-item"><a
					class="nav-link text-decoration-none link-dark ${path eq '/profile/profile.do' ? 'active':''}"
					href="/profile/profile.do">My profile</a></li>
				<li class="nav-item"><a
					class="nav-link text-decoration-none link-light active ${path eq '/profile/petmanage.do' ? 'active':''}"
					href="/profile/petmanage.do">Pet profile</a></li>
				<li class="nav-item"><a
					class="nav-link text-decoration-none link-dark ${path eq '' ? 'active':''}"
					href="/reservation/res_list.do">요청관리 페이지</a></li>
			</ul>
		</div>
	</div>

	<div class="col-sm-10">
		<h2 class="bd-title border-bottom pb-3 mb-3">My Pet Profile 관리</h2>

		<div class="row" style="align-items: center;" align="center">
			<c:choose>
				<c:when test="${fn:length(petListByList) > 0}">
					<c:forEach items="${petListByList}" var="petListByList">
						<div class="col-sm-2"
							onclick="<c:out value="location.href = '/profile/petprofile.do?pet_id=${petListByList.pet_id}'"/>"
							style="cursor: pointer;">
							<div class="img-container"
								style="width: 150px; height: 150px; background-color: white">
								<c:forEach items="${petListByList.getFileDetailList}"
									var="getFileDetailInfo">
									<c:choose>
										<c:when test="${getFileDetailInfo.fileName ne ''}">
											<!-- onerror="this.style.display='none'"  -->
											<img alt="no-image"
												src="/upload/edu2/post/${getFileDetailInfo.fileName}"
												onerror="this.src='/upload/edu2/post/POST_16687488952341.jpg'">
										</c:when>
										<c:otherwise>
											<img alt="no-image"
												src="/upload/edu2/post/POST_16687488952341.jpg">
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</div>
							<h6 class="mt-2 mb-0">
								<c:out value="${petListByList.pet_name}" />
							</h6>

						</div>
					</c:forEach>
				</c:when>
			</c:choose>
			<div class="col-sm-2 mt-4" style="align-style: center; cursor: pointer;"
				OnClick="location.href ='/profile/petform.do'">
				<img alt="" style="width: 50px;" title=""
					src="https://cdn-icons-png.flaticon.com/512/3524/3524388.png">
			</div>
		</div>
	</div>
</div>