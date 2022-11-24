package egovframework.com.cmm.web;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = {"/egovframework/com/cmm"})
public class ComCmmController {

    public static Logger log = LoggerFactory.getLogger(ComCmmController.class);

    /**
     * 접근권한이 없을경우
     */
    @GetMapping(value = "/access.do")
    public String access(
            HttpServletRequest request
            , Model model
            , @RequestParam(value = "act", required = false, defaultValue = "popup") String act
            , @RequestParam(value = "seq", required = false, defaultValue = "0") long seq

    ){
        String siteId = "jtsm";
        request.setAttribute("siteId", siteId);

        String moveJsp = "/egovframework/com/cmm/access.jtsmnotiles";
        return moveJsp;
    }

}
