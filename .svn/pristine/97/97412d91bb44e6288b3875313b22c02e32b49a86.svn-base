package egovframework.com.cmm.response;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import egovframework.com.cmm.util.EgovStringUtil;

public class ResponseModel {

    public ResponseModel(ResponseCode responseCode, Object data) {
        this.status = responseCode.getStatus().value();
        this.code = responseCode.name();
        this.message = responseCode.getMessage();

        if(!EgovStringUtil.isNullToString(data).equals("")) this.data = data;
        else this.data = null;
    }

    public ResponseModel(ResponseCode responseCode, Object data, String message) {
        this.status = responseCode.getStatus().value();
        this.code = responseCode.name();
        this.message = message;

        if(!EgovStringUtil.isNullToString(data).equals(""))this.data = data;
        else this.data = null;
    }

    public ResponseModel(int errorStatus, String errorCode, String errorMessage) {
        this.status = errorStatus;
        this.code = errorCode;
        this.message = errorMessage;
        this.data = null;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private final LocalDateTime timestamp = LocalDateTime.now();
    private final int status;
    private final String code;
    private final String message;
    private final Object data;

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public int getStatus() {
        return status;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }
}
