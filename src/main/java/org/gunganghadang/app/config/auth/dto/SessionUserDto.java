package org.gunganghadang.app.config.auth.dto;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.math.BigInteger;

@Slf4j
@Getter
@Component
public class SessionUserDto implements Serializable {
    private String loginId;

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }
}
