package dev.patika.week3.controllers.Interface;

import org.springframework.http.ResponseEntity;

public interface IInstructorController<Instructor> extends IBaseController<Instructor>{
    ResponseEntity<Instructor> getByPhoneNumber(long phone);
    ResponseEntity<String> deleteByPhoneNumber(long phone);
    ResponseEntity<Instructor> updateByPhoneNumber(Instructor instructor,long phone);
}