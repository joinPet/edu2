<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/taglib/taglib.jspf"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>

<style>

.justify-content-center {
	background-color: black;
}

.card-header.card-header {
	font-weight: bold;
}

.nav-pills .nav-link.active {
	background-color: black;
}
</style>

<%
	Map<String, Object> member = (Map<String, Object>) session.getAttribute("member");
%>

<div class="row">
	<div class="col-sm-2"></div>
	<div class="col">
		<form action="/reservation/res_save.do" method="post">
			<fieldset>
				<h2 class="bd-title border-bottom pb-3 mb-4">만남 요청하기</h2>
				<div class="form-group">
					<div class="bg-org">
						<h3 class="bd-title pb-2"><c:out value="'${petInfo.pet_name}'" /> 에게 만남요청하기</h3>
					</div>
					<input type="hidden" name="recep_id" value="<c:out value="${petInfo.user_id}"/>">
					<input type="hidden" name="send_id" value=<%=member.get("user_id")%>>
					<input type="hidden" name="pet_id" value="<c:out value="${petInfo.pet_id}"/>">
				</div>

				<div class="form-group pb-4">
					<label class="small mb-1" for="pet_name">언제 만나시기를 원하나요?</label>
					<small id="dateHelp" class="form-text text-muted">Reservation Date</small>
					<input type="date" name="req_date" class="form-control datepicker" id="exampleInputName2"
						value="2022-11-23" data-date-format="yyyy-mm-dd" required />
				</div>

				<div class="form-group pb-4">
					<label class="small mb-1" for="pet_name">몇시에 만나시기를 원하나요?</label>
					<small id="timeHelp" class="form-text text-muted">Reservation Time</small>
					<input type="time" name="req_time" class="form-control" id="exampleInputName3" 
						value="15:00" required />
				</div>

				<div class="form-group pb-4">
					<label class="small mb-1" for="pet_name">무엇을 하고싶으세요?</label>
					<select class="form-select" id="exampleSelect1" name="req_play">
						<option value="공놀이">공놀이</option>
						<option value="산책">산책</option>
						<option value="간식주기">간식주기</option>
						<option value="펫카페가기">펫카페가기</option>
					</select>
				</div>

				<div class="form-group pb-4 mb-4">
					<label class="small mb-1" for="pet_name">보호자님께 하고 싶은 말 남겨주세요</label>
					<textarea name="req_comment" class="form-control" id="exampleInputName4"></textarea>
				</div>
				<div class="blank" style="height:10px;"></div>
				<div class="wrap-button pb-4" align=center>
					<button type="submit" class="btn btn-dark" id="btn-submit">만남 요청하기</button>
				</div>
			</fieldset>
		</form>
	</div>
</div>