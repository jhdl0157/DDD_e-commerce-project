package com.example.order.domain.partner;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Builder
@Getter
public class PartnerInfo {
    private final Long id;
    private final String partnerToken;
    private final String partnerName;
    private final String businessNo;
    private final String email;
    private final Partner.Status status;
}
