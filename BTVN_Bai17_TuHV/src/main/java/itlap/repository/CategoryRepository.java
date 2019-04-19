package itlap.repository;

import itlap.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query(value = "SELECT * FROM categories c JOIN types t ON c.type_id = t.id WHERE t.type_name = :typeName", nativeQuery = true)
    Page<Category> findByTypesName(@Param("typeName") String type, Pageable pageable);
}
