package itlap.repository;

import itlap.model.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ItemRepository extends JpaRepository<Item,Long> {
    @Query(value = "SELECT * FROM items i JOIN item_category ic ON i.id = ic.item_id JOIN categories c ON c.id = ic.category_id WHERE c.category_name = :category", nativeQuery = true)
    Page<Item> findByCategoryName(@Param("category") String category, Pageable pageable);
}
