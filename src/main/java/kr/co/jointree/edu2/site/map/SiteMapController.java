package kr.co.jointree.edu2.site.map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import egovframework.com.cmm.paging.PagingAccess;
import kr.co.jointree.edu2.site.main.service.SiteMainService;

@Controller
public class SiteMapController {

    public static Logger log = LoggerFactory.getLogger(SiteMapController.class);

    @Autowired
    SiteMainService siteMainService;
    
    @Autowired
    PagingAccess pagingAccess;

    @GetMapping(value = {"/map/mapHos.do"})
    public String mapHos() {
        return "/site/map/mapHos.site";
    }
    
    @GetMapping(value = {"/map/mapCafe.do"})
    public String mapCafe() {
        return "/site/map/mapCafe.site";
    }
}