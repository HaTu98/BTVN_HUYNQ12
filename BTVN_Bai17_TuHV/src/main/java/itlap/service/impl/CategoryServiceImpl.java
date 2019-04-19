package itlap.service.impl;

import itlap.model.Category;
import itlap.repository.CategoryRepository;
import itlap.repository.TypeRepository;
import itlap.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    TypeRepository typeRepository;

    @Override
    public List<Category> findByType(String type, int pageIndex, int pageSize) {
        Page<Category> categories = categoryRepository.findByTypesId(typeRepository.findByName(type).getId(),new PageRequest(pageIndex,pageSize));
        return categories.getContent();
    }

    @Override
    @Transactional
    public void updateCategory(Long id, String name) {
        if (categoryRepository.findById(id).isPresent()){
            Category category  = categoryRepository.findById(id).get();
            category.setName(name);
            categoryRepository.save(category);
        }else {
            System.out.println("Not Found!!!");
        }

    }
}
