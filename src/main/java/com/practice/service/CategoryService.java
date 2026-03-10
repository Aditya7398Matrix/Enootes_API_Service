package com.practice.service;

import java.util.List;

import com.practice.dto.CategoryResponse;
import com.practice.dto.CategoryDto;
import com.practice.entity.Category;

public interface CategoryService {
public Boolean saveCategory(CategoryDto categorydto);
public List<CategoryDto> getAllCategories();
//public List<Category> getAllCategories1();
//public Boolean saveCategory1(Category category);
public List<CategoryResponse> getActiveCategories();

}
