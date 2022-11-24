package kr.co.jointree.edu2.site.profile.service.impl;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.jointree.edu2.site.profile.service.SitePetService;

@Service("SitePetService")
public class SitePetServiceimpl implements SitePetService {
	
	@Autowired
	private SitePetDAO sitepetDAO;
	
	@Override
	public int petInsert(Map<String, Object> pet) {
		int insertData =sitepetDAO.petInsert(pet);
		return insertData;
	}

	@Override
	public List<Map<String, Object>> petListByID(String user_id) {
		 List<Map<String, Object>> selectData = sitepetDAO.petListByID(user_id);
		return selectData;
	}

	@Override
	public List<Map<String, Object>> petListAll() {
		 List<Map<String, Object>> selectData = sitepetDAO.petListAll();
		return selectData;
	}

	@Override
	public Map<String, Object> petInfo(Map<String, Object> pet_id) {
		Map<String, Object> selectData = sitepetDAO.petInfo(pet_id);
		return selectData;
	}

}
