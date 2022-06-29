package com.example.order.infrastructure;

import com.example.order.domain.notification.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class NotificationExecutor implements NotificationService {
    @Override
    public void sendEmail(String email, String title, String description) {
        log.info("이메일 전송");
    }

    @Override
    public void sendKakao(String phoneNo, String description) {
        log.info("카카오톡 전송");
    }

    @Override
    public void sendSms(String phoneNo, String description) {
        log.info("문자 전송");

    }
}
