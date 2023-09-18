package org.gunganghadang.app.config.auth.dto;

import lombok.Builder;
import lombok.Getter;
import org.gunganghadang.domain.user.User;

@Getter
public class KakaoUserDto {
    private Long loginId;
    private String nickname;

    @Builder
    public KakaoUserDto(Long loginId, String nickname) {
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
