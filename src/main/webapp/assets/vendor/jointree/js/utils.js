$(document).ready(function(){
    //영문 숫자만 입력
    $("input[textEN]").keyup(function(event){
        if (!(event.keyCode >=37 && event.keyCode<=40)) {
            let inputVal = $(this).val();
            $(this).val(inputVal.replace(/[^a-z0-9]/gi,''));
        }
    });

    $("input[textNumber]").keyup(function(event){
        if (!(event.keyCode >=37 && event.keyCode<=40)) {
            let inputVal = $(this).val();
            $(this).val(inputVal.replace(/[^0-9]/gi,''));
        }
    });
});

/**
 * 쿠키 가져오기
 * @param cName
 * @returns {string}
 */
function getCookie(cName) {
    const cookieData = document.cookie;
    let start = cookieData.indexOf(cName);
    let cValue = '';

    cName = cName + '=';

    if(start != -1){
        start += cName.length;
        var end = cookieData.indexOf(';', start);
        if(end == -1)end = cookieData.length;
        cValue = cookieData.substring(start, end);
    }
    return unescape(cValue);
}

/**
 * 24시간 기준 쿠키 설정하기(expiredays 후의 클릭한 시간까지 쿠키 설정)
 * @param cName
 * @param cValue
 * @param cDay
 */
function setCookie(cName, cValue, cDay){
    let expire = new Date();
    cDay = cDay || 365;

    expire.setDate(expire.getDate() + cDay);
    cookies = cName + '=' + escape(cValue) + '; path=/ '; // 한글 깨짐을 막기위해 escape(cValue)를 합니다.
    if(typeof cDay != 'undefined') cookies += ';expires=' + expire.toGMTString() + ';';
    document.cookie = cookies;
}

/**
 * 쿠키값을 청소 한다.
 * @param cName
 */
function clearCookie(cName){

    let expireDate = new Date();

    //어제 날짜를 쿠키 소멸 날짜로 설정한다.
    expireDate.setDate( expireDate.getDate() - 1 );
    document.cookie = cName+"= " + "; expires=" + expireDate.toGMTString() + "; path=/";
}

/**
 * 천자리 콤마
 * @param num
 * @returns {string}
 */
function numberWithCommas(num) {
    return num.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}

/**
 * 숫자 포멧 두자리로
 * @param number
 * @returns {string|*}
 */
function setTwoDigit(number){
    // 넘어온 숫자를 문자열타입으로 변환
    number += "";

    if(number.length == 1){
        return "0" + number;
    }else{
        return number;
    }
}


//input Textarea 글자수를 제한한다.
function textLimit(textInputId, cntInputId, size){
    //글자수를제한 한다.
    $('#'+textInputId).on('keyup', function() {
        $('#'+cntInputId).html("<b>"+$(this).val().length+"</b> / "+size);

        if($(this).val().length > size) {
            $(this).val($(this).val().substring(0, size));
            $('#'+cntInputId).html("<b>"+size+"</b> / "+size);
        }
    });
}

/**
 * 비밀번호 체트
 * @param str
 * @returns {boolean}
 */
function checkPassWord(str){

    const num = str.search(/[0-9]{2,}/g);
    const eng = str.search(/[a-z]{2,}/ig);
    const spe = str.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]{2,}/gi);

    if(str.length < 8 ){
        return false;
    }

    if(str.search(/\s/) != -1){
        return false;
    }

    if(num < 0 || eng < 0 || spe < 0 ) {
        return false;
    }
    //return "비밀번호는 영문, 숫자, 특수문자를 각 2자이상 혼합하여 8자리 이상 입력해주세요.";
    return true;
}

/**
 * 이메일 유효성 체크
 * @param str
 * @returns {boolean}
 */
function checkEmail(str) {
    const pattern = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
    if(ifNull(str) != ''){
        if( !pattern.test(str) ){
            return false;
        }
    }

    return true;
}

/**
 * 전화번호 유효성 체크
 * @param str
 * @returns {boolean}
 */
