/*
 * Copyright (c) 2021.
 */

package com.geroimzx.market.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class Product {
    @Id
    private String id;

    private String name;
    private String price;
    private String type;

    public Product() {
    }

    public Product(String id, String name, String price, String type) {
        this.setId(id);
        this.setName(name);
        this.setPrice(price);
        this.setType(type);
    }

    public Product(String name, String price, String type) {
        this.setName(name);
        this.setPrice(price);
        this.setType(type);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return getId().equals(product.getId()) && getName().equals(product.getName()) && getPrice().equals(product.getPrice()) && getType().equals(product.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getPrice(), getType());
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
