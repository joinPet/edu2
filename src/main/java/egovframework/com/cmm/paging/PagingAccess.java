package egovframework.com.cmm.paging;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @PagingAccess
 * 페이징 처리를 담당한다.
 * PaginationInfo 클래스에 갱신하기위해
 * 페이지 처리를 원하는 페이지의 현재 페이지 번호와 전체 데이터 개수를 조회하는 쿼리문을 파라미터 값으로 받는다.
 * @author
 * @version 1.0
 * @since 2014-11-14
 */
@Service
public class PagingAccess{

	@Value("${Configs.site.Page.Unit}")
	private int sitePageUnit;

	@Value("${Configs.site.Page.Size}")
	private int sitePageSize;
	
	@Value("${Configs.cms.Page.Unit}")
	private int cmsPageUnit;

	@Value("${Configs.cms.Page.Size}")
	private int cmsPageSize;
	
	/**
	 * 페이지 계산 처리 (파라미터 사용 및 pageunit,pagesize 처리)
	 * @throws Exception
	 */
	public PaginationInfo getPagInfo(Integer pageIndex, Integer cnt, Integer PageUnit, Integer PageSize) {
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(pageIndex);
		paginationInfo.setRecordCountPerPage(PageUnit);
		paginationInfo.setPageSize(PageSize);
		paginationInfo.setTotalRecordCount(cnt);
		return paginationInfo;
	}
	
	/**
	 * 페이지 계산 처리 (파라미터 사용 및 pageunit,pagesize 처리)
	 * @throws Exception
	 */
	public PaginationInfo getPagInfo(Integer pageIndex, Integer cnt) {

		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(pageIndex);
		paginationInfo.setRecordCountPerPage(sitePageUnit);
		paginationInfo.setPageSize(sitePageSize);
		paginationInfo.setTotalRecordCount(cnt);
		return paginationInfo;
	}

	/**
	 * 페이지 계산 처리 (파라미터 사용 및 pageunit,pagesize 처리)
	 * @throws Exception
	 */
	public PaginationInfo getPagInfoCms(Integer pageIndex, Integer cnt) {

		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(pageIndex);
		paginationInfo.setRecordCountPerPage(cmsPageUnit);
		paginationInfo.setPageSize(cmsPageSize);
		paginationInfo.setTotalRecordCount(cnt);
		return paginationInfo;
	}
	
}
