package hello.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "surveys")
public class Surveys {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Month")
    private Integer month;

    @Column(name = "Year")
    private Integer year;


    @ManyToOne
    @JoinColumn(name = "DepartureairportID", referencedColumnName = "ID")
    private Airports departureAirport;

    @ManyToOne
    @JoinColumn(name = "ArrivalairportID", referencedColumnName = "ID")
    private Airports arrivalAirport;

    @Column(name = "Age")
    private Integer age;

    @Column(name = "Gender", length = 1)
    private Boolean gender;

    @ManyToOne
    @JoinColumn(name = "CabinType", referencedColumnName = "id")
    private CabinTypes cabinType;

    @Column(name = "Q1")
    private Integer q1;

    @Column(name = "Q2")
    private Integer q2;

    @Column(name = "Q3")
    private Integer q3;

    @Column(name = "Q4")
    private Integer q4;

    public Surveys(Integer month, Integer year, Airports departureAirport, Airports arrivalAirport, Integer age, Boolean gender, CabinTypes cabinType, Integer q1, Integer q2, Integer q3, Integer q4) {
        this.month = month;
        this.year = year;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.age = age;
        this.gender = gender;
        this.cabinType = cabinType;
        this.q1 = q1;
        this.q2 = q2;
        this.q3 = q3;
        this.q4 = q4;
    }

    public Integer getYear() {
        return year;
    }

    public Surveys setYear(Integer year) {
        this.year = year;
        return this;
    }

    public Surveys() {
    }

    public Integer getMonth() {
        return month;
    }

    public Surveys setMonth(Integer month) {
        this.month = month;
        return this;
    }

    public int getId() {
        return id;
    }

    public Airports getDepartureAirport() {
        return departureAirport;
    }

    public Surveys setDepartureAirport(Airports departureAirport) {
        this.departureAirport = departureAirport;
        return this;
    }

    public Airports getArrivalAirport() {
        return arrivalAirport;
    }

    public Surveys setArrivalAirport(Airports arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public Surveys setAge(Integer age) {
        this.age = age;
        return this;
    }

    public Boolean getGender() {
        return gender;
    }

    public Surveys setGender(Boolean gender) {
        this.gender = gender;
        return this;
    }

    public CabinTypes getCabinType() {
        return cabinType;
    }

    public Surveys setCabinType(CabinTypes cabinType) {
        this.cabinType = cabinType;
        return this;
    }

    public Integer getQ1() {
        return q1;
    }

    public Surveys setQ1(Integer q1) {
        this.q1 = q1;
        return this;
    }

    public Integer getQ2() {
        return q2;
    }

    public Surveys setQ2(Integer q2) {
        this.q2 = q2;
        return this;
    }

    public Integer getQ3() {
        return q3;
    }

    public Surveys setQ3(Integer q3) {
        this.q3 = q3;
        return this;
    }

    public Integer getQ4() {
        return q4;
    }

    public Surveys setQ4(Integer q4) {
        this.q4 = q4;
        return this;
    }
}