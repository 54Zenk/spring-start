package ru.beeline.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String name;

    private Integer price;

    private Long instock;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "product")
    @JsonIgnore
    private List<Orderz> orders = new LinkedList<>();


    public List<Orderz> getOrders() {
        return orders;
    }

    public void setOrders(List<Orderz> orders) {
        this.orders = orders;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Long getInstock() {
        return instock;
    }

    public void setInstock(Long instock) {
        this.instock = instock;
    }

    public void buy(Long amount) { instock-=amount; }
}
