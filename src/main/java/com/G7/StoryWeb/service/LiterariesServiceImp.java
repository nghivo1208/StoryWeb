package com.G7.StoryWeb.service;

import com.G7.StoryWeb.entity.*;
import com.G7.StoryWeb.repository.LiterariesRepository;
import com.G7.StoryWeb.service.imp.LiterariesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.annotation.MultipartConfig;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class LiterariesServiceImp implements LiterariesService {
    @Autowired
    LiterariesRepository literariesRepository;

    @Value("${upload.path}")
    private String path;

    private Path root;


    @Override
    public boolean saveFiles(MultipartFile file) {
        try {
            init();
//            Files.copy(file.getInputStream(),this.root.resolve(file.getOriginalFilename())); // /uploads/buger.png
            Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);

            return true;
        } catch (Exception e) {
            System.out.println("Error save file: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean addLiterariesToDatabase(int account_id, int category_id,String literary_name ,String summary, int chapter_id) {
        Roles roles = new Roles();

        Users user = new Users();
        user.setId(account_id);
        user.setRoles(roles);

        Categories categories = new Categories();
        categories.setId(category_id);

        Chapters chapters = new Chapters();
        chapters.setId(chapter_id);

        Literaries literaries = new Literaries();
        literaries.setAccount(user);

        literaries.setCategories(categories);
        literaries.setSummary(summary);
        literaries.setLiteraryName(literary_name);

        try {
            literariesRepository.save(literaries);
            return true;
        }catch (Exception e){
            System.out.println("Lỗi insert literaries: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Resource load(String fileName) {
        try{
            init();
            Path file = root.resolve(fileName);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        }catch(Exception e){
            System.out.println("Error load: " + e.getMessage());
            return null;
        }
    }

    private void init() {
        try {
            root = Paths.get(path);
            if (!Files.exists(root)) {
                Files.createDirectories(root);
            }
        } catch (Exception e) {
            System.out.println("Error create folder: " + e.getMessage());
        }
    }
}
