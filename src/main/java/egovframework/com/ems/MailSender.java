package egovframework.com.ems;

import egovframework.com.cmm.util.EgovProperties;
import egovframework.com.ems.util.MailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

public class MailSender {

	@Autowired
    private JavaMailSenderImpl userMailSender;

    //인증메일 보내기
    public int sendMail(String email, String subject, String text) throws UnsupportedEncodingException {
    	int result = 0;

        //6자리 난수 인증번호 생성
        //String authKey = getKey(6);
    	String authKey = "";
    	String sender = EgovProperties.getProperty("Globals.email.Sender");
        String senderName = new String(EgovProperties.getProperty("Globals.email.Sendername").getBytes("ISO-8859-1"), "EUC-KR");

        //인증메일 보내기
        try {
            MailUtil sendMail = new MailUtil(userMailSender);
            sendMail.setSubject(subject);
            sendMail.setText(text);
            sendMail.setFrom(sender, senderName);
            sendMail.setTo(email);
            sendMail.send();

            result = 0;
        } catch (MessagingException e) {
            e.printStackTrace();
            result = 1;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            result = 1;
        }

          return result;
    }

}
