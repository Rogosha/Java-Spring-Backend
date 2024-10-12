package hello.Models.DTOs;

import hello.Models.Airports;
import hello.Models.CabinTypes;
import jakarta.persistence.*;

public class SurveysDTO {
    private int id;

    private Integer month;

    private Integer year;

    private String departureAirport;

    private String arrivalAirport;

    private Integer age;

    private Boolean gender;

    private String cabinType;

    private Integer Q1;

    private Integer Q2;

    private Integer Q3;

    private Integer Q4;

    public SurveysDTO(int id, Integer month, Integer year, String departureAirport, String arrivalAirport, Integer age, Boolean gender, String cabinType, Integer q1, Integer q2, Integer q3, Integer q4) {
        this.id = id;
        this.month = month;
        this.year = year;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.age = age;
        this.gender = gender;
        this.cabinType = cabinType;
        Q1 = q1;
        Q2 = q2;
        Q3 = q3;
        Q4 = q4;
    }

    public SurveysDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getQ4() {
        return Q4;
    }

    public void setQ4(Integer q4) {
        Q4 = q4;
    }

    public Integer getQ3() {
        return Q3;
    }

    public void setQ3(Integer q3) {
        Q3 = q3;
    }

    public Integer getQ2() {
        return Q2;
    }

    public void setQ2(Integer q2) {
        Q2 = q2;
    }

    public Integer getQ1() {
        return Q1;
    }

    public void setQ1(Integer q1) {
        Q1 = q1;
    }

    public String getCabinType() {
        return cabinType;
    }

    public void setCabinType(String cabinType) {
        this.cabinType = cabinType;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }
}
