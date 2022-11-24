package kr.co.jointree.edu2.site.reservation;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import egovframework.com.cmm.paging.PagingAccess;
import kr.co.jointree.edu2.site.main.service.SiteMainService;
import kr.co.jointree.edu2.site.profile.service.SitePetService;
import kr.co.jointree.edu2.site.reservation.service.SiteReservationService;

@Controller
public class SiteReservationController {

    public static Logger log = LoggerFactory.getLogger(SiteReservationController .class);

    @Autowired
    SiteMainService siteMainService;
    
    @Autowired
    PagingAccess pagingAccess;
    
    @Autowired
    SitePetService sitepetService;
    @Autowired
    SiteReservationService sitereservationService;
    
   
    @GetMapping(value = {"/reservation/res_form.do"})
    public String res_form(
    		HttpServletRequest request
    		,Model model
    		,@RequestParam Map<String, Object> paramMap
    ) {
        
        
    	Map<String, Object> petInfo = sitepetService.petInfo(paramMap);
    	model.addAttribute("petInfo",petInfo);
    	return "/site/reservation/res_form.site";
    }
    @PostMapping(value = {"reservation/res_save.do"})
    public String res_save(
    		HttpServletRequest request
    		,Model model
    		,@RequestParam Map<String, Object> paramMap   		
    	) {
    	 //예약 등록
    	sitereservationService.resInsert(paramMap);
    	
    	return "redirect:/reservation/res_list.do";
    }
    @GetMapping(value = {"/reservation/res_list.do"})
    public String res_list(
    		HttpServletRequest request
    		,Model model
    		,@RequestParam Map<String, Object> paramMap
    ) {
    	HttpSession session = request.getSession();
        Map<String, Object> member = (Map<String, Object>) session.getAttribute("member");
        List<Map<String, Object>> resList =  (List<Map<String, Object>>) sitereservationService.resList((String)member.get("user_id"));
        List<Map<String, Object>>sendList = (List<Map<String, Object>>) sitereservationService.sendList((String)member.get("user_id"));
        model.addAttribute("resList", resList);
        model.addAttribute("sendList", sendList);
        return "/site/reservation/res_list.site";
    }
   
    
}
