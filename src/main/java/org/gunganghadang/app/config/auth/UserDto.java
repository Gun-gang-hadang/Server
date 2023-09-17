package org.gunganghadang.app.config.auth;

import lombok.Builder;
import lombok.Getter;
import org.gunganghadang.domain.user.User;

@Getter
public class UserDto {
    private Long loginId;
    private String nickname;

    @Builder
    public UserDto(Long loginId, String nickname) {
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
