package org.gunganghadang.domain.mysugar;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.gunganghadang.domain.user.User;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writer", referencedColumnName = "loginId")
    private User user;

    @Builder
    public MySugar(Long post_id, String date, String time, int sugarLevel, String state, User user) {
        this.post_id = post_id;
        this.date = date;
        this.time = time;
        this.sugarLevel = sugarLevel;
        this.state = state;
        this.user = user;
    }
}
