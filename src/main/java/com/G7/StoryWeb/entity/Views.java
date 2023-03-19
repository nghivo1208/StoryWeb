package com.G7.StoryWeb.entity;

import javax.persistence.*;

@Entity(name = "views")
public class Views {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "time_view")
    private long timeView;

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

    public long getTimeView() {
        return timeView;
    }

    public void setTimeView(long timeView) {
        this.timeView = timeView;
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
