package com.example.week4hw17.Service;

import com.example.week4hw17.Model.Users;
import com.example.week4hw17.Repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
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

    public boolean deleteCoffe(Integer id){
        if (usersRepository.getById(id) == null)
            return false;
        usersRepository.deleteById(id);
        return true;
    }
}
