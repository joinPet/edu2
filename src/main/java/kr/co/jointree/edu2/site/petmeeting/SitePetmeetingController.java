package kr.co.jointree.edu2.site.petmeeting;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import egovframework.com.cmm.model.JtFileDetail;
import egovframework.com.cmm.paging.PagingAccess;
import egovframework.com.cmm.service.ComCmmFileService;
import egovframework.com.cmm.util.EgovStringUtil;
import kr.co.jointree.edu2.site.main.service.SiteMainService;
import kr.co.jointree.edu2.site.profile.service.SitePetService;

@Controller
public class SitePetmeetingController {

    public static Logger log = LoggerFactory.getLogger(SitePetmeetingController.class);

    @Autowired
    SiteMainService siteMainService;
    
    @Autowired
    ComCmmFileService comCmmFileService;
    
    @Autowired
    SitePetService sitePetService;    
    @Autowired
    PagingAccess pagingAccess;

    @GetMapping(value = {"/petmeeting/list.do"})
    public String petmeetList(
    		HttpServletRequest request
    		,Model model
    		,@RequestParam Map<String, Object> paramMap
    ) { 
    	List<Map<String, Object>> petListAll = sitePetService.petListAll();
    	 model.addAttribute("petListAll", petListAll);
    	 
    	 for(Map<String, Object> petListinfo : petListAll) {
     		// 펫 프로필 이미지 가져오기
 	    	long fileSeq = Long.parseLong(EgovStringUtil.isNullToString(petListinfo.get("file_seq"),"0"));
 	        List<JtFileDetail> getFileDetailList = comCmmFileService.getFileDetailList(fileSeq);
 	       petListinfo.put("getFileDetailList", getFileDetailList);
 	        
     	 }
    	 model.addAttribute("petListAll", petListAll);
         return "/site/petmeeting/list.site";
    }
}