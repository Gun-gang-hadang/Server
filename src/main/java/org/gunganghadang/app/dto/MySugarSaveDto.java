package org.gunganghadang.app.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.gunganghadang.domain.mysugar.MySugar;

@Getter
@NoArgsConstructor
public class MySugarSaveDto {
    private String date;
    private String time;
    private int sugarLevel;
    private String state;

    @Builder
    public MySugarSaveDto(String date, String time, int sugarLevel, String state) {
        this.date = date;
        this.time = time;
        this.sugarLevel = sugarLevel;
        this.state = state;
    }

    public MySugar toEntity() {
        return MySugar.builder()
                .date(date)
                .time(time)
                .sugarLevel(sugarLevel)
                .state(state)
                .build();
    }
}
