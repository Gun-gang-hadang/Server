package org.gunganghadang.domain.mysugars;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class MySugars {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String date;

    @Column(nullable = false)
    private String time;

    @Column(nullable = false)
    private int sugarLevel;

    @Column(nullable = false)
    private String state;

    @Builder
    public MySugars(String date, String time, int sugarLevel, String state) {
        this.date = date;
        this.time = time;
        this.sugarLevel = sugarLevel;
        this.state = state;
    }
}
