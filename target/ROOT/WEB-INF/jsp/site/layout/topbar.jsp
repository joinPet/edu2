<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/taglib/taglib.jspf"%>

<div class="py-1 mb-2 bg-secondary">
	<ul class="nav nav-pills justify-content-center">
		<c:set var="path" value="${requestScope['javax.servlet.forward.servlet_path']}" />
		<li class="nav-item"><a class="nav-link p-3 text-decoration-none link-light ${path eq '' ? 'active':''}"  href="/main.do">Home</a></li>
		<li class="nav-item"><a class="nav-link p-3 text-decoration-none link-light ${path eq '' ? 'active':''}"  href="">Profile</a></li>
		<li class="nav-item"><a class="nav-link p-3 text-decoration-none link-light ${path eq '' ? 'active':''}"  href="">Pet Meeting</a></li>
	    <li class="nav-item"><a class="nav-link p-3 text-decoration-none link-light ${path eq '' ? 'active':''}"  href="/sample1/list.do">Community</a></li>
		<li class="nav-item"><a class="nav-link p-3 text-decoration-none link-light ${path eq '' ? 'active':''}"  href="/sample2/list.do">sample2</a></li>
	</ul>
</div>
