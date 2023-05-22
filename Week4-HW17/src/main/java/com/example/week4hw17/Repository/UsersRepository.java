package com.example.week4hw17.Repository;

import com.example.week4hw17.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users,Integer> {
}
