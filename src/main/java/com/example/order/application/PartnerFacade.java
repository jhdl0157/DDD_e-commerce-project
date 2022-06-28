package com.example.order.application;

import com.example.order.domain.notification.NotificationService;
import com.example.order.domain.partner.PartnerCommand;
import com.example.order.domain.partner.PartnerInfo;
import com.example.order.domain.partner.PartnerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PartnerFacade {
    private final PartnerService partnerService;
    private final NotificationService notificationService;
    //Todo 도메인 레이어와 그외 다른 서비스를 합쳐서 하나의 서비스로 만든다
    public PartnerInfo registerPartner(PartnerCommand command){
        // 1. partnerservice regist
        // 2. email
        var partnerInfo=partnerService.registerPartner(command);
        notificationService.sendEmail(partnerInfo.getEmail(),
                partnerInfo.getPartnerName()+"님 환영합니다.",
                "설명");
        return partnerInfo;
    }
}
