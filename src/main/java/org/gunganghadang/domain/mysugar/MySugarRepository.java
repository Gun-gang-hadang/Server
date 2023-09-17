package org.gunganghadang.domain.mysugar;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MySugarRepository extends JpaRepository<MySugar, Long> {
    @Query("SELECT s FROM MySugar s ORDER BY s.date DESC, s.post_id DESC")
    List<MySugar> findAllByOrderByDateDESC();

    @Query("SELECT s FROM MySugar s WHERE s.user.loginId = :loginId ORDER BY s.date DESC, s.post_id DESC")
    List<MySugar> findAllByUserLoginIdOrderByDateDesc(@Param("loginId") Long loginId);
}
