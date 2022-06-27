package com.example.order.domain.partner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PartnerServiceImpl implements PartnerService{

    @Override
    public PartnerInfo registerPartner(PartnerCommand command) {
        //1. command로 넘어온것을 initPartner로 변환
        //2. initPartner를 디비에 저장
        //3. Partner를 PartnerInfo로 변환후 리턴

        var initPartner=command.toEntity();
        //여기서 JPA를 쓰지 않는다.
        Partner partner=partnerStore.store(initPartner);

        return PartnerInfo.builder()
                .id(partner.getId())
                .partnerToken(partner.getPartnerToken())
                .partnerName(partner.getPartnerName())
                .businessNo(partner.getBusinessNo())
                .email(partner.getEmail())
                .status(partner.getStatus())
                .build();
    }

    @Override
    public PartnerInfo getPartnerInfo(String partnerToken) {
        return null;
    }

    @Override
    public PartnerInfo enablePartner(String partnerToken) {
        return null;
    }

    @Override
    public PartnerInfo disablePartner(String partnerToken) {
        return null;
    }
}
