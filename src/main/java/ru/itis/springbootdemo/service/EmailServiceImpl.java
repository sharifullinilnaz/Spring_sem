package ru.itis.springbootdemo.service;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import ru.itis.springbootdemo.models.User;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmailServiceImpl implements EmailService {

        @Autowired
        private JavaMailSender javaMailSender;

        @Autowired
        private Configuration freemarkerConfig;

        @Value("${spring.mail.username}")
        private String userName;

        @Override
        public void sendMail(String subject, User user, String email) {
            try {
                Template template = freemarkerConfig.getTemplate("mail.ftl");
                Map data = new HashMap();
                data.put("username", user.getName());
                data.put("confirm", user.getConfirmCode());
                String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, data);
                MimeMessagePreparator messagePreparator = mimeMessage -> {
                    MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
                    messageHelper.setFrom(userName);
                    messageHelper.setTo(email);
                    messageHelper.setSubject(subject);
                    messageHelper.setText(html, true);
                };

                javaMailSender.send(messagePreparator);
            } catch (Exception e) {
                System.out.println("Error with mail");
                e.printStackTrace();
            }
        }

}