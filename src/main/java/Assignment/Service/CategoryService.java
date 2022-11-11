package Assignment.Service;

import Assignment.Dto.RequestCategoryDTO;
import Assignment.Entity.Category;

import java.util.List;

public interface CategoryService {

    RequestCategoryDTO save(RequestCategoryDTO category);

    RequestCategoryDTO update(Long id, RequestCategoryDTO category);

    List<Category> getAllCategory();

    Boolean deleteCategory(Long id);
}
