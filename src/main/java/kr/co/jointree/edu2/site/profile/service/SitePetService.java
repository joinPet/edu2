package kr.co.jointree.edu2.site.profile.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;


public interface SitePetService {
	// 펫 등록
		public int petInsert(Map<String, Object> pet);
	
	// 아디이에 따른 pet 정보 리스트
		public List<Map<String, Object>> petListByID(String user_id);
		
	// 모든 pet 정보 리스트
		public List<Map<String, Object>> petListAll();
		
    //Pet 아이디에 따른 pet 정보 가져오기
		public Map<String, Object> petInfo(Map<String, Object> pet_id);
}