package io.github.jackson.test;

import java.io.Serializable;
import java.util.Date;

/**
 * Bar
 *
 * @author yakir on 2020/04/21 14:47.
 */
public class Bar implements Serializable {

    private static final long serialVersionUID = 3952915937636088052L;

    private Long   barId;
    private Date   barCdate;
    private String bar;

    public Long getBarId() {
        return barId;
    }

    public Bar setBarId(Long barId) {
        this.barId = barId;
        return this;
    }

    public Date getBarCdate() {
        return barCdate;
    }

    public Bar setBarCdate(Date barCdate) {
        this.barCdate = barCdate;
        return this;
    }

    public String getBar() {
        return bar;
    }

    public Bar setBar(String bar) {
        this.bar = bar;
        return this;
    }

    @Override
    public String toString() {
        return "Bar{" +
                "barId=" + barId +
                ", barCdate=" + barCdate +
                ", bar='" + bar + '\'' +
                '}';
    }
}
