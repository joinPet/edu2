package egovframework.com.cmm.exception;

import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import egovframework.com.cmm.response.ResponseCode;
import egovframework.com.cmm.response.ResponseModel;
import egovframework.com.cmm.util.EgovStringUtil;

@RestControllerAdvice
public class GlobalExceptionHandler {

    public static Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /*
     * Developer Custom Exception
     */
    @ExceptionHandler(CustomPageException.class)
    protected String handleCustomPageException(
            final CustomPageException e
    ) throws Exception {

        throw new Exception(e.getMessage());
    }

    /*
     * Developer Custom Exception
     */
    @ExceptionHandler(CustomException.class)
    protected ResponseEntity<ResponseModel> handleCustomException(
            HttpServletRequest request
            ,final CustomException e
    ) throws Exception {
        log.error("handleCustomException: {}", e.getHttpStatus());

        if(request.getRequestURI().indexOf(".do") > -1){

            throw new Exception(e.getMessage());
        }else{
            //API 로그 정보 저장
            //commonService.setApiLogInsert(request, e.getMessage(), true);

            return ResponseEntity
                    .status(e.getHttpStatus())
                    .body(new ResponseModel(e.getHttpStatus().value(), e.getHttpStatus().getReasonPhrase(), e.getMessage()));
        }

    }

    /*
     * login Custom Exception
     */
    @ExceptionHandler(LoginException.class)
    protected ResponseEntity<ResponseModel> handleCustomException(
            HttpServletRequest request
            ,final LoginException e
    ) throws Exception {
        log.error("handleCustomException: {}", e.getResponseCode().getStatus().value());

        if(request.getRequestURI().indexOf(".do") > -1){

            throw new Exception(e.getResponseCode().getMessage());
        }else{
            return ResponseEntity
                    .status(e.getResponseCode().getStatus().value())
                    .body(new ResponseModel(e.getResponseCode(), "", e.getResponseCode().getMessage()));
        }


    }

    /*
     * ValidException
     */
    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity<ResponseModel> handleConstraintViolationException(
            HttpServletRequest request
            ,ConstraintViolationException e
    ) throws IOException {
        log.error("handleConstraintViolationException: {}", e.getMessage());

        //기본정보를 세팅한다.
        requestMapSetting(request, e.getMessage());

        String test = EgovStringUtil.isNullToString(e.getConstraintViolations().iterator().next().getPropertyPath());
        String fieldId = "";
        if(!test.equals("")){
            fieldId = test.substring(test.lastIndexOf(".")+1, test.length());
        }

        Map<String, Object> data = new HashMap<String, Object>();
        data.put("fieldId", fieldId);

        return ResponseEntity
                .status(ResponseCode.BAD_REQUEST.getStatus().value())
                .body(new ResponseModel(ResponseCode.BAD_REQUEST, fieldId, e.getConstraintViolations().iterator().next().getMessage()));

    }

    /*
     * IllegalArgumentException
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = { IllegalArgumentException.class, IllegalStateException.class })
    protected ResponseEntity<ResponseModel> handleIllegalArgumentException(
            HttpServletRequest request
            ,RuntimeException e
    ) throws Exception {
        log.error("handleIllegalArgumentException: {}", e.getMessage());

        if(request.getRequestURI().indexOf(".do") > -1){
            throw new IllegalArgumentException(e.getMessage());

        }else{
            //기본정보를 세팅한다.
            requestMapSetting(request, e.getMessage());

            return ResponseEntity
                    .status(ResponseCode.BAD_REQUEST.getStatus().value())
                    .body(new ResponseModel(ResponseCode.BAD_REQUEST, "", e.getMessage()));
        }


    }

    /*
     * HTTP 401 Exception
     */
    @ExceptionHandler(AccessDeniedException.class)
    protected ResponseEntity<ResponseModel> handleAccessDeniedException(
            HttpServletRequest request
            ,AccessDeniedException e
    ) throws Exception {
        log.error("handleAccessDeniedException: {}", e.getMessage());

        if(request.getRequestURI().indexOf(".do") > -1){
            throw new AccessDeniedException(e.getMessage());
        }else{
            //기본정보를 세팅한다.
            requestMapSetting(request, e.getMessage());

            return ResponseEntity
                    .status(ResponseCode.UNAUTHORIZED.getStatus().value())
                    .body(new ResponseModel(ResponseCode.UNAUTHORIZED, "", e.getMessage()));
        }

    }

    /*
     * HTTP 404 Exception
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    protected ResponseEntity<ResponseModel> handleNoHandlerFoundException(
            HttpServletRequest request
            ,NoHandlerFoundException e
    ) throws Exception {
        log.error("handleNoHandlerFoundException: {}", e.getMessage());
        String accept = EgovStringUtil.isNullToString(e.getHeaders().get("accept"));
        log.debug("accept : {}", accept);

        if(accept.indexOf("application/json") >= 0){

            //기본정보를 세팅한다.
            requestMapSetting(request, e.getMessage());

            return ResponseEntity
                    .status(ResponseCode.NOT_FOUND.getStatus().value())
                    .body(new ResponseModel(ResponseCode.NOT_FOUND, "", e.getMessage()));

        } else {
            throw new NoHandlerFoundException(request.getMethod(), request.getRequestURI(), new HttpHeaders());
        }
    }

    /*
     * HTTP 405 Exception
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    protected ResponseEntity<ResponseModel> handleHttpRequestMethodNotSupportedException(
            HttpServletRequest request
            ,final HttpRequestMethodNotSupportedException e
    ) throws Exception {
        log.error("handleHttpRequestMethodNotSupportedException: {}", e.getMessage());

        if(request.getRequestURI().indexOf(".do") > -1){

            throw new HttpRequestMethodNotSupportedException(e.getMessage());
        }else{
            //기본정보를 세팅한다.
            requestMapSetting(request, e.getMessage());

            return ResponseEntity
                    .status(ResponseCode.METHOD_NOT_ALLOWED.getStatus().value())
                    .body(new ResponseModel(ResponseCode.METHOD_NOT_ALLOWED, "", e.getMessage()));
        }

    }

    /*
     * HTTP 500 Exception
     */
    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ResponseModel> handleException(
            HttpServletRequest request
            ,final Exception e
    ) throws Exception {
        log.error("handleException: {}", e.getMessage());

        if(request.getRequestURI().indexOf(".do") > -1){
            throw new Exception(e.getMessage());
        }else{

            //기본정보를 세팅한다.
            requestMapSetting(request, e.getMessage());

            return ResponseEntity
                    .status(ResponseCode.INTERNAL_SERVER_ERROR.getStatus().value())
                    .body(new ResponseModel(ResponseCode.INTERNAL_SERVER_ERROR, "", e.getMessage()));
        }
    }

    /**
     * 기본 정보에 대한 정보를 가진다.
     * @param request
     * @throws IOException
     */
    public void requestMapSetting(
            HttpServletRequest request
            ,String massage
    ) throws IOException {

        //API 로그 정보 저장
        //commonService.setApiLogInsert(request, massage, true);

    }

}
