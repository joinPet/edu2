package egovframework.com.ems.util;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.activation.DataSource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

public class MailUtil {
    private JavaMailSender userMailSender;
    private MimeMessage message;
    private MimeMessageHelper messageHelper;

    public MailUtil(JavaMailSender mailSender) throws MessagingException {
        this.userMailSender = mailSender;
        message = this.userMailSender.createMimeMessage();
        messageHelper = new MimeMessageHelper(message, true, "UTF-8");
    }

    public void setSubject(String subject) throws MessagingException {
        messageHelper.setSubject(subject);
    }

    public void setText(String htmlContent) throws MessagingException {
        messageHelper.setText(htmlContent, true);
    }

    public void setFrom(String email, String name) throws UnsupportedEncodingException, MessagingException {
        messageHelper.setFrom(email, name);
    }

    public void setTo(String email) throws MessagingException {
        messageHelper.setTo(email);
    }

    public void addInline(String contentId, DataSource dataSource) throws MessagingException {
        messageHelper.addInline(contentId, dataSource);
    }

    public void send() {
    	userMailSender.send(message);
    }
}
