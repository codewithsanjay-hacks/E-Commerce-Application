package com.sanjay.ecommorce.service;

import com.sanjay.ecommorce.dto.OrderDTO;
import com.sanjay.ecommorce.dto.OrderItemDTO;
import com.sanjay.ecommorce.entity.OrderItem;
import com.sanjay.ecommorce.entity.Orders;
import com.sanjay.ecommorce.entity.Product;
import com.sanjay.ecommorce.entity.User;
import com.sanjay.ecommorce.repository.OrderRepository;
import com.sanjay.ecommorce.repository.ProductRepository;
import com.sanjay.ecommorce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class OrderService {

    // User repository
    @Autowired
    private UserRepository userRepository;

    // Product repository
    @Autowired
    private ProductRepository productRepository;

    // Order repository
    @Autowired
    private OrderRepository orderRepository;

    // Method to place order
    public OrderDTO placeOrder(Long userId, Map<Long, Integer> productQuantities, double totalAmount) {

        // Find user using userId
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        // Create new Order object
        Orders order = new Orders();

        // Set order details
        order.setUser(user);
        order.setOrderStatus("Pending");
        order.setOrderDate(new Date());
        System.out.println("Total Amount = " + totalAmount);

        order.setTotalAmount(totalAmount);

        // Store OrderItem entities
        List<OrderItem> orderItems = new ArrayList<>();

        // Store DTOs for response
        List<OrderItemDTO> orderItemdtos = new ArrayList<>();

        // Loop through all products
        for (Map.Entry<Long, Integer> entries : productQuantities.entrySet()) {

            // Find product by productId
            Product product = productRepository.findById(entries.getKey())
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            // Create one OrderItem for one product
            OrderItem orderItem = new OrderItem();

            // Link Order with OrderItem
            orderItem.setOrder(order);

            // Link Product with OrderItem
            orderItem.setProduct(product);

            // Set quantity
            orderItem.setQuantity(entries.getValue());

            // Add OrderItem to list
            orderItems.add(orderItem);

            // Create DTO and add to DTO list
             orderItemdtos.add(
                    new OrderItemDTO(
                            product.getProduct_name(),
                            product.getPrice(),
                            entries.getValue()
                    )
            );
        }

        // Attach all OrderItems to Order
        order.setOrderItems(orderItems);

        // Save Order (OrderItems also saved because of CascadeType.ALL)
        Orders saveOrder = orderRepository.save(order);

        // Return response to frontend
        return new OrderDTO(
                saveOrder.getId(),
                saveOrder.getTotalAmount(),
                saveOrder.getOrderStatus(),
                saveOrder.getOrderDate(),
                orderItemdtos
        );

    }

    public List<OrderDTO> getAllOrders(){
        List<Orders> byOrdersWithAllUser = orderRepository.findByOrdersWithUser();
        return byOrdersWithAllUser.stream().map(this::convertToDTO).toList();
    }

    private OrderDTO convertToDTO(Orders orders) {

        List<OrderItemDTO> collect = orders.getOrderItems().stream().map(item -> new OrderItemDTO(item.getProduct().getProduct_name(),
                item.getProduct().getPrice(),
                item.getQuantity())).collect(Collectors.toList());
         return new OrderDTO(
                 orders.getId(),
                 orders.getTotalAmount(),
                 orders.getOrderStatus()!=null?orders.getOrderStatus() : "Unknown",
                 orders.getOrderDate(),
                 orders.getUser()!=null?orders.getUser().getName():"Unknown",
                 orders.getUser()!=null?orders.getUser().getEmail():"Unknown",
                  collect

         );


    }

    public List<OrderDTO> getOrderByUser(Long userId){

        Optional<User> userOP = userRepository.findById(userId);

        if (userOP.isEmpty()){
            throw new RuntimeException("user not found");
        }
            User user = userOP.get();
         List<Orders> ordersList =   orderRepository.findByUser(user);

       return ordersList.stream().map(this::convertToDTO).collect(Collectors.toList());
      //return ordersList.stream().map(x->converToDTO(x)).collect(Collectors.toList());


        }


    }


