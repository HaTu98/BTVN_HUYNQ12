package itlap.model;

import lombok.Data;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "types")
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type_name")
    private String name;

    @OneToMany(mappedBy = "types", fetch = FetchType.LAZY)
    private List<Category> categories = new ArrayList<>();
}
