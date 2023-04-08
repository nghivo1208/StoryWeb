package com.G7.StoryWeb.repository;

import com.G7.StoryWeb.entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories,Integer> {

}
