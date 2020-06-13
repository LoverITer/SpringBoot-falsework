package top.easyblog.common.email;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author huangxin
 */
@Slf4j
@Component
public class EmailSender {


    @Resource
    private JavaMailSender mailSender;

    public boolean send(Email email) {
        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setSubject(email.getSubject());
            simpleMailMessage.setFrom(email.getSendForm());
            simpleMailMessage.setTo(email.getSendTo());
            simpleMailMessage.setText(email.getSendText());
            mailSender.send(simpleMailMessage);
            return true;
        }catch (Exception e){
            log.error("邮件发送失败,Exception info:"+e.getMessage());
        }
        return false;
    }

}
