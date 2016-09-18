package com.no0ker.model;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "things",
        uniqueConstraints = @UniqueConstraint(columnNames = {"value1", "value2"}))
public class Thing {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "value1", nullable = false)
    private String value1;

    @Column(name = "value2", nullable = false)
    private BigInteger value2;

    public Thing() {
    }

    public Thing(String value1, BigInteger value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public BigInteger getValue2() {
        return value2;
    }

    public void setValue2(BigInteger value2) {
        this.value2 = value2;
    }
}
