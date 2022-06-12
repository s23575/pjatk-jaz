package pl.edu.pjatk.jaz.nbp.rates.models;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Query {
    private Long id;
    private String currency;
    private String code;
    private String startDate;
    private String endDate;
    private Integer days;
    private double mid;
    private Timestamp timestamp;

    public Query(Long id, String currency, String code, String startDate, String endDate, double mid) {
        this.id = id;
        this.currency = currency;
        this.code = code;
        this.startDate = startDate;
        this.endDate = endDate;
        this.days = (int) ChronoUnit.DAYS.between(LocalDate.parse(startDate), LocalDate.parse(endDate));
        this.mid = mid;
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }

    public Query() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public double getMid() {
        return mid;
    }

    public void setMid(double mid) {
        this.mid = mid;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}


