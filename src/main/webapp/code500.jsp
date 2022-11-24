<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
	<!-- 파비콘 -->
	<link rel="shortcut icon" href="<c:url value='/assets/jtsm/img/favicon.png' />" type="image/x-icon">
	<link rel="icon" href="<c:url value='/assets/jtsm/img/favicon.png' />" type="image/x-icon">

	<meta charset="utf-8">
	<title>JOINTREE CMS</title>
</head>

<body>
<div style="width: 1000px; margin: 50px auto 50px;">
	<div style="border: 0px solid #666; padding: 20px;">
		<!-- 404 -->
		<p style="color:red; margin-bottom: 8px; ">500 Error</p>

		<div class="boxType1" style="width: 500px;">
			<div class="box">
				<div class="error">
					<p class="title">HTTP 500 Error</p>
					<p class="cont mb20">HTTP 500 Internal Server error.<br /></p>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>
