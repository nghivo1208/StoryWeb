package com.G7.StoryWeb.entity;

import javax.persistence.*;

import javax.persistence.Entity;
import java.util.Set;

@Entity(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "login_id")
    private int login_id;

    @Column(name = "id_number")
    private int id_number;

    @Column(name = "address")
    private String address;

    @Column(name = "stp")
    private int stp;

    @Column(name = "warning_times")
    private int warning_times;

    @Column(name = "status")
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Roles roles;

    @OneToMany(mappedBy = "user_fl_id")
    private Set<Follows> listFollow;

    @OneToMany(mappedBy = "user_followed_id")
    private Set<Follows> listFollowed;

    @OneToMany(mappedBy = "userReport")
    private Set<Reports> listReport;

    @OneToMany(mappedBy = "userReported")
    private Set<Reports> listReported;

    @OneToMany(mappedBy = "inboundAccount")
    private Set<Ledgers> listInboundAccount;

    @OneToMany(mappedBy = "outboundAccount")
    private Set<Ledgers> listOutboundAccount;

    @OneToMany(mappedBy = "account")
    private Set<Literaries> listLiteraries;

    @OneToMany(mappedBy = "account")
    private Set<Comments> listComment;

    @OneToMany(mappedBy = "account")
    private Set<Views> listView;

    @OneToMany(mappedBy = "account")
    private Set<Interactions> listInteraction;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getLogin_id() {
        return login_id;
    }

    public void setLogin_id(int login_id) {
        this.login_id = login_id;
    }

    public int getId_number() {
        return id_number;
    }

    public void setId_number(int id_number) {
        this.id_number = id_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStp() {
        return stp;
    }

    public void setStp(int stp) {
        this.stp = stp;
    }

    public int getWarning_times() {
        return warning_times;
    }

    public void setWarning_times(int warning_times) {
        this.warning_times = warning_times;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public Set<Follows> getListFollow() {
        return listFollow;
    }

    public void setListFollow(Set<Follows> listFollow) {
        this.listFollow = listFollow;
    }

    public Set<Follows> getListFollowed() {
        return listFollowed;
    }

    public void setListFollowed(Set<Follows> listFollowed) {
        this.listFollowed = listFollowed;
    }

    public Set<Reports> getListReport() {
        return listReport;
    }

    public void setListReport(Set<Reports> listReport) {
        this.listReport = listReport;
    }

    public Set<Reports> getListReported() {
        return listReported;
    }

    public void setListReported(Set<Reports> listReported) {
        this.listReported = listReported;
    }

    public Set<Ledgers> getListInboundAccount() {
        return listInboundAccount;
    }

    public void setListInboundAccount(Set<Ledgers> listInboundAccount) {
        this.listInboundAccount = listInboundAccount;
    }

    public Set<Ledgers> getListOutboundAccount() {
        return listOutboundAccount;
    }

    public void setListOutboundAccount(Set<Ledgers> listOutboundAccount) {
        this.listOutboundAccount = listOutboundAccount;
    }

    public Set<Literaries> getListLiteraries() {
        return listLiteraries;
    }

    public void setListLiteraries(Set<Literaries> listLiteraries) {
        this.listLiteraries = listLiteraries;
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

}