function checkTel(str) {

    if(ifNull(str) != ''){

        if(str.indexOf("-") < 0){
            str = phoneFomatter(str)
        }

        const regTel = /^(01[016789]{1}|02|0[3-9]{1}[0-9]{1})-[0-9]{3,4}-[0-9]{4}$/;
        if(!regTel.test(str)) {
            return false;
        }

    }

    return true;
}

/**
 * 아이피 유효성 체크
 * @param str
 * @returns {boolean}
 */
function checkIPAddress(str) {
    const pattern = /^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$/;
    if (!pattern.test(str)) {
        return false;
    } else {
        return true;
    }
}

/**
 * 전화번호 유효성 체크
 * @param str
 * @returns {boolean}
 */
function phoneFomatter(num){
    var formatNum = '';
    if(num.length==11){
        formatNum = num.replace(/(\d{3})(\d{4})(\d{4})/, '$1-$2-$3');
    }else if(num.length==8){
        formatNum = num.replace(/(\d{4})(\d{4})/, '$1-$2');
    }else{
        if(num.indexOf('02')==0){
            formatNum = num.replace(/(\d{2})(\d{4})(\d{4})/, '$1-$2-$3');
        }else{
            formatNum = num.replace(/(\d{3})(\d{3})(\d{4})/, '$1-$2-$3');
        }
    }
    return formatNum;
}

/**
 *
 * @param inputName
 * @returns {boolean}
 */
function validationCheck(inputName){
    if($('input[name='+inputName+']').val() == ''){
        fnSweetalert("필수값 입력", "필수값을 입력 해주세요", "warning", false, false, 2000, function() {
            $('input[name='+inputName+']').focus();
            return false;
        });
        return false;
    }else{
        return true;
    }

}

/**
 * 오늘 날짜를 리턴
 * @param type
 * : datetime 	--> 2022-01-16 12:20:40
 * : date 	    --> 2022-01-16
 * : y 		    --> 2022
 * : m 		    --> 01
 * : d 		    --> 16
 * : h 		    --> 12
 * : mi 	    --> 20
 * : s 		    --> 40
 * @returns {string|string|number}
 */
function getNowDate(type){
    let date = new Date();

    if(type == 'datetime'){
        return date.getFullYear() + "-" + setTwoDigit(date.getMonth() + 1) + "-" + setTwoDigit(date.getDate())
            + " " + setTwoDigit(date.getHours()) + ":" + setTwoDigit(date.getMinutes()) + ":" + setTwoDigit(date.getSeconds());
    }else if(type == 'date'){
        return date.getFullYear() + "-" + setTwoDigit(date.getMonth() + 1) + "-" + setTwoDigit(date.getDate());
    }else if(type == 'y'){
        return date.getFullYear();
    }else if(type == 'm'){
        return setTwoDigit(date.getMonth() + 1);
    }else if(type == 'd'){
        return setTwoDigit(date.getDate());
    }else if(type == 'h'){
        return setTwoDigit(date.getHours());
    }else if(type == 'mi'){
        return setTwoDigit(date.getMinutes());
    }else if(type == 'S'){
        return setTwoDigit(date.getSeconds());
    }
}

/**
 * 널값 처리를 한다.
 * @param cName
 * @param text
 * @returns
 */
function ifNull(keyVal ,defaultVal) {
    if((keyVal !== 'undefined') && (keyVal !== undefined) && (keyVal !== '') && (keyVal !== null)){
        keyVal = keyVal;
    }else{
        if((defaultVal !== 'undefined') && (defaultVal !== undefined) && (defaultVal !== '') && (defaultVal !== null)){
            keyVal = defaultVal;
        }else{
            keyVal = "";
        }
    }

    return XSSCheck(keyVal,1);
}

/**
 * 폼 전송
 * @param type
 * @param url
 * @param formData
 * @param alertType
 * @param out_data
 */
