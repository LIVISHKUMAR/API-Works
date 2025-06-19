package com.otpsystem.SmsSystem.Controller;

import com.otpsystem.SmsSystem.Service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;
@RequestMapping("/api/otp")
public class OtpController {
    @Autowired
    private SmsService smsService;

    @GetMapping("/send")
    public String sendOtp(@RequestParam String phone) {
        String otp = generateOtp();
        smsService.sendOtp(phone, otp);
        return "OTP sent to " + phone + ": " + otp;  // For testing; don't return OTP in real apps
    }

    private String generateOtp() {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);  // 6-digit OTP
        return String.valueOf(otp);
    }
}
