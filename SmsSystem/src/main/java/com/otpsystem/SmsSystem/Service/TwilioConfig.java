package com.otpsystem.SmsSystem.Service;

import com.twilio.Twilio;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
@Configurable
public class TwilioConfig {
    @Value("${twilio.account.sid}")
    private String accountSid;

    @Value("${twilio.auth.token}")
    private String authToken;

    @PostConstruct
    public void init() {
        Twilio.init(accountSid, authToken);
    }
}
