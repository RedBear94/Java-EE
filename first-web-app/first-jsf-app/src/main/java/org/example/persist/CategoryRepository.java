package org.example.persist;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@ApplicationScoped
@Named
public class CategoryRepository {
    private final Map<Long, Category> categoryMap = new ConcurrentHashMap<>();

    private final AtomicLong identity = new AtomicLong(0);

    @PostConstruct
    public void init() {
        save(new Category(null, "Category 1", "Description 1"));
        save(new Category(null, "Category 2", "Description 2"));
        save(new Category(null, "Category 3", "Description 3"));
        save(new Category(null, "Category 4", "Description 4"));
    }

    public void save(Category category) {
        if (category.getId() == null) {
            category.setId(identity.incrementAndGet());
        }
        categoryMap.put(category.getId(), category);
    }

    public void delete(Long id) {
        categoryMap.remove(id);
    }

    public Category findById(Long id) {
        return categoryMap.get(id);
    }

    public List<Category> findAll() {
        return new ArrayList<>(categoryMap.values());
    }
}
