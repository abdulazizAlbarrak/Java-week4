package com.example.week4hw17.Repository;

import com.example.week4hw17.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users,Integer> {

    Users findByUsernameAndPassword(String username, String password);
    Users findByEmail(String email);
    List<Users> findAllByRole(String role);
    List<Users> findAllByAgeGreaterThanEqual(Integer age);


}
