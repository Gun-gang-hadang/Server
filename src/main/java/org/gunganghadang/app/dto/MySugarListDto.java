package org.gunganghadang.app.dto;

import lombok.Getter;
import org.gunganghadang.domain.mysugar.MySugar;

@Getter
public class MySugarListDto {
    private Long id;
    private String date;
    private String time;
    private int sugarLevel;
    private String state;

    public MySugarListDto(MySugar entity) {
        this.id = entity.getId();
        this.date = entity.getDate();
        this.time = entity.getTime();
        this.sugarLevel = entity.getSugarLevel();
        this.state = entity.getState();
    }
}
