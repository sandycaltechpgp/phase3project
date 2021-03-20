package com.ecommerce.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


public class ProductDTO {

    private BigInteger ID;
    private String name;
    private BigDecimal price;
    private Date dateAdded;
    private String category;

    public ProductDTO(BigInteger ID, String name, BigDecimal price, Date dateAdded, String category) {
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.dateAdded = dateAdded;
        this.category = category;
    }

    public BigInteger getID() {
        return this.ID;
    }

    public String getName() {
        return this.name;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public Date getDateAdded() {
        return this.dateAdded;
    }


    public void setID(BigInteger id) {
        this.ID = id;
    }

    public void setName(String value) {
        this.name = value;
    }

    public void setPrice(BigDecimal value) {
        this.price = value;
    }

    public void setDateAdded(Date date) {
        this.dateAdded = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
