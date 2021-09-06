package com.IgorT.Entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@EntityScan
@Entity
@Table(name="SafariCountries")
public class SafariCntry {

    @Id
    private String name;
    @Column
    private Integer ordNo;


    public SafariCntry(String name) {
        this.name = name;
    }

    public SafariCntry(String name, Integer ordNo) {
        this.name = name;
        this.ordNo = ordNo;
    }

    public SafariCntry() {
    }

    public Integer getOrdNo() {
        return ordNo;
    }

    public void setOrdNo(Integer ordNo) {
        this.ordNo = ordNo;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
