package kr.co.jointree.edu2.site.member;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import egovframework.com.cmm.paging.PagingAccess;
import kr.co.jointree.edu2.site.main.service.SiteMainService;
import kr.co.jointree.edu2.site.member.model.MemberVO;
import kr.co.jointree.edu2.site.member.service.SiteMemberService;
import kr.co.jointree.edu2.site.member.service.impl.SiteMemberimpl;

@Controller
public class SiteMemberController {

	public static Logger log = LoggerFactory.getLogger(SiteMemberController.class);

	@Autowired
	SiteMainService siteMainService;

	@Autowired
	PagingAccess pagingAccess;

	@Autowired
	SiteMemberService sitememberservice;

	// 아이디 중복 체크
	@RequestMapping(value = "/memberCheck", method = { RequestMethod.POST })
	@ResponseBody
	public int nameCheck(@RequestParam("user_id") String user_id) {
		return sitememberservice.memberCheck(user_id);
	}

	@GetMapping(value = { "/member/login.do" })
	public String siteLogin(HttpServletRequest request, Model model, @RequestParam Map<String, Object> paramMap) {
		return "/site/member/login.site";
	}

	@PostMapping(value = { "/member/login_select.do" })
	public String siteLoginselect(HttpServletRequest request, Model model, @RequestParam Map<String, Object> paramMap) {
		Map<String, Object> member = sitememberservice.memberLogin(paramMap);
		HttpSession session = request.getSession();
		if (member != null) {
			session.setAttribute("member", member);
			return "redirect:/main.do";
		} else {
			model.addAttribute("errmsg", "로그인 정보가 일치하지 않습니다.");
			return "/site/member/login.site";
		}
	}

	@GetMapping(value = { "/member/join.do" })
	public String siteJoin(HttpServletRequest request, Model model, @RequestParam Map<String, Object> paramMap) {
		return "/site/member/join.site";
	}

	@PostMapping(value = { "/member/join_insert.do" })
	public String siteJoininsert(HttpServletRequest request, Model model, @RequestParam Map<String, Object> member) {
		sitememberservice.memberInsert(member);
		log.debug("member : {}", member);
		return "redirect:/main.do";
	}

	@GetMapping(value = { "/member/logout.do" })
	public String siteLogout(HttpServletRequest request, Model model, @RequestParam Map<String, Object> member) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/main.do";
	}

	@GetMapping(value = { "/member/ForgotId.do" })
	public String ForgotId(HttpServletRequest request, Model model, @RequestParam Map<String, Object> paramMap) {
		return "/site/member/ForgotId.site";
	}
	
	@PostMapping(value = { "/member/GotId.do" })
	public String GotId(HttpServletResponse response, HttpServletRequest request, Model model, @RequestParam("email") String email) throws Exception {
		model.addAttribute("id", sitememberservice.memberFindID(email));
		String id = sitememberservice.memberFindID(email);
		if (id != null) {
			return "/site/member/GotId.site";
		} else {
			response.setContentType("text/html; charset=utf-8");
	        PrintWriter w = response.getWriter();
	        w.write("<script>alert('입력하신 이메일 정보가 존재하지 않습니다.');alert('회원가입 후 이용해주세요.');location.href='../member/join.do';</script>");
	        w.flush();
	        return "";
		}
	}

	@GetMapping(value = { "/member/GotPW.do" })
	public String GotPW(HttpServletRequest request, Model model, @RequestParam Map<String, Object> paramMap) {
		return "/site/member/GotPW.site";
	}
}