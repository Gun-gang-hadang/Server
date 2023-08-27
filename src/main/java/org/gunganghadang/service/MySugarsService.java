package org.gunganghadang.service;

import lombok.RequiredArgsConstructor;
import org.gunganghadang.app.dto.MySugarDetailsDto;
import org.gunganghadang.app.dto.MySugarListDto;
import org.gunganghadang.app.dto.MySugarSaveDto;
import org.gunganghadang.domain.mysugar.MySugar;
import org.gunganghadang.domain.mysugar.MySugarRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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

    @Transactional(readOnly = true)
    public List<MySugarListDto> findAll() {
        List<MySugar> mySugars = mySugarRepository.findAllByOrderByDateDESC();
        return mySugars.stream()
                .map(MySugarListDto::new)
                .collect(Collectors.toList());
    }
}
