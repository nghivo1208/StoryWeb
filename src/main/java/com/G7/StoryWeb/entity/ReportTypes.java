package com.G7.StoryWeb.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "report_types")
public class ReportTypes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String desc;

    @OneToMany(mappedBy = "reportType")
    private Set<Reports> listReport;


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

    public Set<Reports> getListReport() {
        return listReport;
    }

    public void setListReport(Set<Reports> listReport) {
        this.listReport = listReport;
    }
}
