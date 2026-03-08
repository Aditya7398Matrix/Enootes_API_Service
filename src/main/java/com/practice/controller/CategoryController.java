package com.practice.controller;

import java.util.List;
import org.springframework.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cglib.core.CollectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.entity.Category;
import com.practice.service.CategoryService;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	@PostMapping("/save-categories")
	public ResponseEntity<?> saveCategory(@RequestBody Category category){
	Boolean savecategory=categoryService.saveCategory(category);
	if(!savecategory) {
		return new ResponseEntity<>("not saved ",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	return new ResponseEntity<>("saved ",HttpStatus.CREATED);
	}
	@GetMapping("/category")
	public ResponseEntity<?> getAllCategory(){
    List<Category> allcategory=categoryService.getAllCategories();
    if(CollectionUtils.isEmpty(allcategory)) {
    	return ResponseEntity.noContent().build();
		//return new ResponseEntity<>("no category found ",HttpStatus.NOT_FOUND);
	}else {
		return new ResponseEntity<>(allcategory,HttpStatus.OK);
	}
	}
	

}
