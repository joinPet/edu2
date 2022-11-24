<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/taglib/taglib.jspf"%><%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ page session="false" %>

<style>
/* Slider */
.slick-slider
{
    position: relative;

    display: block;
    box-sizing: border-box;

    -webkit-user-select: none;
       -moz-user-select: none;
        -ms-user-select: none;
            user-select: none;

    -webkit-touch-callout: none;
    -khtml-user-select: none;
    -ms-touch-action: pan-y;
        touch-action: pan-y;
    -webkit-tap-highlight-color: transparent;
}

.slick-list
{
    position: relative;

    display: block;
    overflow: hidden;

    margin: 0;
    padding: 0;
}
.slick-list:focus
{
    outline: none;
}
.slick-list.dragging
{
    cursor: pointer;
    cursor: hand;
}

.slick-slider .slick-track,
.slick-slider .slick-list
{
    -webkit-transform: translate3d(0, 0, 0);
       -moz-transform: translate3d(0, 0, 0);
        -ms-transform: translate3d(0, 0, 0);
         -o-transform: translate3d(0, 0, 0);
            transform: translate3d(0, 0, 0);
}

.slick-track
{
    position: relative;
    top: 0;
    left: 0;

    display: block;
    /*margin-left: auto;*/
    margin-right: auto;
}
.slick-track:before,
.slick-track:after
{
    display: table;

    content: '';
}
.slick-track:after
{
    clear: both;
}
.slick-loading .slick-track
{
    visibility: hidden;
}

.slick-slide
{
    display: none;
    float: left;

    height: 100%;
    min-height: 1px;
}
[dir='rtl'] .slick-slide
{
    float: right;
}
.slick-slide img
{
    display: block;
}
.slick-slide.slick-loading img
{
    display: none;
}
.slick-slide.dragging img
{
    pointer-events: none;
}
.slick-initialized .slick-slide
{
    display: block;
}
.slick-loading .slick-slide
{
    visibility: hidden;
}
.slick-vertical .slick-slide
{
    display: block;

    height: auto;

    border: 1px solid transparent;
}
.slick-arrow.slick-hidden {
    display: none;
}


/* 슬라이드 */
.intro-slide { display: flex; justify-content: center; align-items: center; position: relative; max-width: 1000px; margin:0 auto; padding:100px 0;}
.intro-slide .img-slide { margin:0 100px; max-width: 400px; width: 100%;}
.intro-slide .img-slide .track { }
.intro-slide .img-slide .track .item { }
.intro-slide .txt-slide { padding:0 60px; width: 500px;}
.intro-slide .txt-slide .track { position: relative;}
.intro-slide .txt-slide .track .item { width: 100%; height: 100%; display: none;}
.intro-slide .txt-slide .track .item.active { display: block;}
.intro-slide .txt-slide .track .item b { font-size: 40px; color:#5288fa; display: block; margin-bottom: 50px;}
.intro-slide .txt-slide .track .item p { font-size: 36px; color:#212225; display: block; font-weight: bold; margin-bottom: 20px;}
.intro-slide .txt-slide .track .item span { font-size: 20px; color:#8f94a3; display: block; line-height: 160%;}
.intro-slide .slide-btn { position: absolute; width: 450px; top:50%; transform: translateY(-50%); display: flex; justify-content: space-between;}

</style>

<!-- row -->
<div class="row">
	
	<!-- 왼쪽 메뉴 -->
	<div class="col-md-2">
		<div class="card">
			<div class="card-header">
				sample1
			</div>
			<ul class="nav nav-pills flex-column">
			  <li class="nav-item">
			    <a class="nav-link text-decoration-none link-light active" href="#">게시판</a>
			  </li>
			  <li class="nav-item">
			    <a class="nav-link text-decoration-none link-dark" href="#">A second item</a>
			  </li>
			  <li class="nav-item">
			    <a class="nav-link text-decoration-none link-dark" href="#">A third item</a>
			  </li>
			</ul>
		</div>
	</div>
	
	<!-- 컨텐츠 내용 -->
	<div class="col-md-10">
	
		<!-- sub title -->
	    <h2 class="bd-title border-bottom pb-3 mb-3">게시판</h2>
	    
		<!-- 검색입력 -->
		<div class="head border-bottom pb-3 mb-3">
            <h3><c:out value="${getSample1Info.post_title}"/></h3>
            <span id="regist-name" class="text-muted"><c:out value="${getSample1Info.regist_id}"/></span>
            <span class="text-muted">|</span>
            <span id="regist-date" class="text-muted"><c:out value="${getSample1Info.regist_date}"/></span>
		</div>
        
        <% pageContext.setAttribute("newLineChar", "\n"); %>
        <c:set var="post_content" value="${fn:replace(getSample1Info.post_content, newLineChar, '<br/>')}"/>
		<div class="body pb-3">
			${post_content}
		</div>
		 
		<div class="intro-slide">
			<div class="img-slide">
				<div class="track">
					<c:forEach items="${getFileDetailList}" var="getFileDetailInfo">
						<div class="item"><img width="400" height="400" alt="" src="/upload/edu1/post/${getFileDetailInfo.fileName}"></div>
		        	</c:forEach>
				</div>
			</div>
			<div class="slide-btn">
				<a href="javascript:void(0)" class="btn btn-dark intro-slide-prev"><i class="bi bi-arrow-left"></i></a>
				<a href="javascript:void(0)" class="btn btn-dark intro-slide-next"><i class="bi bi-arrow-right"></i></a>
			</div>
		</div>

		<div class="pt-3 border-top">
			<div class="col-12 d-flex justify-content-end align-items-center">
				<a class="btn btn-md btn-outline-dark ms-2" href="<c:url value="/sample1/list.do"/>" >목록</a>
	            <a class="btn btn-md btn-danger ms-2" href="<c:url value="javascript:fnDelete(${getSample1Info.post_seq})"/>" >삭제</a>
	            <a class="btn btn-md btn-primary ms-2" href="<c:url value="/sample1/form.do?post_seq=${getSample1Info.post_seq}"/>">수정</a>
			</div>
		</div>
	</div>
</div>
<!-- //contents -->



<script>

$(document).ready(function () {
 
	/*슬라이더*/
	$('.img-slide .track').slick({
            dots: false,
            prevArrow: $('.intro-slide-prev'),
            nextArrow: $('.intro-slide-next'),
            infinite: true,
            speed: 500,
            slidesToShow: 1,
            slidesToScroll: 1,
            autoplay: true,
            autoplaySpeed: 5000,
            pauseOnHover: false,
            centerPadding: '0px',
            fade: false,
            dots: false
        });

        //setInterval(function() {
            //var Sid = $('.slick-slide').index();
            //var currentSid = $('.slick-slide.slick-active').index();
            //$('.txt-slide .item').removeClass('active');
            //$('.txt-slide .item').eq(currentSid - 1).addClass('active');
        //},300);
});

	//삭제 버튼 클릭시
	function fnDelete(seq){
		if (confirm("게시글을 삭제 하시겠습니까?")) {
			let f = document.createElement('form');
		    
		    let obj;
		    obj = document.createElement('input');
		    obj.setAttribute('type', 'hidden');
		    obj.setAttribute('name', 'post_seq');
		    obj.setAttribute('value', seq);
		    
		    f.appendChild(obj);
		    f.setAttribute('method', 'post');
		    f.setAttribute('action', '/sample1/form-delete.do');
		    
		    document.body.appendChild(f);
		    f.submit();
	    }
	}
	
</script>