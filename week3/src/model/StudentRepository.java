package com.proje.repository.student;

import com.proje.model.entity.Student;
import com.proje.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student> {

}