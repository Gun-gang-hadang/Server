package org.gunganghadang.app.config.auth.dto;

import lombok.Builder;
import lombok.Getter;
import org.gunganghadang.domain.user.User;

import java.math.BigInteger;

@Getter
public class UserDto {
    private String loginId;
    private String nickname;

    @Builder
    public UserDto(String loginId, String nickname) {
        this.loginId = loginId;
        this.nickname = nickname;
    }

    public User toEntity() {
        return User.builder()
                .loginId(loginId)
                .nickname(nickname)
                .build();
    }

}
