package com.G7.StoryWeb.controller;

import com.G7.StoryWeb.dto.CategoriesDTO;
import com.G7.StoryWeb.service.imp.CategoriesSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class CategoriesController {

    @Autowired
    CategoriesSevice categoriesSevice;

    @PostMapping("")
    public ResponseEntity<?> insertCategories(@RequestBody CategoriesDTO categoriesDTO){
        categoriesSevice.insertCategories(categoriesDTO);
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<?> updateCategories(@RequestBody CategoriesDTO categoriesDTO){


        return new ResponseEntity<>("", HttpStatus.OK);
    }
    @DeleteMapping("")
    public  ResponseEntity<?> deteleCategories(){

        return new ResponseEntity<>("",HttpStatus.OK);
    }


}
