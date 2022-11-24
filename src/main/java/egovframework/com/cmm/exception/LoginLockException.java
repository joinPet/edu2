package egovframework.com.cmm.exception;

import org.springframework.security.core.AuthenticationException;

public class LoginLockException extends AuthenticationException {

    private static final long serialVersionUID = 1L;
    
	public LoginLockException(String msg) { super(msg); }
	
    public LoginLockException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
