package com.G7.StoryWeb.repository;

import com.G7.StoryWeb.entity.Literaries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LiterariesRepository extends JpaRepository<Literaries,Integer> {
}
