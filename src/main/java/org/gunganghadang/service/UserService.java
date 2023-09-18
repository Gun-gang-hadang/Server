package org.gunganghadang.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.gunganghadang.app.config.auth.dto.KakaoUserDto;
import org.gunganghadang.domain.user.User;
import org.gunganghadang.domain.user.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

   @Transactional
   public User loadUser(KakaoUserDto kakaoUserDto) {
       User user = saveOrUpdate(kakaoUserDto);
       log.info("KakaoSessionUserDto set in session: {}", user.getLoginId());
       return user;
   }

    private User saveOrUpdate(KakaoUserDto kakaoUserDto) {
        User user = userRepository.findByLoginId(kakaoUserDto.getLoginId())
                .map(entity -> entity.update(kakaoUserDto.getLoginId(), kakaoUserDto.getNickname()))
                .orElse(kakaoUserDto.toEntity());

        return userRepository.save(user);
    }
}
