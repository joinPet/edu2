<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/taglib/taglib.jspf"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ page session="false" %>

<style>
body {
	background-color: #6c757d;
}
</style>

<div class="login-wrap">
	<div class="login-html">
    	<input id="tab-2" type="radio" name="tab" class="sign-up" ><label for="tab-2" class="tab">비밀번호 찾기</label>
    	<div class="login-form">
      		<div class="sign-in-htm">
		        <div class="group">
		        	<label for="pass" class="label">비밀번호는</label>
		        </div>
		        <div class="group">
		       		<input type="submit" class="button" value="비밀번호 찾기">
		        </div>
		        <div class="hr"></div>
					<!-- href="/member/GotPW.do" -->
				</div>
		</div>
	</div>
</div>