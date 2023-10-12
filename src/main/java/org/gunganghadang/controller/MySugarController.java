package org.gunganghadang.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.gunganghadang.app.dto.MySugarDetailsDto;
import org.gunganghadang.app.dto.MySugarListDto;
import org.gunganghadang.app.dto.MySugarSaveDto;
import org.gunganghadang.service.MySugarsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class MySugarController {
    private final MySugarsService mySugarsService;

    @PostMapping("/api/v1/mysugar/save")
    public ResponseEntity<Long> save(@RequestBody MySugarSaveDto mySugarSaveDto) {
        Long saveValue = mySugarsService.save(mySugarSaveDto);
        if (saveValue == -1L) {
            return ResponseEntity.badRequest().body(-1L);
        }

        return ResponseEntity.ok(saveValue);
    }

    // @GetMapping("/api/v1/mysugar/{id}")
    // public MySugarDetailsDto findById (@PathVariable Long id) {
    //     return mySugarsService.findById(id);
    // }

    @GetMapping("/api/v1/mysugar")
    public List<MySugarListDto> mySugarList() {
        return mySugarsService.findAll();
    }

    @DeleteMapping("/api/v1/mysugar/{id}")
    public void deletePost(@PathVariable Long id) {
        this.mySugarsService.deleteMysugar(id);
    }
}
