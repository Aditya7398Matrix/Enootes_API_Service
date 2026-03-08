package com.practice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.practice.entity.Category;
import com.practice.repository.CategoryRepository;
import com.practice.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
	private CategoryRepository categoryRepo;
	@Override
	public Boolean saveCategory(Category category) {
		category.setIsDeleted(false);
	  category.setCreatedOn(1);
		//category.setCreatedOn(new java.util.Date());
		Category saveCategory=categoryRepo.save(category);
		if(ObjectUtils.isEmpty(saveCategory)) {
			return false;
		}
		return true;
	}

	@Override
	public List<Category> getAllCategories() {
		List<Category> categories=categoryRepo.findAll();
		
		return categories;
	}

}
