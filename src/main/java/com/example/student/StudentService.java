package com.example.student;


import org.springframework.stereotype.Repository;
import org.vaadin.crudui.crud.CrudListener;

import java.util.List;

@Repository
public class StudentService implements CrudListener<Student> {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Student> findAll() {
        return repository.findAll();
    }

    @Override
    public Student add(Student student) {
        return repository.insert(student);
    }

    @Override
    public Student update(Student student) { return repository.insert(student); }

    @Override
    public void delete(Student student) {
        repository.delete(student);
        //repository.deleteAll();
    }
}