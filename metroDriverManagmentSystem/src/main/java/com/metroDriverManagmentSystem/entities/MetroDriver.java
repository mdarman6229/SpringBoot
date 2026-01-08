package com.metroDriverManagmentSystem.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name =  "metro_driver")
public class MetroDriver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "driver_name")
    private String driverName;

    @Column(name = "metro_no")
    private String metroNo;

    @Column(name = "metro_city")
    private String metroCity;

    @Column(name = "running_last_date")
    private String runningLastDate;



    public MetroDriver() {
    }

    public MetroDriver(String driverName, Long id, String metroCity, String metroNo, String runningLastDate) {
        this.driverName = driverName;
        this.id = id;
        this.metroCity = metroCity;
        this.metroNo = metroNo;
        this.runningLastDate = runningLastDate;
    }


    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMetroCity() {
        return metroCity;
    }

    public void setMetroCity(String metroCity) {
        this.metroCity = metroCity;
    }

    public String getMetroNo() {
        return metroNo;
    }

    public void setMetroNo(String metroNo) {
        this.metroNo = metroNo;
    }

    public String getRunningLastDate() {
        return runningLastDate;
    }

    public void setRunningLastDate(String runningLastDate) {
        this.runningLastDate = runningLastDate;
    }

    @Override
    public String toString() {
        return "MetroDriver{" +
                "driverName='" + driverName + '\'' +
                ", id=" + id +
                ", metroNo='" + metroNo + '\'' +
                ", metroCity='" + metroCity + '\'' +
                ", runningLastDate='" + runningLastDate + '\'' +
                '}';
    }
}
