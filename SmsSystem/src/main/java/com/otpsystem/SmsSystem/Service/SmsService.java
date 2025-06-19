package com.otpsystem.SmsSystem.Service;

import com.twilio.type.PhoneNumber;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

@Service
public class SmsService {
    // Your Twilio phone number from application.properties
    @Value("${twilio.phone.number}")
    private String twilioPhoneNumber;

    public void sendOtp(String toPhoneNumber, String otp) {
        String messageBody = "Your OTP is: " + otp;

        Message.creator(
                new PhoneNumber(toPhoneNumber),       // Who gets the message
                new PhoneNumber(twilioPhoneNumber),   // Your Twilio number
                messageBody                           // Message content
        ).create();
    }
}
