package egovframework.com.cmm.web;

import java.io.IOException;
import java.time.LocalDateTime;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import egovframework.com.cmm.model.JtFileDetail;
import egovframework.com.cmm.response.ResponseCode;
import egovframework.com.cmm.response.ResponseModel;
import egovframework.com.cmm.service.ComCmmFileService;
import egovframework.com.cmm.util.EgovClntInfo;

@Controller
@RequestMapping(value = {"/egovframework/com/cmm"})
public class ComCmmFileController {

    public static Logger log = LoggerFactory.getLogger(ComCmmFileController.class);

    @Autowired
    ComCmmFileService comCmmFileService;
    
    /**
     * 저장 하기
     * @param pageIndex
     * @param searchKeyword
     * @param searchKey
     * @return
     * @throws IOException 
     */
    @ResponseBody
    @PostMapping(value = {"/api-file-delete"})
    public ResponseEntity<ResponseModel> setSample2Delete(
    		HttpServletRequest request
            , @RequestParam(value = "seq", required = false, defaultValue = "0") long seq
            , @RequestParam(value = "no", required = false, defaultValue = "0") long no
    ) throws IOException{
        
    	JtFileDetail jtFileDetail = new JtFileDetail();
    	jtFileDetail.setFileSeq(seq);
    	jtFileDetail.setFileDetailNo(no);
    	
    	comCmmFileService.setFileDelete(jtFileDetail);

        return ResponseEntity
                .status(ResponseCode.OK.getStatus().value())
                .body(new ResponseModel(ResponseCode.OK, null));
    }

}
