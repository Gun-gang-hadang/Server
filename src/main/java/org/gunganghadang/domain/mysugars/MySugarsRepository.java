package org.gunganghadang.domain.mysugars;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MySugarsRepository extends JpaRepository<MySugars, Long> {
//    @Query("SELECT p FROM MySugars p ORDER BY p.id DESC")
//    List<MySugars> findAllDesc();
}