function ajaxForm(type, url, formData, alertType, out_data) {

    const contextPath = $('#contextPathHolder').attr('data-contextPath') ? $('#contextPathHolder').attr('data-contextPath') : '';
    const headerConf = {
        "token": "token123jointree!@#!@#000123"
    };

    if(type.toLowerCase() == 'get'){
        formData = serialize(formData);
    }else{
        formData = formData;
    }

    let ls_processData = true;
    let ls_contentType = 'application/x-www-form-urlencoded; charset=UTF-8';
    if ($.type(formData) === 'object') {
        if (formData instanceof FormData) {
            ls_processData = false;
            ls_contentType = false;
        }
    }

    $.ajax({
        type : type
        ,url : contextPath + url
        ,cache : false
        ,data : formData
        ,processData: ls_processData
        ,contentType: ls_contentType
        ,dataType : 'json'
        ,headers : headerConf
        ,traditional: true
        ,crossOrigin: true
        ,complete  : function(response) {
            const result = response.responseJSON;
            if ( result.status == '200') {
            	if($.type(out_data) === 'function') out_data(result);
            } else {
            	if($.type(out_data) === 'function') out_data(result);
            }
        }
    });
}

/**
 * 저장시 confirm 호출 및 폼 전송
 * @param type
 * @param url
 * @param formData
 * @param alertType
 * @param validate
 * @param out_data
 */
function ajaxFormSave(type, url, formData, alertType, out_data) {
    let conf = {title: "저장", text: "데이터를 저장 합니다. ", icon: "warning", buttons: true, dangerMode: false};
    swal(conf).then(function(willDelete){
        if(willDelete){
            ajaxForm(type, url, formData, alertType, out_data);
        }
    });
}

/**
 * 삭제시 confirm 호출 및 폼 전송
 * @param type
 * @param url
 * @param formData
 * @param alertType
 * @param validate
 * @param out_data
 */
function ajaxFormDelete(type, url, formData, alertType, out_data) {
    let conf = {title: "삭제", text: "데이터를 삭제 합니다.", icon: "warning", buttons: true, dangerMode: true};
    swal(conf).then(function(willDelete){
        if(willDelete){
            ajaxForm(type, url, formData, alertType, out_data);
        }
    });
}

/**
 * 사용자 지정 confirm 호출 및 폼 전송
 * @param type
 * @param url
 * @param formData
 * @param alertType
 * @param validate
 * @param out_data
 */
function ajaxFormCustom(title, text, icon, buttons, dangerMode, type, url, formData, alertType, out_data) {
    let conf = {title: title, text: text, icon: icon, buttons: buttons, dangerMode: dangerMode};
    swal(conf).then(function(willDelete){
        if(willDelete){
            ajaxForm(type, url, formData, alertType, out_data);
        }
    });
}


