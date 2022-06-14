package pl.edu.pjatk.jaz.nbp.rates.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
@ApiModel(value = "Query", description = "Query for average exchange rate of foreign currency for specific number of " +
        "days")
public class Query {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "The unique identifier of the query")
    private Long id;
    @ApiModelProperty(value = "Currency")
    private String currency;
    @ApiModelProperty(value = "Currency ISO Code")
    private String code;
    @ApiModelProperty(value = "Number of days to calculate the average echange rate")
    private Integer days;
    @ApiModelProperty(value = "Last day of the period to calculate the average echange rate")
    private String endDate;
    @ApiModelProperty(value = "First day of the period to calculate the average echange rate")
    private String startDate;
    @ApiModelProperty(value = "Calculated average exchange rate")
    private double mid;
    @ApiModelProperty(value = "Date and time of making query")
    private Timestamp timestamp;

    public Query(Long id, String currency, String code, Integer days, String endDate, String startDate, double mid,
                 Timestamp timestamp) {
        this.id = id;
        this.currency = currency;
        this.code = code;
        this.days = days;
        this.endDate = endDate;
        this.startDate = startDate;
        this.mid = mid;
        this.timestamp = timestamp;
    }

    public Query(String currency, String code, Integer days, String endDate, String startDate, double mid, Timestamp
            timestamp) {
        this.currency = currency;
        this.code = code;
        this.days = days;
        this.endDate = endDate;
        this.startDate = startDate;
        this.mid = mid;
        this.timestamp = timestamp;
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


