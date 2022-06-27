package com.example.order.domain.partner;


import com.example.order.common.util.TokenGenerator;
import com.example.order.domain.AbstractEntity;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;


import javax.persistence.*;

@Entity
@Getter
//TODO: Setter 사용 금지하기!!
@Slf4j
@NoArgsConstructor
@Table(name="Partners")
public class Partner extends AbstractEntity {
    private static final String PREFIX_PARTNER="ptr_";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String partnerToken;
    private String partnerName;
    private String businessNo;
    private String email;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Builder
    public Partner(String partnerName, String businessNo, String email) {
        if(StringUtils.isEmpty(partnerName)) throw new RuntimeException("empty partnerName ");
        if(StringUtils.isEmpty(businessNo)) throw new RuntimeException("empty businessNo");
        if(StringUtils.isEmpty(email)) throw new RuntimeException("empty email");
        this.partnerName = partnerName;
        this.businessNo = businessNo;
        this.email = email;
        this.status=Status.ENABLE;
        this.partnerToken= TokenGenerator.randomCharacterWithPrefix(PREFIX_PARTNER);
    }

    @Getter
    @RequiredArgsConstructor
    public enum Status{
        ENABLE("활성화"),DISABLE("비활성화");
        private final String description;
    }
    public void enable(){
        this.status=Status.ENABLE;
    }
    public void disable(){
        this.status=Status.DISABLE;
    }
}
