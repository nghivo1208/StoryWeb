package com.G7.StoryWeb.entity;

import javax.persistence.*;

@Entity(name = "reports")
public class Reports {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_report")
    private Users userReport;

    @ManyToOne
    @JoinColumn(name = "user_reported")
    private Users userReported;

    @ManyToOne
    @JoinColumn(name = "report_type_id")
    private ReportTypes reportType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Users getUserReport() {
        return userReport;
    }

    public void setUserReport(Users userReport) {
        this.userReport = userReport;
    }

    public Users getUserReported() {
        return userReported;
    }

    public void setUserReported(Users userReported) {
        this.userReported = userReported;
    }

    public ReportTypes getReportType() {
        return reportType;
    }

    public void setReportType(ReportTypes reportType) {
        this.reportType = reportType;
    }



}
