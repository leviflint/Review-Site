package org.wecancodeit.reviews.storage;

import org.springframework.stereotype.Service;
import org.wecancodeit.reviews.models.Category;
import org.wecancodeit.reviews.models.Review;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class CategoryStorage {
    Map<Long, Category> categoryList = new HashMap<>();

    public CategoryStorage(){
    }

    public void addCategory(Category categoryToAdd) {
        categoryList.put(categoryToAdd.getId(), categoryToAdd);
    }
    public Collection<Category> retrieveAllCategories(){
        return categoryList.values();
    }
    public Category retrieveCategoryById(Long id){
        return categoryList.get(id);
    }
}
