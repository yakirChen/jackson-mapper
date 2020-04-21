package io.github.jackson.test;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Foo
 *
 * @author yakir <a href="https://yakirchen.github.io">yakirchen.github.io</a> on 2018/10/12 23:06.
 */
class Foo implements Serializable {

    private static final long serialVersionUID = -5535486419876844208L;

    private Long          fooId;
    private LocalDateTime fooCdate;
    private List<String>  hobby;
    private Bar           bar;

    public Foo() {
    }

    public Foo(Long fooId, LocalDateTime fooCdate, List<String> hobby, Bar bar) {
        this.fooId    = fooId;
        this.fooCdate = fooCdate;
        this.hobby    = hobby;
        this.bar      = bar;
    }

    public Long getFooId() {
        return fooId;
    }

    public Foo setFooId(Long fooId) {
        this.fooId = fooId;
        return this;
    }

    public LocalDateTime getFooCdate() {
        return fooCdate;
    }

    public Foo setFooCdate(LocalDateTime fooCdate) {
        this.fooCdate = fooCdate;
        return this;
    }

    public List<String> getHobby() {
        return hobby;
    }

    public Foo setHobby(List<String> hobby) {
        this.hobby = hobby;
        return this;
    }

    public Bar getBar() {
        return bar;
    }

    public Foo setBar(Bar bar) {
        this.bar = bar;
        return this;
    }

    @Override
    public String toString() {
        return "Foo{" +
                "fooId=" + fooId +
                ", fooCdate=" + fooCdate +
                ", hobby=" + hobby +
                ", bar=" + bar +
                '}';
    }
}