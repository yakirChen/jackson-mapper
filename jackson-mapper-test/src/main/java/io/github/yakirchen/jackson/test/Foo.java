package io.github.yakirchen.jackson.test;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Foo
 *
 * @author yakir <a href="https://yakirchen.github.io">yakirchen.github.io</a> on 2018/10/12 23:06.
 */
class Foo
        implements Serializable {
    private Long          id;
    private LocalDateTime cdate;
    private List<String>  hobby;

    public Foo() {
    }

    public Foo(Long id,
               LocalDateTime cdate,
               List<String> hobby) {
        this.id = id;
        this.cdate = cdate;
        this.hobby = hobby;
    }

    public Long getId() {
        return id;
    }

    public Foo setId(Long id) {
        this.id = id;
        return this;
    }

    public LocalDateTime getCdate() {
        return cdate;
    }

    public Foo setCdate(LocalDateTime cdate) {
        this.cdate = cdate;
        return this;
    }

    public List<String> getHobby() {
        return hobby;
    }

    public Foo setHobby(List<String> hobby) {
        this.hobby = hobby;
        return this;
    }

    @Override
    public String toString() {
        return "Foo{" +
               "id=" + id +
               ", cdate=" + cdate +
               ", hobby=" + hobby +
               '}';
    }
}