package com.G7.StoryWeb.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "categories")
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String desc;

    @OneToMany(mappedBy = "categories")
    private Set<Literaries> listLiteraries;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Set<Literaries> getListLiteraries() {
        return listLiteraries;
    }

    public void setListLiteraries(Set<Literaries> listLiteraries) {
        this.listLiteraries = listLiteraries;
    }
}
