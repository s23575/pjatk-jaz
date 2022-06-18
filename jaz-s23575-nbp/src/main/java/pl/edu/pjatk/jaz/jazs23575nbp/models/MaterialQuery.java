package pl.edu.pjatk.jaz.jazs23575nbp.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pl.edu.pjatk.jaz.jazs23575nbp.types.Material;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "query")
@ApiModel(value = "Material Query", description = "Query for average value of gold for specific period")
public class MaterialQuery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "The unique identifier of the query")
    private Long id;
    @Enumerated(EnumType.STRING)
    @ApiModelProperty(value = "Material")
    private Material material;
    @ApiModelProperty(value = "First day of the period to calculate the average value")
    private String startDate;
    @ApiModelProperty(value = "Last day of the period to calculate the average value")
    private String endDate;
    @ApiModelProperty(value = "Calculated average value")
    private double mid;
    @ApiModelProperty(value = "Date and time of making query")
    private Timestamp timestamp;

    public MaterialQuery(Long id, Material material, String startDate, String endDate, double mid, Timestamp timestamp) {
        this.id = id;
        this.material = material;
        this.startDate = startDate;
        this.endDate = endDate;
        this.mid = mid;
        this.timestamp = timestamp;
    }

    public MaterialQuery(Material material, String startDate, String endDate, double mid, Timestamp timestamp) {
        this.material = material;
        this.startDate = startDate;
        this.endDate = endDate;
        this.mid = mid;
        this.timestamp = timestamp;
    }

    public MaterialQuery() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
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
