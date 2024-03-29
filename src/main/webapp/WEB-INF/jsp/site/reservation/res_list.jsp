<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/taglib/taglib.jspf"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
	crossorigin="anonymous"></script>

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

	<div class="res-container" style="margin-bottom: 22%">
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
							class="nav-link text-decoration-none link-dark ${path eq '/profile/petmanage.do' ? 'active':''}"
							href="/profile/petmanage.do">Pet profile</a></li>
						<li class="nav-item"><a
							class="nav-link text-decoration-none link-light active ${path eq '' ? 'active':''}"
							href="/reservation/res_list.do">요청관리 페이지</a></li>
					</ul>
				</div>
			</div>
			<div class="col">
				<h2 class="bd-title border-bottom pb-3 mb-3">
					'${member.get("user_id")}' 님의 요청관리 페이지</h2>
				<ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
					<li class="nav-item" role="presentation">
						<button class="nav-link active" id="pills-home-tab"
							data-bs-toggle="pill" data-bs-target="#pills-home" type="button"
							role="tab" aria-controls="pills-home" aria-selected="true">보낸 요청</button>
					</li>
					<li class="nav-item" role="presentation">
						<button class="nav-link" id="pills-profile-tab"
							data-bs-toggle="pill" data-bs-target="#pills-profile"
							type="button" role="tab" aria-controls="pills-profile"
							aria-selected="false">받은 요청</button>
					</li>

				</ul>
				<div class="tab-content" id="pills-tabContent">
					<div class="tab-pane fade show active" id="pills-home"
						role="tabpanel" aria-labelledby="pills-home-tab" tabindex="0">
						<c:choose>
							<c:when test="${fn:length(sendList) > 0}">
								<c:forEach items="${sendList}" var="sendList">
									<div class="card mb-3">


										<div class="card-body">
											<div class="d-flex flex-column flex-lg-row">
												<span class="avatar avatar-text rounded-3 me-4 mb-2">보낸요청</span>
												<div class="row flex-fill" style="align-items: center">
													<div class="col-sm-5">
														<h4 class="h5">
															반려동물 :
															<c:out value="${sendList.pet_name}" />
														</h4>
														<span class="badge bg-secondary">-</span>
													</div>
													<div class="col-sm-4 py-2">
														<span class="badge bg-secondary"><c:out
																value="${sendList.req_date}" /></span> <span
															class="badge bg-secondary"><c:out
																value="${sendList.req_time}" /></span> <span
															class="badge bg-secondary"><c:out
																value="${sendList.req_play}" /></span> <span
															class="badge bg-secondary"><c:out
																value="${sendList.req_comment}" /></span>
													</div>
													<div class="col-sm-3 text-lg-end">
														<button data-toggle="modal" data-target="#exampleModal-4"
															data-whatever="@fat"
															class="btn btn-primary stretched-link">자세히 보기</button>
													</div>
												</div>

											</div>
										</div>

									</div>
								</c:forEach>
							</c:when>
						</c:choose>
					</div>

				</div>
				<div class="tab-pane fade" id="pills-profile" role="tabpanel"
					aria-labelledby="pills-profile-tab" tabindex="0">
					<c:choose>
						<c:when test="${fn:length(resList) > 0}">
							<c:forEach items="${resList}" var="resList">
								<div class="card mb-3">
									<div class="card-body">
										<div class="d-flex flex-column flex-lg-row">
											<div class="col-sm-1">
												<span class="avatar avatar-text rounded-3">받은요청</span>
											</div>
											<div class="row flex-fill" style="align-items: center">
												<div class="col">
													<h4 class="h5">
														<c:out value="${resList.recep_id}" />
														님의 반려동물 중
														<c:out value="${resList.pet_name}" />
														에게 요청이 왔습니다.
													</h4>
													<span class="badge bg-secondary"> <c:out
															value="${resList.send_id}" /> 님으로부터 요청이 왔어요
													</span>
												</div>
												<div class="col-sm-4 py-4">
													<span class="badge bg-secondary">만남요청 날짜</span>
													<span class="badge bg-secondary">만남요청 시간</span>
													<span class="badge bg-secondary">하고 싶은 활동</span>
													<span class="badge bg-secondary">전하고 싶은 말</span>
												</div>
												<div class="col-sm-2 text-lg-end">
													<button data-toggle="modal" data-target="#exampleModal-4"
														data-whatever="@fat"
														class="btn btn-primary stretched-link">자세히 보기</button>
												</div>
											</div>
										</div>
									</div>

								</div>
							</c:forEach>
						</c:when>
					</c:choose>
					<div class="modal fade" id="exampleModal-4" tabindex="-1"
						role="dialog" aria-labelledby="ModalLabel" aria-hidden="true"
						style="display: none;">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="ModalLabel">
										<c:out value="${res_list.recep_id}" />
										님께서 ${member.get("user_id") } 에게 만남 요청하셨습니다.
									</h5>
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
								<div class="modal-body">
									<grammarly-extension
										style="position: absolute; top: 0px; left: 0px; pointer-events: none;">
									<div data-grammarly-part="highlights"
										style="position: absolute; top: 0px; left: 0px;">
										<div
											style="box-sizing: content-box; top: 1px; left: 1px; width: 0px; height: 0px; position: relative; pointer-events: none; overflow: hidden; border: 0px; border-radius: 0px; padding: 0px; margin: 0px;">
											<div style="position: absolute; top: 0px; left: 0px;">
												<div style="height: 815px; width: 1440px;"></div>
												<div
													style="position: absolute; top: 0px; left: 0px; height: 815px; width: 1440px;"></div>
											</div>
										</div>
									</div>
									<div data-grammarly-part="button"
										style="position: absolute; top: 0px; left: 0px;">
										<div
											style="box-sizing: content-box; top: 1px; left: 1px; width: 0px; height: 0px; position: relative; pointer-events: none; overflow: hidden; border: 0px; border-radius: 0px; padding: 0px; margin: 0px;">
											<div
												style="position: absolute; transform: translate(-100%, -100%); top: -14px; left: -22px; pointer-events: all;">
												<div style="display: flex; flex-direction: row;">
													<div class="_3-ITD">
														<div class="_5WizN aN9_b _1QzSN">
															<div class="_3YmQx">
																<div title="Protected by Grammarly" class="_3QdKe">&nbsp;</div>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
									</grammarly-extension>
									<form>
										<div class="form-group">
											<label for="recipient-name" class="col-form-label">만남요청날짜 및 시간</label>
											<div type="text" class="form-control" id="recipient-name">2022.11.22 12pm</div>
										</div>
										<div class="form-group">
											<label for="message-text" class="col-form-label">체험 활동</label>
											<div type="text" class="form-control" id="recipient-name">공놀이</div>
										</div>
										<div class="form-group">
											<label for="message-text" class="col-form-label">보호자님께 전하는 말</label>
											<div type="text" class="form-control" id="recipient-name">안녕!</div>
										</div>
									</form>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-success" data-dismiss="modal">수락</button>
									<button type="button" class="btn btn-light" data-dismiss="modal">거절</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
		$(".btn btn-primary stretched-link").click(function(){
			
		})
	</script>