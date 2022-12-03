package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Component
public class StudentService {

    @Autowired
    StudentRepository studentRepository ;

    public void addStudent(Student student){
        studentRepository.addStudentInDB(student);
    }

    public void addTeacher(Teacher teacher){
        studentRepository.addTeachersInDB(teacher);
    }

    public void addStudentTeacherPair(String studentName , String teacherName){
        studentRepository.addStudentTeacherPair(studentName , teacherName);
    }

    public List<String> getStudentsByTeacher(String teacherName){
        return studentRepository.getStudentsByTeacher(teacherName);
    }

    public Student getStudent(String name){
        return studentRepository.getStudent(name);
    }

    public Teacher getTeacher(String name){
        return studentRepository.getTeacher(name);
    }

    public void deleteTeacher(String teacherName){
        studentRepository.deleteTeacher(teacherName);
    }

    public List<String> getAllStudents(){
        return studentRepository.getStudents();
    }

    public void deleteAllTeachers(){
        studentRepository.deleteTeachers();
    }

}
