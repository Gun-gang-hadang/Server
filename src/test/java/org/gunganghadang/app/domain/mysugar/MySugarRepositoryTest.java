package org.gunganghadang.app.domain.mysugar;

import org.gunganghadang.domain.mysugar.MySugar;
import org.gunganghadang.domain.mysugar.MySugarRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class MySugarRepositoryTest {
    @Autowired
    MySugarRepository mySugarRepository;

    @AfterEach
    public void cleanup() {
        mySugarRepository.deleteAll();
    }

    @Test
    public void 내혈당_조회() {
        // given
        String date = "2023년 08월 20일";
        String time = "공복";
        int sugarLevel = 100;
        String state = "정상";

        mySugarRepository.save(MySugar.builder()
                .date(date)
                .time(time)
                .sugarLevel(sugarLevel)
                .state(state)
                .build());

        // when
        List<MySugar> mySugarList = mySugarRepository.findAll();

        // then
        MySugar mySugar = mySugarList.get(0);
        assertThat(mySugar.getDate()).isEqualTo(date);
        assertThat(mySugar.getTime()).isEqualTo(time);
        assertThat(mySugar.getSugarLevel()).isEqualTo(sugarLevel);
        assertThat(mySugar.getState()).isEqualTo(state);
    }
}
