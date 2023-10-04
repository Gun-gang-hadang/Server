package org.gunganghadang.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.gunganghadang.app.dto.UserDto;
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
   public User loadUser(UserDto userDto) {
       User user = saveOrUpdate(userDto);
       log.info("SessionUserDto set in session: {}", user.getLoginId());
       return user;
   }

    private User saveOrUpdate(UserDto userDto) {
        User user = userRepository.findByLoginId(userDto.getLoginId())
                .map(entity -> entity.update(userDto.getLoginId(), userDto.getNickname()))
                .orElse(userDto.toEntity());

        return userRepository.save(user);
    }
}
