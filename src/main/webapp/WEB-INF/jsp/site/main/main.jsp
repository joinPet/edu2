<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/taglib/taglib.jspf"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ page session="false"%>

<script>
	$(document).ready(function() {
		$('.slider').slick({
			autoplay : true,
			autoplaySpeed : 3000,
		});
	});
</script>

<style>
	img {
		max-width: 100%;
		height: 700px;
	}
	
	.slide, .slick-next:before {
		content: "→";
	}
	
	.slick-prev, .slick-next {
		z-index: 999;
	}
	
	.slick-next {
		right: 0 !important;
	}
	
	.slick-prev {
		left: 0 !important;
	}
	
	html, body {
		margin: 0;
		padding: 0;
	}
	
	.justify-content-center {
    background-color: black;
	}
	
	.main {
		width: 100%;
		text-align: center;
	}
	
	
	h2 {
		font-family: sans-serif;
	}
	
	.slider {
		width: 100%;
		margin: 0px auto;
	}
	
	.slick-slide {
		margin: 10px;
	}
	
	.slick-slide img {
		width: 100%;
	}
	
	.card {
		position: relative;
		border: 2px solid #fff;
		box-shadow: 1px 1px 20px #ccc;
	}
	
	.middle {
		position: absolute;
		visibility: hidden;
	}
	
	.card-body {
		background: #fff;
		width: 100%;
		vertical-align: top;
	}
	
	.card-content {
		text-align: center;
		color: #333;
		padding: 15px;
	}
	
	.card-text {
		font-size: 14px;
		font-weight: 300;
	}
	
	.car:hover img {
		opacity: 0.1;
	}
	
	.card:hover .middle {
		opacity: 3;
	}
	
	.car:hover .middle {
		background-color: #51cca0;
		color: white;
		font-size: 16px;
		position: absolute;
		top: 47%;
		padding: 10px 20px;
		left: 35%;
		visibility: visible;
	}
</style>

<!-- contents -->
<div id="contents">
	<!-- sub title -->
	<div class="sub-title">
		<a href="<c:url value="/"/>" class="back-btn"><i class="i_go_back"></i></a>
	</div>
	<!-- //sub title -->

	<!-- container -->
	<div id="container" class="sub-wrap"></div>
	<!-- //container -->

	<div class="slider">
		<div>
			<img
				src="https://www.pumpkin.care/wp-content/uploads/2020/12/Havanese-1024x536.jpg"
				alt="">
		</div>
		<div>
			<img
				src="https://image.ajunews.com/content/image/2019/12/25/20191225170826943516.jpg"
				alt="">
		</div>
		<div>
			<img
				src="https://content3.jdmagicbox.com/comp/mumbai/r8/022pxx22.xx22.170119124215.z8r8/catalogue/krupa-pets-kennel-borivali-east-mumbai-pet-shops-for-dog-n10087wxm2.jpg?clr=553311"
				alt="">
		</div>
		<div>
			<img
				src="https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/dog-puppy-on-garden-royalty-free-image-1586966191.jpg"
				alt="">
		</div>
	</div>
</div>
<!-- mainbox
<div class="centered">

         <div class="box">
                 프로필 구경가기
               </div>

               <div class="box">
                 만남 요청하기
               </div>
         
      </div>
 -->


<!-- //contents -->
