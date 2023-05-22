package com.example.quiz2.Service;

import com.example.quiz2.Model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {
    private ArrayList<Student> students = new ArrayList<>();

    public ArrayList<Student> getStudents(){
        return students;
    }

    public void addStudents(Student student){
        students.add(student);
    }

    public boolean updateStudents(int id, Student student){
        for (int i=0;i<students.size();i++){
            if (students.get(i).getId() == id){
                students.set(i,student);
                return true;
            }
        }
        return false;
    }

    public boolean deleteStudents(int id){
        for (int i=0;i<students.size();i++){
            if (students.get(i).getId() == id){
                students.remove(i);
                return true;
            }
        }
        return false;
    }

    public Student searchStudent(String name){
        for (int i=0;i<students.size();i++){
            if (students.get(i).getName().equalsIgnoreCase(name)){
                return students.get(i);
            }
        }
        return null;
    }
}
