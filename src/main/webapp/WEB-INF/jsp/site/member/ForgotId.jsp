<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/taglib/taglib.jspf"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ page session="false"%>

<style>
body {
	background-color: #6c757d;
}

.justify-content-center {
	background-color: black;
}
</style>

<div class="login-wrap">
	<div class="login-html">
		<input id="tab-1" type="radio" name="tab" class="sign-in" checked>
		<label for="tab-1" class="tab">아이디 찾기</label> <input id="tab-2"
			type="radio" name="tab" class="sign-up"> <label for="tab-2"
			class="tab">비밀번호 찾기</label>

		<div class="login-form">
			<form action="/member/GotId.do" method="post">
				<div class="sign-in-htm">
					<div>
						<p>
							<label>Email</label>
							<input class="input" type="text" id="user_email" name="email" required>
						</p>
						<p class="w3-center">
							<button type="submit" id=findBtn>아이디 찾기</button>
							<button type="button" onclick="history.go(-1);">Cancel</button>
						</p>
						
					</div>
				</div>
			</form>
			
			<form action="../member/GotPW.do">
				<div class="sign-up-htm">
					<div>
						<p>
							<label>Email</label> <input class="input" type="text" id="user_email" name="email" required>
							<label>ID</label> <input class="input" type="text" id="user_email" name="email" required>
						</p>
						<p class="w3-center">
							<button type="submit" id=findBtn>비밀번호 찾기</button>
							<button type="button" onclick="history.go(-1);">Cancel</button>
						</p>
					</div>
				</div>
			</form>
		</div>			
	</div>
</div>