package org.gunganghadang.controller;

import lombok.RequiredArgsConstructor;
import org.gunganghadang.app.dto.MySugarDetailsDto;
import org.gunganghadang.app.dto.MySugarListDto;
import org.gunganghadang.app.dto.MySugarSaveDto;
import org.gunganghadang.domain.mysugar.MySugar;
import org.gunganghadang.service.MySugarsService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
public class MySugarApiController {
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
