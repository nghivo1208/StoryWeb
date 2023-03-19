package com.G7.StoryWeb.entity;

import javax.persistence.*;

@Entity(name = "comments")
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "content")
    private String content;

    @Column(name = "comment_time")
    private long commentTime;

    @ManyToOne
    @JoinColumn(name = "literary_id")
    private Literaries literaries;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Users account;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(long commentTime) {
        this.commentTime = commentTime;
    }

    public Literaries getLiteraries() {
        return literaries;
    }

    public void setLiteraries(Literaries literaries) {
        this.literaries = literaries;
    }

    public Users getAccount() {
        return account;
    }

    public void setAccount(Users account) {
        this.account = account;
    }



}
