package egovframework.com.cmm.exception;

import egovframework.com.cmm.response.ResponseCode;

public class LoginException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public LoginException(ResponseCode responseCode) {
        this.responseCode = responseCode;
    }

    private final ResponseCode responseCode;

    public ResponseCode getResponseCode() {
        return responseCode;
    }

}
