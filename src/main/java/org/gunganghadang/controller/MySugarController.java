package org.gunganghadang.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.gunganghadang.app.dto.MySugarDetailsDto;
import org.gunganghadang.app.dto.MySugarListDto;
import org.gunganghadang.app.dto.MySugarSaveDto;
import org.gunganghadang.service.MySugarsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class MySugarController {
    private final MySugarsService mySugarsService;

    @PostMapping("/api/v1/mysugar/save")
    public Long save(@RequestBody MySugarSaveDto mySugarSaveDto) {
        return mySugarsService.save(mySugarSaveDto);
    }

    @GetMapping("/api/v1/mysugar/{id}")
    public MySugarDetailsDto findById (@PathVariable Long id) {
        return mySugarsService.findById(id);
    }

    @GetMapping("/api/v1/mysugar")
    public List<MySugarListDto> mySugarList() {
        return mySugarsService.findAll();
    }
}
