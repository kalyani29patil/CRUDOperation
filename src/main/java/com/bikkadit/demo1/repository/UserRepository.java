package com.bikkadit.demo1.repository;

import com.bikkadit.demo1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
