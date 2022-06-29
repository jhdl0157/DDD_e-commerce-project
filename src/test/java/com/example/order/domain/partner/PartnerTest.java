package com.example.order.domain.partner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


class PartnerTest {

    @Test
    @DisplayName("파트너 생성 성공")
    public void Partner() {
            Partner partner=Partner.builder()
                .partnerName("jaeho")
                .email("jhdl0157@naver.com")
                .businessNo("test")
                        .build();

        assertThat(partner.getPartnerName()).isEqualTo("jaeho");
        assertThat(partner.getEmail()).isEqualTo("jhdl0157@naver.com");
        assertThat(partner.getBusinessNo()).isEqualTo("test");
        assertThat(partner.getStatus()).isEqualTo(Partner.Status.ENABLE);
    }


}