package com.driver;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@Component
public class StudentRepository {

    Map<String , Student> students              =   new HashMap<>();
    Map<String , Teacher> teachers              =   new HashMap<>();
    Map<Teacher , List<Student>> studentAndTeachers   =   new HashMap<>();

    public void addStudentInDB(Student student){
        students.put(student.getName() , student);
    }

    public void addTeachersInDB(Teacher teacher){
        teachers.put(teacher.getName() , teacher);
    }

    public void addStudentTeacherPair(String studentName , String teacherName){
        Student student = students.get(studentName);
        Teacher teacher = teachers.get(teacherName);

        List<Student> students  = studentAndTeachers.get(teacher) == null ? new ArrayList<>() : studentAndTeachers.get(teacher);

        if (!students.contains(student)){
            students.add(student);
        }
        studentAndTeachers.put(teacher ,  students);
    }

    public List<String> getStudents() {
        List<Student> allStudents  = new ArrayList<>(students.values());
        return getStudentsName(allStudents);
    }

    public List<Teacher> getTeachers() {
        return new ArrayList<>(teachers.values());
    }

    public Student getStudent(String name){
        return students.get(name);
    }

    public Teacher getTeacher(String name){
        return teachers.get(name);
    }

    public List<String> getStudentsByTeacher(String teacherName){
        Teacher teacher = teachers.get(teacherName);
        List<Student> allStudents =  studentAndTeachers.get(teacher);

        return getStudentsName(allStudents);
    }

    public void deleteTeachers(){
        List<Teacher> teachers = new ArrayList<>(studentAndTeachers.keySet());

        for (Teacher teacher : teachers){
            deleteTeacher(teacher.getName());
        }

        studentAndTeachers.clear();
    }

    public void deleteTeacher(String teacherName){
        Teacher teacher = getTeacher(teacherName);
        List<Student> students = studentAndTeachers.get(teacher);

        for (Student student : students){
            students.remove(student);
        }
        studentAndTeachers.remove(teacher);
    }

    public List<String> getStudentsName(List<Student> students){
        List<String> studentNames = new ArrayList<>();

        for (Student student : students){
            studentNames.add(student.getName());
        }

        return studentNames;
    }
}
