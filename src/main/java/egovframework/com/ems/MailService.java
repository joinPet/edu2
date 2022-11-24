package egovframework.com.ems;

import egovframework.com.cmm.crypt.EgovFileScrty;
import egovframework.com.cmm.util.EgovStringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.Random;


@Service("mss")
public class MailService {

	@Autowired
	private MailSender mailSender;

	public String getAuthCode(int size) {
        Random random = new Random();
        StringBuffer buffer = new StringBuffer();
        int num = 0;

        while(buffer.length() < size) {
            num = random.nextInt(10);
            buffer.append(num);
        }

        return buffer.toString();
    }

	public String sendMailAuthCode(String email) throws UnsupportedEncodingException {
		String subject = "[ESS발전 운영정보 서비스 OPEN API] 이메일 인증번호";
		String text = "";

		String auth = getAuthCode(6);

		text = new StringBuffer().append("<h3>[이메일 인증]</h3>")
	            .append("<p>다음 인증번호 6자리를 입력하여 인증을 완료해주십시오.</p>")
	            .append("<h4>" + auth + "</h4>")
	            .toString();

		int send = mailSender.sendMail(email, subject, text);

		return auth;
	}

	public String sendMailAuthCode02(String email) throws UnsupportedEncodingException {
		String subject = "[ESS발전 운영정보 서비스 OPEN API] 이메일 인증번호";
		String text = "";

		String auth = getAuthCode(6);

		text = new StringBuffer().append("<h3>[이메일 인증]</h3>")
	            .append("<p>다음 인증번호 6자리를 입력하십시오.</p>")
	            .append("<h4>" + auth + "</h4>")
	            .toString();

		int send = mailSender.sendMail(email, subject, text);


		return auth;
	}

	public boolean authentication(HttpSession session, String email, int authNum) {

		int auth = Integer.parseInt(session.getAttribute(email).toString());

		if(auth == authNum) {
			return true;
		}else {
			return false;
		}
	}

	@Async
	public String sendMailPwReset(String email, String usrId, String usrSe) throws Exception {
		String subject = "[ESS발전 운영정보 서비스 OPEN API] 임시 비밀번호 발급 안내";
		String text = "";
		LocalDate now = LocalDate.now();
		String rstPw = usrId.trim() + now.toString();

		String pass = EgovFileScrty.encryptPassword(rstPw, EgovStringUtil.isNullToString(usrId)).substring(0, 6);
		String pass2 = EgovFileScrty.encryptPassword(pass, EgovStringUtil.isNullToString(usrId));

		text = new StringBuffer().append("<h3>[임시 비밀번호 발급 안내]</h3>")
	            .append("<p>회원님께서 요청하신 비밀번호 찾기에 따른 자동안내 메일입니다.</p>")
	            .append("<p>안녕하세요. 고객님의 임시 비밀번호를 알려드립니다.<br> 임시 비밀번호로 로그인 하신 후 비밀번호를 수정하여 서비스를 이용하시기 바랍니다. <br>감사합니다.</p>")
	            .append("<h4>임시 비밀번호 :")
	            .append(pass)
	            .append("</h4>")
	            .toString();

		int send = mailSender.sendMail(email, subject, text);

		return pass2;
	}

	public int sendMAilPasswordReset(String email, String usrId) throws UnsupportedEncodingException {
		String subject = "[ESS발전 운영정보 서비스 OPEN API] 비밀번호 초기화";
		String text = "";

		text = new StringBuffer().append("<h3>[비밀번호 초기화]</h3>")
	            .append("<p>비밀번호 초기화 자동안내 메일입니다.</p>")
	            .append("<p>안녕하세요. 고객님의 초기화된 비밀번호를 알려드립니다.<br> 초기화된 비밀번호로 로그인 하신 후 비밀번호를 수정하여 서비스를 이용하시기 바랍니다. <br>감사합니다.</p>")
	            .append("<h4>초기화 된 비밀번호는 아이디와 동일한")
	            .append(usrId + "입니다.")
	            .append("</h4>")
	            .toString();

		int send = mailSender.sendMail(email, subject, text);

		return send;
	}


}
