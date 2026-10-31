package com.sanjay.ecommorce.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class

OrderDTO {

    private Long id;

//    private int quantity;

    private double totalAmount;

    private String orderStatus;

    private Date orderDate;

    private String username;

    private String email;

    private List<OrderItemDTO> orderItemDtos;
//
//    public OrderDTO(Long id, double totalAmount, String orderStatus, Date orderDate, String username, String email, List<OrderItemDTO> orderItemDtos) {
//        this.id = id;
//        this.totalAmount = totalAmount;
//        this.orderStatus = orderStatus;
//        this.orderDate = orderDate;
//        this.username = username;
//        this.email = email;
//        this.orderItemDtos = orderItemDtos;
//
//    }

    public OrderDTO(Long id, double totalAmount, String orderStatus, Date orderDate, List<OrderItemDTO> orderItemDtos) {
        this.id = id;
        this.totalAmount = totalAmount;
        this.orderStatus = orderStatus;
        this.orderDate = orderDate;
        this.orderItemDtos = orderItemDtos;
    }
}
