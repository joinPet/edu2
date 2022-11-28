<%@page import="javax.jms.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/taglib/taglib.jspf"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>

<style>
.justify-content-center {
	background-color: black;
}
</style>

<%
	String errmsg = (String) request.getAttribute("errmsg");
%>

<div class="login-wrap">
	<div class="login-html">
		<input id="tab-1" type="radio" name="tab" class="sign-in" checked>
		<label for="tab-1" class="tab">로그인</label>
		<input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab">회원가입</label>
		<div class="login-form">
			<div class="sign-in-htm">
				<form action="/member/login_select.do" method="post">
					<div class="group">
						<label for="user" class="label">아이디</label> <input name="user_id"
							id="user" type="text" class="input">
					</div>
					<div class="group">
						<label for="pass" class="label">비밀번호</label> <input name="user_pw"
							id="pass" type="password" class="input" data-type="password">
					</div>

					<div class="group">
						<input id="check" type="checkbox" class="check" disabled>
						<label for="check"><span class="icon"></span> 아이디 저장</label>
					</div>
					<%
						if (errmsg != null) {
					%>
					<div style="color: #800000;"><%=errmsg%></div>
					<%
						}
					%>
					<div class="group">
						<input type="submit" class="button" value="LOGIN">
					</div>
				</form>
				<div class="hr"></div>
	        <div class="foot-lnk">
	          <a class="forgot" href="/member/ForgotId.do">아이디, 비밀번호 찾기</a>
	        </div>
			</div>

			<div class="sign-up-htm">
				<form action="/member/join_insert.do" method="post">
					<div class="group">
						<label for="user" class="label">아이디</label> <input name="user_id"
							id="user_id" type="text" class="input">
					</div>
					<div class="group">
						<label for="pass" class="label">비밀번호</label> <input name="user_pw"
							id="user_pw" type="password" class="input">
					</div>
					<!--  <div class="group">
          <label for="pass" class="label">비밀번호 확인</label>
          <input id="pass" type="password" class="input" data-type="password">
        </div> -->
					<div class="group">
						<label for="pass" class="label">MBTI</label>
						<input name="user_mbti" id="user_mbti" type="text" class="input">
					</div>
					<div class="group">
						<label for="pass" class="label">이메일 주소</label>
						<input name="user_email" id="user_email" type="text" class="input">
					</div>
					<div class="group">
						<label for="pass" class="label">주 활동지역</label>
						<input name="user_dong" id="user_dong" type="text" class="input">
					</div>
					<div class="group">
						<label for="pass" class="label">자기소개</label>
						<input name="user_info" id="user_info" type="text" class="input">
					</div>
					<div class="group">
						<input type="submit" class="button" value="회원가입">
					</div>
				</form>
				<hr>
				<div class="foot-lnk">
					<label for="tab-1">이미 회원이십니까?</label>
				</div>
			</div>
		</div>
	</div>
</div>