package kr.co.jointree.edu2.site.profile;

import java.io.IOException;
import java.time.LocalDateTime;
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
import org.springframework.web.multipart.MultipartFile;

import egovframework.com.cmm.model.JtFileDetail;
import egovframework.com.cmm.paging.PaginationInfo;
import egovframework.com.cmm.paging.PagingAccess;
import egovframework.com.cmm.service.ComCmmFileService;
import egovframework.com.cmm.util.EgovClntInfo;
import egovframework.com.cmm.util.EgovStringUtil;
import kr.co.jointree.edu2.site.member.service.SiteMemberService;
import kr.co.jointree.edu2.site.profile.service.SitePetService;
import kr.co.jointree.edu2.site.sample1.service.SiteSample1Service;

@Controller
public class SiteProfileController {

    public static Logger log = LoggerFactory.getLogger(SiteProfileController.class);

    @Autowired
    SiteSample1Service siteSample1Service;
    
    @Autowired
    ComCmmFileService comCmmFileService;
    
    @Autowired
    SitePetService sitepetService;
    @Autowired
    PagingAccess pagingAccess;
    
    @Autowired
    SiteMemberService sitememberservice;
    
    
    /**
     * 리스트 화면
     * @param request
     * @param model
     * @return
     */
    @GetMapping(value = {"/profile/profile.do"})
    public String siteProfile(
    		HttpServletRequest request
    		,Model model
    		,@RequestParam Map<String, Object> paramMap
    ) {
    	HttpSession session = request.getSession();
    	Map<String, Object> member = (Map<String, Object>) session.getAttribute("member");
    	Map<String, Object> memberinfo = sitememberservice.memberInfo(((String)member.get("user_id")));
    	 model.addAttribute("memberinfo", memberinfo);
        return "/site/profile/profile.site";
    }
    @GetMapping(value = {"/profile/petprofile.do"})
    public String sitepetProfile(
    		HttpServletRequest request
    		,Model model
    		,@RequestParam Map<String, Object> paramMap
    ) {           
       Map<String, Object> petInfo= sitepetService.petInfo(paramMap);
        model.addAttribute("petInfo",petInfo);
    	long fileSeq = Long.parseLong(EgovStringUtil.isNullToString(petInfo.get("file_seq"),"0"));
        List<JtFileDetail> getFileDetailList = comCmmFileService.getFileDetailList(fileSeq);
        model.addAttribute("getFileDetailList", getFileDetailList);
        
        return "/site/profile/petprofile.site";
    }
    @GetMapping(value = {"/profile/petmanage.do"})
    public String sitepetManage(
    		HttpServletRequest request
    		,Model model
    		,@RequestParam Map<String, Object> paramMap
    ) {
    	HttpSession session = request.getSession();
    	Map<String, Object> member = (Map<String, Object>) session.getAttribute("member");
    	
    	//펫 프로필 관리에서 펫 리스트 가져오기
    	 List<Map<String, Object>> petListByList = sitepetService.petListByID(((String)member.get("user_id")));
    	 
    	 for(Map<String, Object> petListByInfo : petListByList) {
    		// 펫 프로필 이미지 가져오기
	    	long fileSeq = Long.parseLong(EgovStringUtil.isNullToString(petListByInfo.get("file_seq"),"0"));
	        List<JtFileDetail> getFileDetailList = comCmmFileService.getFileDetailList(fileSeq);
	        petListByInfo.put("getFileDetailList", getFileDetailList);
	        // model.addAttribute("getFileDetailList", getFileDetailList);
    	 }
    	 
    	 model.addAttribute("petListByList", petListByList);
    	
    	 return "/site/profile/petmanage.site";
    }
    @GetMapping(value = {"/profile/viewpetprofile.do"})
    public String viewpetprofile(
    		HttpServletRequest request
    		,Model model
    		,@RequestParam Map<String, Object> paramMap
    ) {
       
    	Map<String, Object> petInfo= sitepetService.petInfo(paramMap);
        model.addAttribute("petInfo",petInfo);
    	long fileSeq = Long.parseLong(EgovStringUtil.isNullToString(petInfo.get("file_seq"),"0"));
        List<JtFileDetail> getFileDetailList = comCmmFileService.getFileDetailList(fileSeq);
        model.addAttribute("getFileDetailList", getFileDetailList);
      
        return "/site/profile/viewpetprofile.site";
    }
    @GetMapping(value = {"/profile/petform.do"})
    public String petform(
    		HttpServletRequest request
    		,Model model
    		,@RequestParam Map<String, Object> paramMap
    ) {
    	log.debug("petform");
    	log.debug("paramMap : {}", paramMap);
    	
 
        
        return "/site/profile/petform.site";
    }
    @PostMapping(value = {"/profile/petprofile_save.do"})
    public String petprofile_save(  
    		HttpServletRequest request
    		,Model model
    		,@RequestParam Map<String, Object> paramMap
    		,List<MultipartFile> fileData
    ) throws IllegalStateException, IOException {
    	HttpSession session = request.getSession();
    	Map<String, Object> member = (Map<String, Object>) session.getAttribute("member");
        log.debug("paramMap : {}", paramMap);

        long paramFileSeq = Long.parseLong(EgovStringUtil.isNullToString(paramMap.getOrDefault("file_seq", "0"), "0"));
        log.debug("paramFileSeq : {}", paramFileSeq);
        
        //파일첨부
        long fileSeq = comCmmFileService.setFileUpload("/data/upload/edu2/post/", "POST", fileData, paramFileSeq);
        log.debug("fileSeq : {}", fileSeq);
        paramMap.put("file_seq", fileSeq);
        paramMap.put("user_id", member.get("user_id"));
        
        log.debug("paramMap : {}", paramMap);   
        
        //펫 등록 
        sitepetService.petInsert(paramMap);

        
        return "redirect:/profile/petmanage.do";
    }
}