package org.gunganghadang.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "login_user")
public class User implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @Column
    private String email;

    @Column(nullable = false)
    private String loginId;

    @Column(nullable = false)
    private String nickname;

    @Enumerated(EnumType.STRING)
    @Column
    private Role role;

    @Builder
    public User(String loginId, String email, String nickname, Role role) {
        this.loginId = loginId;
        this.email = email;
        this.nickname = nickname;
        this.role = role;
    }

    public User update(String loginId, String nickname) {
        this.loginId = loginId;
        this.nickname = nickname;
        return this;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }
}
