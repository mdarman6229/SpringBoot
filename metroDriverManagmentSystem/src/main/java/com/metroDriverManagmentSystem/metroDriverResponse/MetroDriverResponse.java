package com.metroDriverManagmentSystem.metroDriverResponse;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.UpperCamelCaseStrategy.class)

public class MetroDriverResponse {

    private Long id;
    private String driverName;
    private String metroNo;
    private String metroCity;
    private String runningLastDate;

   /* public MetroDriverResponse() {
    }

    public MetroDriverResponse(String driverName, Long id, String metroCity, String metroNo, String runningLastDate) {
        this.driverName = driverName;
        this.id = id;
        this.metroCity = metroCity;
        this.metroNo = metroNo;
        this.runningLastDate = runningLastDate;
    }*/

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
}
