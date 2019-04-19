package itlap;

import itlap.model.Category;
import itlap.model.Item;
import itlap.service.impl.CategoryServiceImpl;
import itlap.service.impl.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {
    @Autowired
    CategoryServiceImpl categoryServiceImpl;

    @Autowired
    ItemServiceImpl itemServiceImpl;

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
    public void run(String... args) {
        List<Category> categories = categoryServiceImpl.findByType("type1",0,5);
        if(!categories.isEmpty()) {
            System.out.println("id \t\tname \t\t  type_id");
            for (Category category : categories) {
                System.out.println(category.getId() + "\t\t" + category.getName() + "\t\t" + category.getTypes().getId());
            }
        }else {
            System.out.println("NOT FOUND !");
        }


        List<Item> items = itemServiceImpl.findByCategory("category1",0,5);
        if(!items.isEmpty()) {
            System.out.println("************************");
            System.out.println("id \t\tname");
            for (Item item : items) {
                System.out.println(item.getId() +"\t\t"+ item.getName());
            }
        }else {
            System.out.println("NOT FOUND !");
        }
        categoryServiceImpl.updateCategory((long) 1,"category1");
    }
}
