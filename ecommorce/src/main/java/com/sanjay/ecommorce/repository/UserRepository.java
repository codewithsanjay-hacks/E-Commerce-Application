package com.sanjay.ecommorce.repository;

import com.sanjay.ecommorce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository  extends JpaRepository<User,Long> {

    User findByEmail(String email);
}
