package com.example.quiz2.Service;

import com.example.quiz2.Model.Teacher;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Data
@AllArgsConstructor
@Service
public class TeacherService {
    private ArrayList<Teacher> Teachers = new ArrayList<>();

    public ArrayList<Teacher> getTeachers(){
        return Teachers;
    }

    public void addTeachers(Teacher Teacher){
        Teachers.add(Teacher);
    }

    public boolean updateTeachers(int id, Teacher Teacher){
        for (int i=0;i<Teachers.size();i++){
            if (Teachers.get(i).getId() == id){
                Teachers.set(i,Teacher);
                return true;
            }
        }
        return false;
    }

    public boolean deleteTeachers(int id){
        for (int i=0;i<Teachers.size();i++){
            if (Teachers.get(i).getId() == id){
                Teachers.remove(i);
                return true;
            }
        }
        return false;
    }

    public Teacher searchTeacher(int id){
        for (int i=0;i<Teachers.size();i++){
            if (Teachers.get(i).getId() == id){
                return Teachers.get(i);
            }
        }
        return null;
    }
}
