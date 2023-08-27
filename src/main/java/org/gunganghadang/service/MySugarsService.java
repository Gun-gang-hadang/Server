package org.gunganghadang.service;

import lombok.RequiredArgsConstructor;
import org.gunganghadang.app.dto.MySugarDetailsDto;
import org.gunganghadang.app.dto.MySugarSaveDto;
import org.gunganghadang.domain.mysugar.MySugar;
import org.gunganghadang.domain.mysugar.MySugarRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class MySugarsService {
    private final MySugarRepository mySugarRepository;

    @Transactional
    public Long save(MySugarSaveDto mySugarSaveDto) {
        return mySugarRepository.save(mySugarSaveDto.toEntity()).getId();
    }

    public MySugarDetailsDto findById (Long id) {
        MySugar entity = mySugarRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 글이 없습니다. id=" + id));
        return new MySugarDetailsDto(entity);
    }
}
