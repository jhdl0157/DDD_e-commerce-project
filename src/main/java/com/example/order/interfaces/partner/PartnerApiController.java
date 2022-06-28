package com.example.order.interfaces.partner;


import com.example.order.application.PartnerFacade;
import com.example.order.common.response.CommonResponse;
import com.example.order.domain.partner.PartnerCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/partners")
public class PartnerApiController {
    private final PartnerFacade partnerFacade;
    public CommonResponse registerPartner(PartnerDto.RegisterRequest registerRequest){
        // 1. 외부에서 전달된 파라미터(dto) -> command, Criteria convert
        // 2. facade 호출
        // 3. PartenerInfo -> CommonResponse convert return
          var command= registerRequest.toCommand();
          var partnerInfo=partnerFacade.registerPartner(command);
          var response=new PartnerDto.RegisterResponse(partnerInfo);
          return CommonResponse.success(response);
    }
}
