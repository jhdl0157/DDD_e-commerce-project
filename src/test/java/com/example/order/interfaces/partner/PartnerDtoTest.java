package com.example.order.interfaces.partner;

import com.example.order.domain.partner.Partner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PartnerDtoTest {
    @Test
    @DisplayName("Partner Command생성")
    public void partnerRequestToCommand(){
        PartnerDto.RegisterRequest par=new PartnerDto.RegisterRequest();
        par.setPartnerName("jaeho");
        par.setEmail("jhdl0157@naver.com");
        par.setBusinessNo("test");
        var testCommand=par.toCommand();
        assertThat(testCommand.getPartnerName()).isEqualTo("jaeho");
        assertThat(testCommand.getEmail()).isEqualTo("jhdl0157@naver.com");
        assertThat(testCommand.getBusinessNo()).isEqualTo("test");

    }

}