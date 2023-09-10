package org.gunganghadang.app.dto;

import lombok.Getter;
import org.gunganghadang.domain.mysugar.MySugar;

@Getter
public class MySugarDetailsDto {
    private Long post_id;
    private String date;
    private String time;
    private int sugarLevel;
    private String state;

    public MySugarDetailsDto(MySugar entity) {
        this.post_id = entity.getPost_id();
        this.date = entity.getDate();
        this.time = entity.getTime();
        this.sugarLevel = entity.getSugarLevel();
        this.state = entity.getState();
    }
}
