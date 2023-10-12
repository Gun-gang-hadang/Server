package org.gunganghadang.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.gunganghadang.app.dto.SessionUserDto;
import org.gunganghadang.app.dto.MySugarDetailsDto;
import org.gunganghadang.app.dto.MySugarListDto;
import org.gunganghadang.app.dto.MySugarSaveDto;
import org.gunganghadang.domain.mysugar.MySugar;
import org.gunganghadang.domain.mysugar.MySugarRepository;
import org.gunganghadang.domain.user.User;
import org.gunganghadang.domain.user.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class MySugarsService {
    private final MySugarRepository mySugarRepository;
    private final UserRepository userRepository;
    private final SessionUserDto sessionUserDto;

    @Transactional
    public Long save(MySugarSaveDto mySugarSaveDto) {
        String loginId = sessionUserDto.getLoginId();
        Optional<User> userOptional = userRepository.findByLoginId(loginId);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            String date = mySugarSaveDto.getDate();
            String time = mySugarSaveDto.getTime();

            if (mySugarRepository.existsMySugarByUserAndDateAndTime(user, date, time)) {
                log.info("중복된 글이 있습니다.");
                return -1L;
            }
            return mySugarRepository.save(mySugarSaveDto.toEntity(user)).getPost_id();
        }
        else {
            throw new IllegalArgumentException("사용자를 찾을 수 없습니다. login id: " + loginId);
        }
    }

    public MySugarDetailsDto findById (Long id) {
        MySugar entity = mySugarRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 글이 없습니다. id=" + id));
        return new MySugarDetailsDto(entity);
    }

    @Transactional(readOnly = true)
    public List<MySugarListDto> findAll() {
        String loginId = sessionUserDto.getLoginId();
        List<MySugar> mySugars = mySugarRepository.findAllByUserLoginIdOrderByDateDesc(loginId);
        return mySugars.stream()
                .map(MySugarListDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void deleteMysugar(Long id) {
        MySugar mySugar = mySugarRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        mySugarRepository.delete(mySugar);
    }
}
