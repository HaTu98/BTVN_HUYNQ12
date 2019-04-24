package com.itlap.repository;

import com.itlap.model.VieToEng;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface VieToEngRepository extends JpaRepository<VieToEng, Long> {
    @Query(value = "SELECT * FROM Vie_to_Eng WHERE vie LIKE CONCAT('%', CONVERT(?1, BINARY), '%')", nativeQuery = true)
    Page<VieToEng> findByVie(String vie, Pageable pageable);

    @Modifying
    @Query(value = "insert into vie_to_eng (vie, eng) values (:vie, :eng)",
            nativeQuery = true)
    void insertVieToEng(@Param("vie") String vie, @Param("eng") String eng);
}
