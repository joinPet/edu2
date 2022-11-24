package kr.co.jointree.edu2.site.sample2.service;

import java.util.Map;

public interface SiteSample2Service {

    //목록 정보 조회
	Map<String, Object> getSample2List(Map<String, Object> paramMap);
	
	//단건 정보 조회
	Map<String, Object> getSample2Info(Map<String, Object> paramMap);
	
	//정보 등록
	int setSample2Insert(Map<String, Object> paramMap);
	
	//정보 수정
	int setSample2Update(Map<String, Object> paramMap);
	
	//정보 삭제
	int setSample2Delete(Map<String, Object> paramMap);
}
