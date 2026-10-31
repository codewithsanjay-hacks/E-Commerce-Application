package com.sanjay.ecommorce.repository;

import com.sanjay.ecommorce.dto.OrderDTO;
import com.sanjay.ecommorce.entity.Orders;
import com.sanjay.ecommorce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrderRepository extends JpaRepository<Orders,Long> {


    @Query("SELECT o FROM Orders o JOIN FETCH o.user")
    List<Orders>  findByOrdersWithUser();

    List<Orders> findByUser(User user);
}
