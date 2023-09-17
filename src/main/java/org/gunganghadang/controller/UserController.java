package org.gunganghadang.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.gunganghadang.app.config.auth.SessionUserDto;
import org.gunganghadang.app.config.auth.UserDto;
import org.gunganghadang.domain.user.User;
import org.gunganghadang.service.UserService;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;
    private final SessionUserDto sessionUserDto;

    @PostMapping("/api/v1/login")
    public Long loadUser(@RequestBody UserDto userDto) {
        try {
            User user = userService.loadUser(userDto);
            Long loginId = user.getLoginId();
            log.info("로그인 후의 결과 값: {}", loginId);

            sessionUserDto.setLoginId(loginId);
            log.info("sessionUser 확인: {}", sessionUserDto.getLoginId());

            return loginId;
        } catch (Exception e) {
            throw new RuntimeException("User login failed");
        }
    }
}
