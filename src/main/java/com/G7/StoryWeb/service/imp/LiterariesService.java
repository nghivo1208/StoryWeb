package com.G7.StoryWeb.service.imp;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface LiterariesService {
    boolean saveFiles(MultipartFile file);
    boolean addLiterariesToDatabase(int account_id,int category_id,String literary_name, String summary, int chapter_id);
}
