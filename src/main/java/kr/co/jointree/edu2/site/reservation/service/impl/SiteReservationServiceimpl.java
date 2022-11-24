package kr.co.jointree.edu2.site.reservation.service.impl;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.jointree.edu2.site.profile.service.SitePetService;
import kr.co.jointree.edu2.site.profile.service.impl.SitePetDAO;
import kr.co.jointree.edu2.site.reservation.service.SiteReservationService;

@Service("SiteReservationService")
public class SiteReservationServiceimpl implements SiteReservationService {

	@Autowired
	private SiteReservationDAO sitereservationDAO;
	
	@Override
	public int resInsert(Map<String, Object> resInfo) {
		int insertData =sitereservationDAO.resInsert(resInfo);
		return insertData;
	}

	@Override
	public List<Map<String, Object>> resList(String user_id) {
		 List<Map<String, Object>> selectData = sitereservationDAO.resList(user_id);
		return selectData;
	}

	@Override
	public List<Map<String, Object>> sendList(String user_id) {
		List<Map<String, Object>> selectData = sitereservationDAO.sendList(user_id);
		return selectData;
	}

	
	
	
}
