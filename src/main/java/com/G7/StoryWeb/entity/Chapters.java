package com.G7.StoryWeb.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "chapters")
public class Chapters {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "chapter_order")
    private int chapterOrder;

    @Column(name = "chapter_title")
    private String chapterTitle;

    @Column(name = "date_submitted")
    private long dateSubmitted;

    @Column(name = "content_url")
    private String contentUrl;

    @ManyToOne
    @JoinColumn(name = "literaries_id")
    private Literaries literaries;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getChapterOrder() {
        return chapterOrder;
    }

    public void setChapterOrder(int chapterOrder) {
        this.chapterOrder = chapterOrder;
    }

    public String getChapterTitle() {
        return chapterTitle;
    }

    public void setChapterTitle(String chapterTitle) {
        this.chapterTitle = chapterTitle;
    }

    public long getDateSubmitted() {
        return dateSubmitted;
    }

    public void setDateSubmitted(long dateSubmitted) {
        this.dateSubmitted = dateSubmitted;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }

    public Literaries getLiteraries() {
        return literaries;
    }

    public void setLiteraries(Literaries literaries) {
        this.literaries = literaries;
    }
}
