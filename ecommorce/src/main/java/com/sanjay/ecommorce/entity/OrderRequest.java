package com.sanjay.ecommorce.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;


@Getter
@Setter
public class OrderRequest {


    //key is product id
    // value is quantity
    Map<Long,Integer> productQuantities;

    private double totalAmount;


}
