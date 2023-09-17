package org.gunganghadang.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Component
@Getter
@NoArgsConstructor
@Entity
@Table(name = "login_user")
public class User implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @Column(nullable = false)
    private Long loginId;

    @Column(nullable = false)
    private String nickname;

    @Builder
    public User(Long loginId, String nickname) {
        this.loginId = loginId;
        this.nickname = nickname;
    }

    public User update(Long loginId, String nickname) {
        this.loginId = loginId;
        this.nickname = nickname;
        return this;
    }
}
