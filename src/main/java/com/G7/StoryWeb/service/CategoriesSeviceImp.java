package com.G7.StoryWeb.service;

import com.G7.StoryWeb.dto.CategoriesDTO;
import com.G7.StoryWeb.entity.Categories;
import com.G7.StoryWeb.repository.CategoriesRepository;
import com.G7.StoryWeb.service.imp.CategoriesSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CategoriesSeviceImp implements CategoriesSevice {


    @Autowired
    CategoriesRepository categoriesRepository;

    @Override
    public boolean insertCategories(CategoriesDTO categoriesDTO) {

        Categories categories = new Categories();
        categories.setDesc(categoriesDTO.getDesc());
        categories.setName(categoriesDTO.getName());

        try {
            categoriesRepository.save(categories);
            return true;
        }catch (Exception e){
            System.out.println("Lỗi insertCategories: "+e.getMessage());
            return false;
        }

    }

    @Override
    public boolean updateCategories(CategoriesDTO categoriesDTO) {
        Categories categories = new Categories();
        categories.setDesc(categoriesDTO.getDesc());
        categories.setName(categoriesDTO.getName());

        try {
            categoriesRepository.save(categories);
            return true;
        }catch (Exception e){
            System.out.println("Lỗi updateCategories: "+e.getMessage());
            return false;
        }
    }
}
