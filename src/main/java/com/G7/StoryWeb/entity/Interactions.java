package com.G7.StoryWeb.entity;

import javax.persistence.*;

@Entity(name = "interactions")
public class Interactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "interact_time")
    private long interact_time;

    @ManyToOne
    @JoinColumn(name = "literary_id")
    private Literaries literaries;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Users account;

    @ManyToOne
    @JoinColumn(name = "interact_type")
    private InteractTypes interactType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getInteract_time() {
        return interact_time;
    }

    public void setInteract_time(long interact_time) {
        this.interact_time = interact_time;
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

    public InteractTypes getInteractType() {
        return interactType;
    }

    public void setInteractType(InteractTypes interactType) {
        this.interactType = interactType;
    }




}
