package org.gunganghadang.app.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.gunganghadang.domain.mysugars.MySugars;

@Getter
@NoArgsConstructor
public class MySugarsSaveDto {
    private String date;
    private String time;
    private int sugarLevel;
    private String state;

    @Builder
    public MySugarsSaveDto(String date, String time, int sugarLevel, String state) {
        this.date = date;
        this.time = time;
        this.sugarLevel = sugarLevel;
        this.state = state;
    }

    public MySugars toEntity() {
        return MySugars.builder()
                .date(date)
                .time(time)
                .sugarLevel(sugarLevel)
                .state(state)
                .build();
    }
}
