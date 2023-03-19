package com.G7.StoryWeb.entity;

import javax.persistence.*;

@Entity(name = "follows")
public class Follows {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_fl_id")
    private Users user_fl_id;

    @ManyToOne
    @JoinColumn(name = "user_followed_id")
    private Users user_followed_id;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Users getUser_fl_id() {
        return user_fl_id;
    }

    public void setUser_fl_id(Users user_fl_id) {
        this.user_fl_id = user_fl_id;
    }

    public Users getUser_followed_id() {
        return user_followed_id;
    }

    public void setUser_followed_id(Users user_followed_id) {
        this.user_followed_id = user_followed_id;
    }



}
