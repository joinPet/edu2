<%@ page import="java.io.File" %>
<%@ page import="org.springframework.beans.factory.annotation.Value" %>
<%@ page import="egovframework.com.cmm.util.EgovProperties" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ include file="/WEB-INF/taglib/taglib.jspf"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%
    response.setHeader("Cache-Control","no-store");
    response.setHeader("Pragma","no-cache");
    response.setDateHeader("Expires",0);
    if (request.getProtocol().equals("HTTP/1.1"))
        response.setHeader("Cache-Control", "no-cache");
%>

<!DOCTYPE html>
<html lang="ko">
    <head>
        <!-- 파비콘 -->
        <link rel="shortcut icon" href="<c:url value='/assets/site/img/favicon.png' />" type="image/x-icon">
        <link rel="icon" href="<c:url value='/assets/site/img/favicon.png' />" type="image/x-icon">
		
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no, touch-action: pan-y; maximum-scale=1.0, minimum-scale=1.0, shrink-to-fit=YES, viewport-fit=cover">
		
		<!-- url썸네일 정보 추가-->
		<meta property="og:title" content="사이트명" />
		<meta property="og:description" content="사이트설명" />
		<meta property="og:image" content="/resources/www/img/url_thumbnail.jpg" />
		
		<meta name="_csrf" content="<c:out value='${_csrf.token}'/>"/>
		<meta name="_csrf_header" content="<c:out value='${_csrf.headerName}'/>"/>
		<meta id="loginFlag" name="loginFlag" content="<c:out value='${loginFlag}'/>"/>
		
		<title>ESG SAMPLE</title>

        <!-- 공통 스타일-->
        <c:import url="/WEB-INF/jsp/site/layout/css.jsp"/>
        <!-- 공통 스크립트-->
        <c:import url="/WEB-INF/jsp/site/layout/script.jsp"/>
    </head>

    <body>
	    <div class="container">
		    <!-- wrap -->
	    	<c:set var="path" value="${requestScope['javax.servlet.forward.servlet_path']}" /> 
	        <%-- <div id="wrap" class="${path eq '/index.jsp' || menuUrl eq '/main.do' || menuUrl eq '/splash.do' ? 'main':''}"> --%>
	        <div id="wrap" class="">
		        <!--공통 위쪽-->
		        <c:import url="/WEB-INF/jsp/site/layout/top.jsp"/>
		        <c:import url="/WEB-INF/jsp/site/layout/topbar.jsp"/>
		        
		        <tiles:insertAttribute name="content" />
		    </div>
	    </div>
	    
	    <!--공통 하단-->
	    <c:import url="/WEB-INF/jsp/site/layout/footer.jsp"/>
    </body>
    
</html>
