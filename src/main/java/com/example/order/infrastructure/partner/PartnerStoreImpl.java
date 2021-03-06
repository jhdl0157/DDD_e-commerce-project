package com.example.order.infrastructure.partner;

import com.example.order.common.exception.InvalidParamException;
import com.example.order.domain.partner.Partner;
import com.example.order.domain.partner.PartnerStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class PartnerStoreImpl implements PartnerStore {
    private final PartnerRepository partnerRepository;
    @Override
    public Partner store(Partner partner) {
        if (StringUtils.isBlank(partner.getPartnerToken())) throw new InvalidParamException("partner.getPartnerToken()");
        if (StringUtils.isBlank(partner.getPartnerName())) throw new InvalidParamException("partner.getPartnerName()");
        if (StringUtils.isBlank(partner.getBusinessNo())) throw new InvalidParamException("partner.getBusinessNo()");
        if (StringUtils.isBlank(partner.getEmail())) throw new InvalidParamException("partner.getEmail()");
        if (partner.getStatus() == null) throw new InvalidParamException("partner.getStatus()");

        return partnerRepository.save(partner);
    }
}
