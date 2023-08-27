package org.gunganghadang.app.controller;

import org.gunganghadang.app.dto.MySugarsSaveDto;
import org.gunganghadang.domain.mysugars.MySugars;
import org.gunganghadang.domain.mysugars.MySugarsRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MySugarsApiControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private MySugarsRepository mySugarsRepository;

    @AfterEach
    public void tearDown() throws Exception {
        mySugarsRepository.deleteAll();
    }

    @Test
    public void MySugar_등록() throws Exception {
        // given
        String date = "2023년 08월 10일";
        String time = "아침식사 전";
        int sugarLevel = 100;
        String state = "정상";
        MySugarsSaveDto mySugarsSaveDto = MySugarsSaveDto.builder()
                .date(date)
                .time(time)
                .sugarLevel(sugarLevel)
                .state(state)
                .build();

        String url = "http://localhost:" + port + "/api/v1/writings";

        // when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, mySugarsSaveDto, Long.class);

        // then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<MySugars> all = mySugarsRepository.findAll();
        assertThat(all.get(0).getDate()).isEqualTo(date);
        assertThat(all.get(0).getTime()).isEqualTo(time);
        assertThat(all.get(0).getSugarLevel()).isEqualTo(sugarLevel);
        assertThat(all.get(0).getState()).isEqualTo(state);
    }
}