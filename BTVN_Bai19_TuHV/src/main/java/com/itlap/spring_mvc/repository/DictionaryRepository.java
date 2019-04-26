package com.itlap.spring_mvc.repository;

import com.itlap.spring_mvc.model.Dictionary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DictionaryRepository extends JpaRepository<Dictionary,Long> {
    @Query(value = "SELECT * FROM dictionary WHERE word LIKE CONCAT(CONVERT(?1, BINARY), '%')", nativeQuery = true)
    Page<Dictionary> findByWord(String word, Pageable pageable);

    @Query(value = "SELECT * from dictionary where word = ?1 limit 1", nativeQuery = true)
    Dictionary findByWord(String word);

    @Modifying
    @Query(value = "insert into dictionary (word, mean) values (:word, :mean)",
            nativeQuery = true)
    void insertDictionary(@Param("word") String word, @Param("mean") String mean);
}