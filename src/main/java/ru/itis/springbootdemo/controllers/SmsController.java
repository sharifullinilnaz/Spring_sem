package ru.itis.springbootdemo.controllers;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import ru.itis.springbootdemo.security.UserDetailsImpl;

@Controller
public class SmsController {

    @GetMapping("/sms")
    public String getSmsPage() {
        return "sms";
    }

    @RequestMapping(path = "/sms/send", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public void sendSms(@RequestParam("phone") String phone, Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth("89172610217ilnaz2000@mail.ru", "2ucysqqeD9U1tJwpq2rqHZGWUKCv");
        String resourceUrl =
                "https://@gate.smsaero.ru/v2/sms/send?number=" + phone + "&text=" + userDetails.getUser().getRole() + "&sign=SMS Aero&channel=DIRECT";
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(resourceUrl, HttpMethod.GET, entity, String.class);
        System.out.println(response.getBody());
    }
}