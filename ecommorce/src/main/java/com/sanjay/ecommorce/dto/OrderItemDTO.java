package com.sanjay.ecommorce.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
//@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDTO {


    private String productName;

    private double productPrice;

    private int quantities;



    //  private String productCategory;


    public OrderItemDTO(String productName, double productPrice, int quantities) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantities = quantities;
    }
}
