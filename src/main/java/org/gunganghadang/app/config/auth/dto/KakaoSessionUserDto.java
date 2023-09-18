package org.gunganghadang.app.config.auth.dto;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Slf4j
@Getter
@Component
public class KakaoSessionUserDto implements Serializable {
    private Long loginId;

    public void setLoginId(Long loginId) {
        this.loginId = loginId;
    }
}
