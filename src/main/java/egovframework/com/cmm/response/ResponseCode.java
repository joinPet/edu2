package egovframework.com.cmm.response;

import org.springframework.http.HttpStatus;

public enum ResponseCode {

    /*
     * 202 SUCCESS: 성공
     */
    OK(HttpStatus.OK, "데이터 처리가 정상적으로 진행 되었습니다"),

    /*
     * 400 BAD_REQUEST: 잘못된 요청
     */
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "잘못된 요청입니다."),

    /*
     * 401 UNAUTHORIZED: 권한이 없습니다
     */
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "권한이 없습니다."),

    /*
     * 404 NOT_FOUND: 리소스를 찾을 수 없음
     */
    NOT_FOUND(HttpStatus.NOT_FOUND, "리소스를 찾을 수 없습니다."),

    /*
     * 405 METHOD_NOT_ALLOWED: 허용되지 않은 Request Method 호출
     */
    METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, "허용되지 않은 메서드입니다."),

    /*
     * 500 INTERNAL_SERVER_ERROR: 내부 서버 오류
     */
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "내부 서버 오류입니다."),

    /*
     * 로그인 성공
     */
    LOGIN(HttpStatus.OK, "로그인 되었습니다."),

    /*
     * 로그인 실패
     */
    NO_USER(HttpStatus.ACCEPTED, "아이디가 존재하지 않거나\n비밀번호가 맞지 않습니다"),

    /*
     * 로그인 횟수 초과
     */
    FAIL_OVER(HttpStatus.ACCEPTED, "인증횟수를 초과하여 계정이 잠겼습니다.\n잠시후 다시 시도해 주세요."),

    /*
     * 로그인 횟수 초과
     */
    FAIL_OVER_SITE(HttpStatus.ACCEPTED, "인증 횟수를 초과하여 계정이 잠겼습니다.\n5분후 로그인하실 수 있습니다."),

    /*
     * 아이디 사용가능
     */
    ID_DUPLICATION_OK(HttpStatus.OK, "사용가능한 아이디 입니다."),

    /*
     * 아이디 중복
     */
    ID_DUPLICATION_ERROR(HttpStatus.ACCEPTED, "이미 가입된 아이디 입니다."),

    /*
     * 회원가입
     */
    SIGNUP(HttpStatus.OK, "회원가입이 완료 되었습니다."),

    /*
     * 찾기 성공
     */
    USER_FIND_OK(HttpStatus.OK, "정보 찾기 성공"),

    /*
     * 찾기 정보 없음
     */
    USER_FIND_ERROR(HttpStatus.ACCEPTED, "회원님의 입력 정보로 가입된 \n아이디가 없습니다."),

    /*
     * 비밀번호 찾기 정보
     */
    USER_PW_FIND_OK(HttpStatus.OK, "회원님이 입력하신 메일로 임시 비밀번호가 전달 되었습니다.\n메일을 확인 해주세요."),

    /*
     * 로그인 실패
     */
    NO_PASSWD(HttpStatus.ACCEPTED, "비밀번호 정보가 맞지 않습니다."),

    /*
     * 찾기 정보 없음
     */
    UNLINK_OK(HttpStatus.OK, "회원탈퇴가 완료되었습니다.\n그동안 이용해주셔서 감사합니다.\n보다 나은 서비스로 다시 뵙기를 기대하겠습니다."),

    /*
     * 찾기 정보 없음
     */
    UNLINK_ERROR(HttpStatus.ACCEPTED, "회원님의 입력 정보가 일치 하지 않습니다."),

    /*
     * 찾기 정보 없음
     */
    USER_OK(HttpStatus.OK, "회원정보가 수정되었습니다"),
    ;

    ResponseCode(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    private final HttpStatus status;
    private final String message;

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

}
