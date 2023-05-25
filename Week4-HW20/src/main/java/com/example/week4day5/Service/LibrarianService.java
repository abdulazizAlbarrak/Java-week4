package com.example.week4day5.Service;

import com.example.week4day5.ApiException.ApiException;
import com.example.week4day5.Model.Librarian;
import com.example.week4day5.Repository.LibrarianRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LibrarianService {
    private final LibrarianRepository librarianRepository;
    //CRUD Start
    public List<Librarian> getAll(){
        return librarianRepository.findAll();
    }
    public void addLibrarian(Librarian librarian){
        librarianRepository.save(librarian);
    }
    public void updateLibrarian(Integer id, Librarian librarian){
        Librarian old = librarianRepository.getLibrarianById(id);
        old.setEmail(librarian.getEmail());
        old.setName(librarian.getName());
        old.setPassword(librarian.getPassword());
        librarianRepository.save(old);
    }
    public void deleteLibrarian(Integer id){
        librarianRepository.delete(librarianRepository.getLibrarianById(id));
    }
    //CRUD finished
    public Librarian getLibrarianById(Integer id){
        return librarianRepository.getLibrarianById(id);
    }
    public void checkUserAndPass(String name,String password){
        Librarian check = librarianRepository.getLibrarianByName(name);
        if (!check.getPassword().equals(password))
            throw new ApiException("incorrect username or password");
    }
    public Librarian getByEmail(String email){
        return librarianRepository.getLibrarianByEmail(email);
    }
}
