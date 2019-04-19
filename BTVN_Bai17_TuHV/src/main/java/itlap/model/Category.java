package itlap.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type types;

    @OneToMany
    @JoinTable(
            name="Item_Category",
            joinColumns = @JoinColumn( name="category_id"),
            inverseJoinColumns = @JoinColumn( name="item_id")
    )
    private List<Item> items = new ArrayList<>();
}
