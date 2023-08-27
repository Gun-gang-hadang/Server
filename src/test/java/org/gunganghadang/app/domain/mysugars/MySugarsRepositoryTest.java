package org.gunganghadang.app.domain.mysugars;

import org.gunganghadang.domain.mysugars.MySugars;
import org.gunganghadang.domain.mysugars.MySugarsRepository;
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
public class MySugarsRepositoryTest {
    @Autowired
    MySugarsRepository mySugarsRepository;

    @AfterEach
    public void cleanup() {
        mySugarsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        // given
        String date = "테스트 날짜";
        String time = "테스트 입력 시기";
        int sugarLevel = 100;
        String state = "정상";

        mySugarsRepository.save(MySugars.builder()
                .date(date)
                .time(time)
                .sugarLevel(sugarLevel)
                .state(state)
                .build());

        // when
        List<MySugars> mySugarsList = mySugarsRepository.findAll();

        // then
        MySugars mySugars = mySugarsList.get(0);
        assertThat(mySugars.getDate()).isEqualTo(date);
        assertThat(mySugars.getTime()).isEqualTo(time);
        assertThat(mySugars.getSugarLevel()).isEqualTo(sugarLevel);
        assertThat(mySugars.getState()).isEqualTo(state);
    }
}
