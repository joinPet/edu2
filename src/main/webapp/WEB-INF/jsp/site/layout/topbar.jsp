<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/taglib/taglib.jspf"%>

<div class="py-1 mb-2 bg-secondary">
	<ul class="nav nav-pills justify-content-center">
		<c:set var="path" value="${requestScope['javax.servlet.forward.servlet_path']}" />
		<li class="nav-item"><a class="nav-link p-3 text-decoration-none link-light ${path eq '' ? 'active':''}"  href="/main.do">Home</a></li>
		<% Map<String, Object> member = (Map<String, Object>) session.getAttribute("member");
		
		if(member == null){ %>
		<li class="nav-item"><a onclick="isLogin()" class="nav-link p-3 text-decoration-none link-light ${path eq '' ? 'active':''}"  href="/member/login.do">Profile</a></li>
		<%
			out.println("<script>function isLogin(){alert('로그인 후 사용해주세요.');}</script>");
		}else{ %>
		<li class="nav-item"><a class="nav-link p-3 text-decoration-none link-light ${path eq '' ? 'active':''}"  href="/profile/profile.do">Profile</a></li>
		<%} %>
		<li class="nav-item"><a class="nav-link p-3 text-decoration-none link-light ${path eq '' ? 'active':''}"  href="/petmeeting/list.do">Pet Meeting</a></li>
	    <li class="nav-item"><a class="nav-link p-3 text-decoration-none link-light ${path eq '' ? 'active':''}"  href="/map/mapHos.do">Pet Map</a></li>
	    <li class="nav-item"><a class="nav-link p-3 text-decoration-none link-light ${path eq '' ? 'active':''}"  href="/sample1/list.do">Community</a></li>
	</ul>
</div>
