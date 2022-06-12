package pl.edu.pjatk.jaz.nbp.rates.models;

import pl.edu.pjatk.jaz.nbp.rates.types.Table;

import java.util.List;

public class Currency {
    private Table table;
    private String currency;
    private String code;
    private List<Rate> rates;

    public Currency(Table table, String currency, String code, List<Rate> rates) {
        this.table = table;
        this.currency = currency;
        this.code = code;
        this.rates = rates;
    }

    public Currency() {
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
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

    public List<Rate> getRates() {
        return rates;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }
}
