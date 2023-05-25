package com.example.week5project.Service;

import com.example.week5project.Model.Director;
import com.example.week5project.Repository.DirectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DirectorService {
    private final DirectorRepository directorRepository;

    //CRUD Start
    public List<Director> getAll(){
        return directorRepository.findAll();
    }
    public void addDirector(Director director){
        directorRepository.save(director);
    }
    public void updateDirector(Integer id, Director director){
        Director old=directorRepository.getDirectorById(id);
        old.setName(director.getName());
        directorRepository.save(old);
    }
    public void deleteDirector(Integer id){
        directorRepository.delete(directorRepository.getDirectorById(id));
    }
    //End of CRUD
    public Director getDirectorById(Integer id){
        return directorRepository.getDirectorById(id);
    }
    public Director getDirectorByName(String name){
        return directorRepository.getDirectorByName(name);
    }
}
