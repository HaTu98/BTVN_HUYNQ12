package itlap.repository;

import itlap.model.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ItemRepository extends JpaRepository<Item,Long> {

    @Query(value = "SELECT * from items as i " +
            "inner join item_category as ic on i.id = ic.item_id " +
                "where ic.category_id = ?1",nativeQuery = true)
    Page<Item> findByCategoryId(Long id, Pageable pageable);
}
