package com.G7.StoryWeb.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "literaries")
public class Literaries {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "literary_name")
    private String literaryName;

    @Column(name = "age")
    private int age;

    @Column(name = "is_Plus")
    private int isPlus;

    @Column(name = "date_submitted")
    private long dateSubmitted;

    @Column(name = "summary")
    private String summary;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Categories categories;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Users account;

    @OneToMany(mappedBy = "literaries")
    private Set<Comments> listComment;

    @OneToMany(mappedBy = "literaries")
    private Set<Views> listView;

    @OneToMany(mappedBy = "literaries")
    private Set<Interactions> listInteraction;

    @OneToMany(mappedBy = "literaries")
    private Set<Chapters> listChapter;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLiteraryName() {
        return literaryName;
    }

    public void setLiteraryName(String literaryName) {
        this.literaryName = literaryName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getDateSubmitted() {
        return dateSubmitted;
    }

    public void setDateSubmitted(long dateSubmitted) {
        this.dateSubmitted = dateSubmitted;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    public Users getAccount() {
        return account;
    }

    public void setAccount(Users account) {
        this.account = account;
    }

    public Set<Comments> getListComment() {
        return listComment;
    }

    public void setListComment(Set<Comments> listComment) {
        this.listComment = listComment;
    }

    public Set<Views> getListView() {
        return listView;
    }

    public void setListView(Set<Views> listView) {
        this.listView = listView;
    }

    public Set<Interactions> getListInteraction() {
        return listInteraction;
    }

    public void setListInteraction(Set<Interactions> listInteraction) {
        this.listInteraction = listInteraction;
    }

    public int getIsPlus() {
        return isPlus;
    }

    public void setIsPlus(int isPlus) {
        this.isPlus = isPlus;
    }

    public Set<Chapters> getListChapter() {
        return listChapter;
    }

    public void setListChapter(Set<Chapters> listChapter) {
        this.listChapter = listChapter;
    }
}
