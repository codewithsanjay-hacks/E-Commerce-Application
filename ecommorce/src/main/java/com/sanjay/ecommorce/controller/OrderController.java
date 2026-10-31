package com.sanjay.ecommorce.controller;


import com.sanjay.ecommorce.dto.OrderDTO;
import com.sanjay.ecommorce.entity.OrderRequest;
import com.sanjay.ecommorce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@CrossOrigin("*")
public class OrderController {

     @Autowired
     OrderService orderService;


     @PostMapping("/place/{userId}")
     public OrderDTO placeOrder(@PathVariable Long userId , @RequestBody OrderRequest orderRequest){
        return  orderService.placeOrder(userId,orderRequest.getProductQuantities(),orderRequest.getTotalAmount());
    }

    @GetMapping("/all-order")
    public List<OrderDTO> getAllOrders(){
     return orderService.getAllOrders();

    }

     @GetMapping("/user/{userId}")
    public List<OrderDTO> getOrderByUser(@PathVariable Long userId){
        return orderService.getOrderByUser(userId);
    }
}
