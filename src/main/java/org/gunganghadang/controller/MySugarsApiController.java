package org.gunganghadang.controller;

import lombok.RequiredArgsConstructor;
import org.gunganghadang.app.dto.MySugarsSaveDto;
import org.gunganghadang.service.MySugarsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MySugarsApiController {
    private final MySugarsService mySugarsService;

    @PostMapping("/api/v1/writings")
    public Long save(@RequestBody MySugarsSaveDto mySugarsSaveDto) {
        return mySugarsService.save(mySugarsSaveDto);
    }
}
