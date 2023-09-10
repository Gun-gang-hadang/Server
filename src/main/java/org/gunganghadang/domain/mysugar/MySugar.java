package org.gunganghadang.domain.mysugar;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class MySugar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long post_id;

    @Column(nullable = false)
    private String date;

    @Column(nullable = false)
    private String time;

    @Column(nullable = false)
    private int sugarLevel;

    @Column(nullable = false)
    private String state;

    @Builder
    public MySugar(Long post_id, String date, String time, int sugarLevel, String state) {
        this.post_id = post_id;
        this.date = date;
        this.time = time;
        this.sugarLevel = sugarLevel;
        this.state = state;
    }
}
