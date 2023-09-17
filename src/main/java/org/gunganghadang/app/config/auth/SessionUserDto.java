package org.gunganghadang.app.config.auth;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.gunganghadang.domain.user.User;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Slf4j
@Getter
@Component
public class SessionUserDto implements Serializable {
    private Long loginId;

    public void setLoginId(Long loginId) {
        this.loginId = loginId;
    }
}
