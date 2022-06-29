package com.example.order.domain.partner;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class PartnerServiceImpl implements PartnerService{
private final PartnerStore partnerStore;
private final PartnerReader partnerReader;
    @Override
    @Transactional
    public PartnerInfo registerPartner(PartnerCommand command) {
        //1. command로 넘어온것을 initPartner로 변환
        //2. initPartner를 디비에 저장
        //3. Partner를 PartnerInfo로 변환후 리턴
        var initPartner=command.toEntity();
        //여기서 JPA를 쓰지 않는다.
        Partner partner= partnerStore.store(initPartner);
        return new PartnerInfo(partner);
    }

    @Override
    @Transactional(readOnly = true)
    public PartnerInfo getPartnerInfo(String partnerToken) {
        //1. Token -> Partner
        //2. Partner -> PartnerInfo
        Partner partner=partnerReader.getPartner(partnerToken);
        return new PartnerInfo(partner);
    }

    @Override
    @Transactional
    public PartnerInfo enablePartner(String partnerToken) {
        Partner partner=partnerReader.getPartner(partnerToken);
        partner.enable();
        return new PartnerInfo(partner);
    }

    @Override
    @Transactional
    public PartnerInfo disablePartner(String partnerToken) {
        Partner partner=partnerReader.getPartner(partnerToken);
        partner.enable();
        return new PartnerInfo(partner);
    }
}
