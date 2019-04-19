package itlap.service;


import itlap.model.Item;

import java.util.List;

public interface ItemService {
    List<Item> findByCategory(String category, int pageIndex, int pageSize);
}