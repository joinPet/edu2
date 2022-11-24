package kr.co.jointree.edu2.site.sample2.web;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import egovframework.com.cmm.paging.PagingAccess;
import egovframework.com.cmm.response.ResponseCode;
import egovframework.com.cmm.response.ResponseModel;
import egovframework.com.cmm.util.EgovClntInfo;
import kr.co.jointree.edu2.site.sample2.service.SiteSample2Service;

@Controller
public class SiteSample2Controller {
	
    public static Logger log = LoggerFactory.getLogger(SiteSample2Controller.class);
    
    @Autowired
    SiteSample2Service siteSample2Service;
    
    @Autowired
    PagingAccess pagingAccess;
    
    /**
     * 리스트 화면
     * @param request
     * @param model
     * @return
     */
    @GetMapping(value = {"/sample2/list.do"})
    public String siteList(
    		HttpServletRequest request
    		,Model model
    		,@RequestParam Map<String, Object> paramMap
    ) {

        model.addAttribute("paramMap", paramMap);
        
        return "/site/sample2/list.site";
    }
    
    /**
     * 뷰 화면
     * @param request
     * @param model
     * @return
     */
    @GetMapping(value = {"/sample2/view.do"})
    public String siteView(
    		HttpServletRequest request
    		,Model model
    		,@RequestParam Map<String, Object> paramMap
    ) {

        model.addAttribute("paramMap", paramMap);
        
        return "/site/sample2/view.site";
    }
    
    /**
     * 등록/수정 화면
     * @param request
     * @param model
     * @return
     */
    @GetMapping(value = {"/sample2/form.do"})
    public String siteForm(
    		HttpServletRequest request
    		,Model model
    		,@RequestParam Map<String, Object> paramMap
    ) {

        model.addAttribute("paramMap", paramMap);
        
        return "/site/sample2/form.site";
    }
    
    /**
     * 목록 정보 조회
     * @param pageIndex
     * @param searchKeyword
     * @param searchKey
     * @return
     */
    @ResponseBody
    @GetMapping(value = {"/sample2/api-sample-list"})
    public ResponseEntity<ResponseModel> getSample2List(
             @RequestParam(value = "pageIndex", required = false, defaultValue = "0") long pageIndex
            ,@RequestParam(value = "searchKeyword", required = false, defaultValue = "") String searchKeyword
            ,@RequestParam(value = "searchKey", required = false, defaultValue = "") String searchKey
    ){
    	
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("pageIndex", pageIndex);
        paramMap.put("searchKeyword", searchKeyword);
        paramMap.put("searchKey", searchKey);

        //단건 정보 조회
        Map<String, Object> selectData = siteSample2Service.getSample2List(paramMap);

        return ResponseEntity
                .status(ResponseCode.OK.getStatus().value())
                .body(new ResponseModel(ResponseCode.OK, selectData));
    }
    
    /**
     * 정보 조회
     * @param seq
     * @return
     */
    @ResponseBody
    @GetMapping(value = {"/sample2/api-sample-info"})
    public ResponseEntity<ResponseModel> getSample2List(
             @RequestParam(value = "post_seq", required = false, defaultValue = "0") long seq
    ){
    	
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("post_seq", seq);

        //단건 정보 조회
        Map<String, Object> selectData = siteSample2Service.getSample2Info(paramMap);

        return ResponseEntity
                .status(ResponseCode.OK.getStatus().value())
                .body(new ResponseModel(ResponseCode.OK, selectData));
    }
    
    /**
     * 저장 하기
     * @param pageIndex
     * @param searchKeyword
     * @param searchKey
     * @return
     */
    @ResponseBody
    @PostMapping(value = {"/sample2/api-sample-save"})
    public ResponseEntity<ResponseModel> setSample2Save(
    		HttpServletRequest request
    		,@RequestParam Map<String, Object> paramMap
    ){

        paramMap.put("param_date", LocalDateTime.now());
        paramMap.put("param_ip", EgovClntInfo.getClntIP(request));
        paramMap.put("param_id", "jointree");
        
        if(paramMap.getOrDefault("post_seq", "").equals("")) {
        //등록
        	siteSample2Service.setSample2Insert(paramMap);	
        }else {
        //수정
        	siteSample2Service.setSample2Update(paramMap);
        }

        return ResponseEntity
                .status(ResponseCode.OK.getStatus().value())
                .body(new ResponseModel(ResponseCode.OK, null));
    }
    
    /**
     * 저장 하기
     * @param pageIndex
     * @param searchKeyword
     * @param searchKey
     * @return
     */
    @ResponseBody
    @PostMapping(value = {"/sample2/api-sample-delete"})
    public ResponseEntity<ResponseModel> setSample2Delete(
    		HttpServletRequest request
    		,@RequestParam Map<String, Object> paramMap
    ){

        paramMap.put("param_date", LocalDateTime.now());
        paramMap.put("param_ip", EgovClntInfo.getClntIP(request));
        paramMap.put("param_id", "jointree");
        
        siteSample2Service.setSample2Delete(paramMap);	

        return ResponseEntity
                .status(ResponseCode.OK.getStatus().value())
                .body(new ResponseModel(ResponseCode.OK, null));
    }
    
}
