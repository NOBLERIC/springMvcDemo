package com.noble.springmvcdemo.repository;

import com.noble.springmvcdemo.repository.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This is an interface for accessing built-in operations including CRUD
 */

@Repository
//Student is a model class name
//String is a data type of model class primary key
public interface StudentRepository extends JpaRepository<Student,String> {
}
