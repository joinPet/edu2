package kr.co.jointree.edu2.site.sample1.web;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
import kr.co.jointree.edu2.site.sample1.service.SiteSample1Service;

@Controller
public class SiteSample1Controller {

    public static Logger log = LoggerFactory.getLogger(SiteSample1Controller.class);

    @Autowired
    SiteSample1Service siteSample1Service;
    
    @Autowired
    ComCmmFileService comCmmFileService;
    
    
    @Autowired
    PagingAccess pagingAccess;
    
    /**
     * 리스트 화면
     * @param request
     * @param model
     * @return
     */
    @GetMapping(value = {"/sample1/list.do"})
    public String siteList(
    		HttpServletRequest request
    		,Model model
    		,@RequestParam Map<String, Object> paramMap
    ) {
        log.debug("siteList");
        log.debug("paramMap : {}", paramMap);
        
        int pageIndex = Integer.parseInt(paramMap.getOrDefault("pageIndex","1").toString());
    	
    	//페이징 정보 START
        int selectCnt = siteSample1Service.getSample1Count(paramMap);
        PaginationInfo paginationInfo = pagingAccess.getPagInfo(pageIndex, selectCnt);
        paramMap.put("firstRecordIndex", paginationInfo.getFirstRecordIndex());
        paramMap.put("recordCountPerPage", paginationInfo.getRecordCountPerPage());
        model.addAttribute("paginationInfo", paginationInfo);
                
        List<Map<String, Object>> getSample1List = siteSample1Service.getSample1List(paramMap);
        model.addAttribute("getSample1List", getSample1List);
        
        model.addAttribute("paramMap", paramMap);
        
        return "/site/sample1/list.site";
    }
    
    /**
     * 뷰 화면
     * @param request
     * @param model
     * @return
     * @throws  
     */
    @GetMapping(value = {"/sample1/view.do"})
    public String siteView(
    		HttpServletRequest request
    		,Model model
    		,@RequestParam Map<String, Object> paramMap
    ) {
        log.debug("siteView");
        log.debug("paramMap : {}", paramMap);
        
        Map<String, Object> getSample1Info = siteSample1Service.getSample1Info(paramMap);
        model.addAttribute("getSample1Info", getSample1Info);
        
        long fileSeq = Long.parseLong(EgovStringUtil.isNullToString(getSample1Info.get("file_seq"), "0"));
        List<JtFileDetail> getFileDetailList = comCmmFileService.getFileDetailList(fileSeq);
        model.addAttribute("getFileDetailList", getFileDetailList);
        
        return "/site/sample1/view.site";
    }
    
    /**
     * 등록/수정 화면
     * @param request
     * @param model
     * @return
     */
    @GetMapping(value = {"/sample1/form.do"})
    public String siteForm(
    		HttpServletRequest request
    		,Model model
    		,@RequestParam Map<String, Object> paramMap
    ) {
        log.debug("siteForm");
        log.debug("paramMap : {}", paramMap);
        
        if(!paramMap.getOrDefault("post_seq", "").equals("")) {
        	Map<String, Object> getSample1Info = siteSample1Service.getSample1Info(paramMap);
            model.addAttribute("getSample1Info", getSample1Info);
            
            long fileSeq = Long.parseLong(EgovStringUtil.isNullToString(getSample1Info.get("file_seq"), "0"));
            List<JtFileDetail> getFileDetailList = comCmmFileService.getFileDetailList(fileSeq);
            model.addAttribute("getFileDetailList", getFileDetailList);
        }
        
        return "/site/sample1/form.site";
    }
    
    /**
     * 등록/수정 하기
     * @param request
     * @param model
     * @return
     * @throws IOException 
     * @throws IllegalStateException 
     */
    @PostMapping(value = {"/sample1/form-save.do"})
    public String siteFormSave(
    		HttpServletRequest request
    		,Model model
    		,@RequestParam Map<String, Object> paramMap
    		,List<MultipartFile> fileData
    ) throws IllegalStateException, IOException {
        log.debug("siteForm");
        log.debug("paramMap : {}", paramMap);

        paramMap.put("param_date", LocalDateTime.now());
        paramMap.put("param_ip", EgovClntInfo.getClntIP(request));
        paramMap.put("param_id", "jointree");
        
        long paramFileSeq = Long.parseLong(EgovStringUtil.isNullToString(paramMap.getOrDefault("file_seq", "0"), "0"));
        log.debug("paramFileSeq : {}", paramFileSeq);
        
        //파일첨부
        long fileSeq = comCmmFileService.setFileUpload("/data/upload/edu2/post/", "POST", fileData, paramFileSeq);
        log.debug("fileSeq : {}", fileSeq);
        paramMap.put("file_seq", fileSeq);
        
        log.debug("paramMap : {}", paramMap);
        
        if(paramMap.getOrDefault("post_seq", "").equals("")) {
        //등록
        	siteSample1Service.setSample1Insert(paramMap);
        } else {
        //수정
        	siteSample1Service.setSample1Update(paramMap);
        }
        
        return "redirect:/sample1/list.do";
    }
    
    /**
     * 삭제 하기
     * @param request
     * @param model
     * @return
     */
    @PostMapping(value = {"/sample1/form-delete.do"})
    public String siteFormDelete(
    		HttpServletRequest request
    		,Model model
    		,@RequestParam Map<String, Object> paramMap
    ) {
        log.debug("siteForm");
        log.debug("paramMap : {}", paramMap);

        paramMap.put("param_date", LocalDateTime.now());
        paramMap.put("param_ip", EgovClntInfo.getClntIP(request));
        paramMap.put("param_id", "jointree");
        
        siteSample1Service.setSample1Delete(paramMap);	
        
        return "redirect:/sample1/list.do";
    }
    
}
