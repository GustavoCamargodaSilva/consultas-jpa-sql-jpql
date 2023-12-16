package com.devsuperior.uri2621.dto;

import com.devsuperior.uri2621.projections.ProductMinProjections;

public class ProductMinDTO {

    private String name;

    public ProductMinDTO(){}

    public ProductMinDTO(String name) {
        this.name = name;
    }

    public ProductMinDTO(ProductMinProjections projections){
        name = projections.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ProductMinDTO{" +
                "name='" + name + '\'' +
                '}';
    }
}
