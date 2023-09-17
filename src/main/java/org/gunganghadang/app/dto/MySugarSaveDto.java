package org.gunganghadang.app.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.gunganghadang.domain.mysugar.MySugar;
import org.gunganghadang.domain.user.User;

@Getter
@NoArgsConstructor
public class MySugarSaveDto {
    private String date;
    private String time;
    private int sugarLevel;
    private String state;
    private User user;

    public void setUser(User user) {
        this.user = user;
    }

    @Builder
    public MySugarSaveDto(String date, String time, int sugarLevel, String state, User user) {
        this.date = date;
        this.time = time;
        this.sugarLevel = sugarLevel;
        this.state = state;
        this.user = user;
    }

    public MySugar toEntity(User user) {
        return MySugar.builder()
                .date(date)
                .time(time)
                .sugarLevel(sugarLevel)
                .state(state)
                .user(user)
                .build();
    }
}
