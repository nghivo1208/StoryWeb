package com.G7.StoryWeb.repository;

import com.G7.StoryWeb.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    List<Users> findByEmailAndPassword(String username, String password);
}
