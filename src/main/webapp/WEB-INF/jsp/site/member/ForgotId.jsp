<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/taglib/taglib.jspf"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ page session="false" %>

<div class="login-wrap">
  <div class="login-html">
    <input id="tab-1" type="radio" name="tab" class="sign-in"checked><label for="tab-1" class="tab">아이디 찾기</label>
    <input id="tab-2" type="radio" name="tab" class="sign-up" ><label for="tab-2" class="tab">비밀번호 찾기</label>
    <div class="login-form">
      <div class="sign-in-htm">
        <div class="group">
          <label for="pass" class="label">가입하신 이메일 주소</label>
          <input name ="user_email" id="user_email" type="text" class="input">
        </div>
        
        <div class="group">
        <input type="submit" class="button" onclick="location.href = '/member/GotId.do'" value="아이디 찾기">
        </div>
        <div class="hr"></div>
         
      </div>
     
      <div class="sign-up-htm">
       
        <div class="group">
          <label for="user" class="label">아이디</label>
          <input name ="user_id" id="user_id" type="text" class="input">
        </div>
       
        <div class="group">
          <label for="pass" class="label">가입하신 이메일 주소</label>
          <input name ="user_email" id="user_email" type="text" class="input">
        
              
     <div class="group">
          <input type="submit" class="button" onclick="location.href = '/member/GotPW.do'" value="비밀번호 찾기">
        </div>
         </form>
        <div class="hr"></div>
        
        
      </div>
    </div>
  </div>
</div>
<style>
	body {
	background-color: #6c757d;
	}
	.justify-content-center {
    background-color: black;
	}
</style>