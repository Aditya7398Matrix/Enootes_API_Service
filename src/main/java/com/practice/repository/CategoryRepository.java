package com.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
