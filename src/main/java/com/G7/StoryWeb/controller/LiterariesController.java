package com.G7.StoryWeb.controller;

import com.G7.StoryWeb.service.imp.LiterariesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/Literaries")
public class LiterariesController {
    @Autowired
    LiterariesService literariesService;

    @PostMapping("")
    public ResponseEntity<?> uploadLiterariesToDataBaseAndMemory(
            @RequestParam("file") MultipartFile file,
            @RequestParam int category,
            @RequestParam String literary_name
    ){
        try {
            if (literariesService.saveFiles(file)){
                literariesService.addLiterariesToDatabase(2,category,literary_name,file.getOriginalFilename(), 2);
                System.out.println("OK");
            }else {
                System.out.println("not yet");
            }

        }catch(Exception e){

        }
        return new ResponseEntity<>("", HttpStatus.OK);
    }
}
