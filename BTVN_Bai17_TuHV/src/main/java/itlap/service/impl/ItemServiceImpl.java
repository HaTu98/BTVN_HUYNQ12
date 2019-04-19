package itlap.service.impl;


import itlap.model.Category;
import itlap.model.Item;
import itlap.repository.CategoryRepository;
import itlap.repository.ItemRepository;
import itlap.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ItemRepository itemRepository;

    @Override
    public List<Item> findByCategory(String category, int pageIndex, int pageSize) {
        Category cat = categoryRepository.findByName(category);
        Page<Item> items = itemRepository.findByCategoryId(cat.getId(),new PageRequest(pageIndex,pageSize));
        return items.getContent();
    }
}
