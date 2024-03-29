package dev.patika.week3.DAO.Interfaces;

public interface IInstructorDAO<Instructor> extends IBaseDAO<Instructor>{
    Instructor findByPhoneNumber(Long phone_number);

    void deleteByPhoneNumber(Long phone_number);
    Instructor updateByPhoneNumber(Instructor instructor, Long phone_number);
}
