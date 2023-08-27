package org.gunganghadang.domain.mysugar;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MySugarRepository extends JpaRepository<MySugar, Long> {
//    @Query("SELECT p FROM MySugar p ORDER BY p.id DESC")
//    List<MySugar> findAllDesc();
}
