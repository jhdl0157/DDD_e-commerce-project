package com.example.order.domain.partner;

public interface PartnerService {
    //TODO Command CUD  Criteria R
    //TODO Info Entity를 외부로 보낼때 담을 객체
    PartnerInfo registerPartner(PartnerCommand command);
    PartnerInfo getPartnerInfo(String partnerToken);
    PartnerInfo enablePartner(String partnerToken);
    PartnerInfo disablePartner(String partnerToken);
}
