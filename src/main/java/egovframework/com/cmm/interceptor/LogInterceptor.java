package egovframework.com.cmm.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 사용자IP 체크 인터셉터
 * @author 유지보수팀 이기하
 * @since 2013.03.28
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일     수정자          수정내용
 *  ----------  --------    ---------------------------
 *  2013.03.28	이기하          최초 생성
 *  </pre>
 */

public class LogInterceptor extends HandlerInterceptorAdapter {

	public static Logger log = LoggerFactory.getLogger(LogInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug("======================================          START         ======================================");
			log.debug(" Request URI \t:  " + request.getRequestURI());
		}

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
						   ModelAndView modelAndView) throws Exception {

		if (log.isDebugEnabled()) { log.debug("====================================== END ======================================"); }

		super.postHandle(request, response, handler, modelAndView);
	}
}
