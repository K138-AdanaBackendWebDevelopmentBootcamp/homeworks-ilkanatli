package com.proje.repository.instructor;

import com.proje.model.entity.Instructor;
import com.proje.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends CrudRepository<Instructor> {
}