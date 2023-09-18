package org.gunganghadang.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.gunganghadang.app.config.auth.dto.KakaoSessionUserDto;
import org.gunganghadang.app.config.auth.dto.KakaoUserDto;
import org.gunganghadang.domain.user.User;
import org.gunganghadang.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Slf4j
@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;
    private final KakaoSessionUserDto kakaoSessionUserDto;

    @PostMapping("/api/v1/login/kakao")
    public Long loadKakaoUser(@RequestBody KakaoUserDto kakaoUserDto) {
        try {
            User user = userService.loadUser(kakaoUserDto);
            Long loginId = user.getLoginId();
            log.info("로그인 후의 결과 값: {}", loginId);

            kakaoSessionUserDto.setLoginId(loginId);
            log.info("sessionUser 확인: {}", kakaoSessionUserDto.getLoginId());

            return loginId;
        } catch (Exception e) {
            throw new RuntimeException("User login failed");
        }
    }
}
