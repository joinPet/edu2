package kr.co.jointree.edu2.site.sample2.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.com.cmm.paging.PaginationInfo;
import egovframework.com.cmm.paging.PagingAccess;
import kr.co.jointree.edu2.site.sample2.service.SiteSample2Service;

@Service("SiteSample2Service")
public class SiteSample2ServiceImpl implements SiteSample2Service {

    public static Logger log = LoggerFactory.getLogger(SiteSample2ServiceImpl.class);

    @Autowired
    private SiteSample2DAO siteSample2DAO;
    
    @Autowired
    private PagingAccess pagingAccess;
    
    /**
     * 목록 정보 조회
     * @return
     */
    public Map<String, Object> getSample2List(Map<String, Object> paramMap) {
    	Map<String, Object> selectData = new HashMap<>();
    	
    	int pageIndex = Integer.parseInt(paramMap.getOrDefault("pageIndex","1").toString());

    	//페이징 정보 START
    	int selectCnt = siteSample2DAO.getSample2Count(paramMap);
    	PaginationInfo paginationInfo = pagingAccess.getPagInfo(pageIndex, selectCnt);
    	paramMap.put("firstRecordIndex", paginationInfo.getFirstRecordIndex());
    	paramMap.put("recordCountPerPage", paginationInfo.getRecordCountPerPage());
    	selectData.put("paginationInfo", paginationInfo);
    			
    	List<Map<String, Object>> getSample2List = siteSample2DAO.getSample2List(paramMap);
    	selectData.put("getSample2List", getSample2List);
    	
        return selectData;
    }
    
    /**
     * 단건 정보 조회
     * @return
     */
    public Map<String, Object> getSample2Info(Map<String, Object> paramMap) {
    	Map<String, Object> selectData = new HashMap<>();
    	
        Map<String, Object> getSample2Info = siteSample2DAO.getSample2Info(paramMap);
        selectData.put("getSample2Info", getSample2Info);
        
        return selectData;
    }

    /**
     * 정보 등록
     * @return
     */
    public int setSample2Insert(Map<String, Object> paramMap) {
    	int selectData = siteSample2DAO.setSample2Insert(paramMap);
        return selectData;
    }

    /**
     * 정보 수정
     * @return
     */
    public int setSample2Update(Map<String, Object> paramMap) {
    	int selectData = siteSample2DAO.setSample2Update(paramMap);
        return selectData;
    }
    
    /**
     * 정보 삭제
     * @return
     */
    public int setSample2Delete(Map<String, Object> paramMap) {
    	int selectData = siteSample2DAO.setSample2Delete(paramMap);
        return selectData;
    }
    
}
