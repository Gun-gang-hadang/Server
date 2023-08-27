package org.gunganghadang.controller;

import lombok.RequiredArgsConstructor;
import org.gunganghadang.app.dto.MySugarDetailsDto;
import org.gunganghadang.app.dto.MySugarSaveDto;
import org.gunganghadang.service.MySugarsService;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class MySugarApiController {
    private final MySugarsService mySugarsService;

    @PostMapping("/api/v1/mysugar")
    public Long save(@RequestBody MySugarSaveDto mySugarSaveDto) {
        return mySugarsService.save(mySugarSaveDto);
    }

    @GetMapping("/api/v1/mysugar/{id}")
    public MySugarDetailsDto findById (@PathVariable Long id) {
        return mySugarsService.findById(id);
    }
}
