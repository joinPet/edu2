package kr.co.jointree.edu2.site.main.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.com.cmm.paging.PaginationInfo;
import egovframework.com.cmm.paging.PagingAccess;
import kr.co.jointree.edu2.site.main.service.SiteMainService;


@Service("SiteMainService")
public class SiteMainServiceImpl implements SiteMainService {

    public static Logger log = LoggerFactory.getLogger(SiteMainServiceImpl.class);

    @Autowired
    private SiteMainDAO siteMainDAO;

    /**
     * 테스트 목록 정보 갯수
     * @param paramMap
     * @return
     */
    public int getTestCount(Map<String, Object> paramMap){
  		int selectData = siteMainDAO.getTestCount(paramMap);
  		return selectData;
  	}
    
    /**
     * 테스트 목록 정보 조회
     * @return
     */
    public List<Map<String, Object>> getTestList(Map<String, Object> paramMap) {
        List<Map<String, Object>> selectData = siteMainDAO.getTestList(paramMap);
        return selectData;
    }
    
    /**
     * 테스트 단건 정보 조회
     * @return
     */
    public Map<String, Object> getTestInfo(Map<String, Object> paramMap) {
        Map<String, Object> selectData = siteMainDAO.getTestInfo(paramMap);
        return selectData;
    }

    /**
     * 테스트 정보 등록
     * @return
     */
    public int setTestInsert(Map<String, Object> paramMap) {
    	int selectData = siteMainDAO.setTestInsert(paramMap);
        return selectData;
    }

    /**
     * 테스트 정보 수정
     * @return
     */
    public int setTestUpdate(Map<String, Object> paramMap) {
    	int selectData = siteMainDAO.setTestUpdate(paramMap);
        return selectData;
    }
    
    /**
     * 테스트 정보 삭제
     * @return
     */
    public int setTestDelete(Map<String, Object> paramMap) {
    	int selectData = siteMainDAO.setTestDelete(paramMap);
        return selectData;
    }
    
}