function XSSCheck(str, level) {
    str = str.toString();
    if (level == undefined || level == 0) {
        str = str.replace(/\<|\>|\"|\'|\%|\;|\(|\)|\&|\+|\-/g,"");
    } else if (level != undefined && level == 1) {
        str = str.replace(/\</g, "&lt;");
        str = str.replace(/\>/g, "&gt;");
    }
    return str;
}

function HtmlCheck(str){
    if(ifNull(str) != ''){
        str = str.replace(/&lt;/g,"<");
        str = str.replace(/&gt;/g,">");

        str = str.replace(/&quot;/g,"\"");
    }

    return str;
}

function getContextPath(){
    var contextPath = $('#contextPathHolder').attr('data-contextPath') ? $('#contextPathHolder').attr('data-contextPath') : '';
    return contextPath;
}


/**
 * 모바일 구분
 */
var isMobile = {
    Android: function () {
        return navigator.userAgent.match(/Android/i);
    },
    BlackBerry: function () {
        return navigator.userAgent.match(/BlackBerry/i);
    },
    iOS: function () {
        return navigator.userAgent.match(/iPhone|iPad|iPod/i);
    },
    Opera: function () {
        return navigator.userAgent.match(/Opera Mini/i);
    },
    Windows: function () {
        return navigator.userAgent.match(/IEMobile/i);
    },
    any: function () {
        return (isMobile.Android() || isMobile.BlackBerry() || isMobile.iOS() || isMobile.Opera() || isMobile.Windows());
    }
};

Date.prototype.format = function(){
    var yyyy = this.getFullYear().toString();
    var mm = (this.getMonth() + 1).toString();
    var dd = this.getDate().toString();

    return yyyy + '-' + (mm[1] ? mm : '0'+mm[0]) + '-' + (dd[1] ? dd : '0'+dd[0]);

}

/**
 * 언어
 */
var lang = $('html').attr('lang');


/**
 * 데이터테이블 언어 옵션
 */
var datatable_laguageOption = {
    "lengthMenu": "_MENU_",
    "zeroRecords": "검색 결과가 없습니다.",
    "paginate": {"next": "<i class='fa fa-arrow-right'></i>", "previous": "<i class='fa fa-arrow-left'></i>", "first": "첫페이지", "last": "마지막 페이지"},
    "loadingRecords":   "불러오는 중...",
    "processing":       "계산 중...",
    "info":             " _TOTAL_건 중 _START_~_END_번째 결과",
    "infoEmpty":             " _TOTAL_건 중 0~0번째 결과",
    "infoFiltered":             "(총 _MAX_ 건중 매칭된 데이터)",
    "buttons":{
        copyTitle: '클립보드에 복사',
        copySuccess: {
            _: '%d개 열의 내용을 복사했습니다.',
            1: '1개 열의 내용을 복사했습니다.'
        }
    },
    "sSearch" : '<span class="input-group-addon"><i class="glyphicon glyphicon-search"></i></span>'
};

/**
 * replaceAll 추가
 */
String.prototype.replaceAll = function(org, dest) {
    return this.split(org).join(dest);
}

/**
 * form 데이터 josn
 * @param
 * @returns
 */
jQuery.fn.serializeObject = function() {
    var obj = null;
    try {
        if (this[0].tagName && this[0].tagName.toUpperCase() == "FORM") {
            var arr = this.serializeArray();
            if (arr) {
                obj = {};
                jQuery.each(arr, function() {
                    obj[this.name] = this.value;
                });
            }//if ( arr ) {
        }
    } catch (e) {
        alert(e.message);
    } finally {
    }

    return obj;
};

function serialize(rawData) {
    if(rawData instanceof FormData){
        let rtnData = {};
        for (let [key, value] of rawData) {
            rtnData[key] = value;
        }

        return rtnData;
    }else{

        return rawData;
    }
}

(function($) {
    const csrfHeader = $('meta[name="_csrf_header"]').attr('content')
    const csrfToken = $('meta[name="_csrf"]').attr('content')

    $.ajaxSetup({
        /*
        beforeSend: function(xhr) {
            xhr.setRequestHeader(csrfHeader, csrfToken);
        },
        */
        error: function(xhr, status, err) {
            if (xhr.status == 401) {
                fnSweetalert("세션 만료", "세션이 만료되어 로그인 화면으로 이동합니다.", "warning", false, false, 2000, function() {
                    location.reload();
                });
            } else if (xhr.status == 403) {
                fnSweetalert("세션 만료", "세션이 만료되어 로그인 화면으로 이동합니다.", "warning", false, false, 2000, function() {
                    location.reload();
                });
            } else{
                fnSweetalert("시스템 오류", ifNull(err,"시스템 오류가 발생 했습니다."), "warning", false, true, '', function() {
                    location.reload();
                });
            }
        }
    });
})(jQuery);


/**
 * 별로 암호화 하기
 * @param strName
 * @returns {*}
 */
function strLengthStart(strName){
    if(ifNull(strName) == '' ) return;

    if (strName.length > 2) {

        let originName = strName.split('');

        originName.forEach(function(name, i) {
            if (i >= originName.length - 2) originName[i] = '*';
        });

        let joinName = originName.join();
        return joinName.replace(/,/g, '');
    } else {

        let pattern = /.$/; // 정규식
        return strName.replace(pattern, '*');
    }

}

function fnEllipsis(strVal, num){
    if(ifNull(strVal) != ''){
        const length = num; // 표시할 글자수 기준
        if (strVal.length > length) {
            strVal = strVal.substr(0, length-2) + '...';
        }
    }else{
        strVal = strVal;
    }

    return ifNull(strVal);
}

function decodeEntities(encodedString) {
    var textArea = document.createElement('textarea');
    textArea.innerHTML = encodedString;
    return textArea.value;
}
