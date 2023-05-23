package com.example.week4hw17.Service;

import com.example.week4hw17.Model.Users;
import com.example.week4hw17.Repository.UsersRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Data
public class UsersService {
    private final UsersRepository usersRepository;

    public List<Users> getUsers(){
        return usersRepository.findAll();
    }

    public void addUsers(Users users){
        usersRepository.save(users);
    }
    public boolean updateUsers(Integer id , Users Users){
        Users old = usersRepository.getById(id);
        if(old == null)
            return false;
        old.setAge(Users.getAge());
        old.setName(Users.getName());
        old.setRole(Users.getRole());
        old.setEmail(Users.getEmail());
        old.setUsername(Users.getUsername());
        old.setPassword(Users.getPassword());

        usersRepository.save(old);
        return true;
    }

    public boolean deleteUsers(Integer id){
        if (usersRepository.getById(id) == null)
            return false;
        usersRepository.deleteById(id);
        return true;
    }

    public boolean checkUsernameAndPassword(String username, String password){
        Users users = usersRepository.findByUsernameAndPassword(username,password);
        if (users.getPassword().equalsIgnoreCase(password))
            return true;
        else return false;
    }

    public Users getUserByEmail(String email){
        return usersRepository.findByEmail(email);
    }

    public List<Users> getAllByRole(String role){
        return usersRepository.findAllByRole(role);
    }

    public List<Users> getAllByAge(Integer age){
        return usersRepository.findAllByAgeGreaterThanEqual(age);
    }
}
