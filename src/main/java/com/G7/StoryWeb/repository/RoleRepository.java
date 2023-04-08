package com.G7.StoryWeb.repository;

import com.G7.StoryWeb.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Roles,Integer> {
    List<Roles> findByRoleName(String name);
}
