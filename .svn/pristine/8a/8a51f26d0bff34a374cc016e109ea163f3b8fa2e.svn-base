package egovframework.com.cmm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @Class Name : InitInterceptor.java
 * @Description : InitInterceptor class
 * @Modification Information
 * @
 * @ 수정일			수정자		수정내용
 * @ ---------   	---------   -------------------------------
 * @ 2020.01.01     jeongwoo	최초 생성
 *
 * @author jeongwoo
 * @since 2020.01.01
 * @version 1.0
 * @see
 *
 * @Copyright (C) by JOINTREE All right reserved.
 */
@Component
public class InitInterceptor extends HandlerInterceptorAdapter {

	public static Logger log = LoggerFactory.getLogger(InitInterceptor.class);

	@Value("${Configs.deploy.Menu}")
	private String ConfigsDeployMenu;

	@Value("${Configs.deploy.Layout}")
	private String ConfigsDeployLayout;

	@Value("${Configs.cms.Id}")
	private String jointreeCmsId;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		if (log.isDebugEnabled()) {
			log.debug("======================================          START         ======================================");
			log.debug(" Request URI \t:  " + request.getRequestURI());
		}

		//인증된사용자 여부
		/*
		boolean isAuthenticated = EgovUserDetailsHelper.isAuthenticated();
		if(isAuthenticated) {
			JvUsermaster user = (JvUsermaster) EgovUserDetailsHelper.getAuthenticatedUser();
			if(user.getType().equals("MANAGER")) {
				//비밀번호 변경의 경우가 있을 경우
				*//*
				LoginVO chkPwVO = loginService.checkUserPw(user);
				if(chkPwVO.getTmpPw().equals("N")) {
					ModelAndView modelAndView = new ModelAndView("redirect:/service/home/ChangeHome.do");
					throw new ModelAndViewDefiningException(modelAndView);
				}
				*//*
			}
		}
		*/

		/*
		if(request.getRequestURI().indexOf(jointreeCmsId) > -1){
			request.setAttribute("siteId", jointreeCmsId);
		}else{

			String urlInfo = EgovStringUtil.isNullToString(request.getRequestURL());
			if(!urlInfo.equals("")){
				String domainInfo = urlInfo.substring(urlInfo.indexOf("//") + 2, urlInfo.lastIndexOf("/"));
				String[] domainArr = domainInfo.split("/");

				log.debug("domainInfo : {}", domainInfo);
				log.debug("domainArr : {}", domainArr[0]);

				String referer = request.getHeader("referer");
				log.debug("referer : {}", referer);
				*/
				/*
				if(EgovStringUtil.isNullToString(referer).indexOf(domainArr[0]) <= -1){
					log.debug("최초 접근시 방문 기록을 쌓은다.");
					commonService.setVisitLogInsert(request, 2);
					//여기는 로그를 쌓아야 된다.(방문기록)
				}
				*/
				/*
			}
		}
		*/

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
						   ModelAndView modelAndView) throws Exception {

		//log.debug("siteId = {}", request.getAttribute("siteId"));
		request.getSession().setAttribute("siteId", request.getAttribute("siteId"));

		if (log.isDebugEnabled()) { log.debug("====================================== END ======================================"); }

		super.postHandle(request, response, handler, modelAndView);
	}
}
