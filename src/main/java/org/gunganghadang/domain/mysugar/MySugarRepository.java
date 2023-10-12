package org.gunganghadang.domain.mysugar;

import org.gunganghadang.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface MySugarRepository extends JpaRepository<MySugar, Long> {
    @Query("SELECT s FROM MySugar s ORDER BY s.date DESC, s.post_id DESC")
    List<MySugar> findAllByOrderByDateDESC();

    boolean existsMySugarByUserAndDateAndTime(User user, String date, String time);

    @Query("SELECT s FROM MySugar s WHERE s.user.loginId = :loginId ORDER BY s.date DESC, " +
            "CASE s.time " +
            "  WHEN '공복' THEN 0 " +
            "  WHEN '아침 식사 전' THEN 1 " +
            "  WHEN '아침 식사 후' THEN 2 " +
            "  WHEN '점심 식사 전' THEN 3 " +
            "  WHEN '점심 식사 후' THEN 4 " +
            "  WHEN '저녁 식사 전' THEN 5 " +
            "  WHEN '저녁 식사 후' THEN 6 " +
            "  WHEN '취침 전' THEN 7 " +
            "END DESC")
    List<MySugar> findAllByUserLoginIdOrderByDateDesc(@Param("loginId") String loginId);
}
