package org.gunganghadang.app.dto;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.io.Serializable;
import java.math.BigInteger;

@Slf4j
@Getter
@Component
@SessionScope
public class SessionUserDto implements Serializable {
    private String loginId;

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }
}
