package egovframework.com.cmm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import egovframework.com.cmm.exception.CustomException;
import egovframework.com.cmm.exception.CustomPageException;
import egovframework.com.cmm.util.EgovStringUtil;

public class ApiInterceptor extends HandlerInterceptorAdapter {

  public static Logger log = LoggerFactory.getLogger(ApiInterceptor.class);

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
          throws Exception {

    if (log.isDebugEnabled()) {
      log.debug("======================================          API START         ======================================");
      log.debug(" Request URI \t:  " + request.getRequestURI());
      log.debug(" Method \t:  " + request.getMethod());
    }

    if(request.getHeader("Accept").indexOf("application/json") < 0){
      throw new CustomPageException(HttpStatus.ACCEPTED, "접근이 불가능한 페이지 입니다.");
    }

    String token = request.getHeader("token");
    if (EgovStringUtil.isNullToString(token).equals("token123jointree!@#!@#000123")) {
      return super.preHandle(request, response, handler);
    } else {
      throw new CustomException(HttpStatus.UNAUTHORIZED, "Unauthorized");
    }

  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                         ModelAndView modelAndView) throws Exception {

    //commonService.setApiLogInsert(request, "데이터 처리가 정상적으로 진행 되었습니다", false);

    if (log.isDebugEnabled()) { log.debug("======================================          API END         ======================================"); }
  }
}
