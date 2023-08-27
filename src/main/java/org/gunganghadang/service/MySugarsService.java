package org.gunganghadang.service;

import lombok.RequiredArgsConstructor;
import org.gunganghadang.app.dto.MySugarsSaveDto;
import org.gunganghadang.domain.mysugars.MySugarsRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class MySugarsService {
    private final MySugarsRepository mySugarsRepository;

    @Transactional
    public Long save(MySugarsSaveDto requestDto) {
        return mySugarsRepository.save(requestDto.toEntity()).getId();
    }
}
