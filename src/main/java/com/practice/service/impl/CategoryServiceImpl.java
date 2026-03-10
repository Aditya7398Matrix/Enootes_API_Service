package com.practice.service.impl;
import com.practice.dto.CategoryResponse;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.practice.dto.CategoryDto;
import com.practice.entity.Category;
import com.practice.repository.CategoryRepository;
//import com.practice.service.CategoryResponse;
import com.practice.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepo;
    @Autowired	
   private ModelMapper mapper;

    public Boolean saveCategory(CategoryDto categoryDto) {

//        Category category = new Category();
//        category.setName(categoryDto.getName());
//        category.setDescription(categoryDto.getDescription());
//        category.setIsActive(categoryDto.getIsActive());
    Category category=	mapper.map(categoryDto, Category.class);

        category.setIsDeleted(false);
        category.setCreatedOn(new Date());
        category.setCreatedBy(1); 

        Category saveCategory = categoryRepo.save(category);

        if (ObjectUtils.isEmpty(saveCategory)) {
            return false;
        }

        return true;
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categories = categoryRepo.findAll();
        List<CategoryDto> categoryDto=categories.stream().map(cat->mapper.map(cat,CategoryDto.class)).toList();
        
        
        return categoryDto;
    }

	@Override
	public List<CategoryResponse> getActiveCategories() {
		// TODO Auto-generated method stub
		 List<Category> categories = categoryRepo.findByIsActiveTrue();
	     List<CategoryResponse> categoryList= categories.stream().map(cat->mapper.map(cat,CategoryResponse.class)).toList();
		return categoryList;
	}
}