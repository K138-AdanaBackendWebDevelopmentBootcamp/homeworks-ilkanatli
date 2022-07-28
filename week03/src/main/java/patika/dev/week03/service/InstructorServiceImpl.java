package patika.dev.week03.service;


import patika.dev.week03.dao.Interface.IInstructorDAO;
import patika.dev.week03.models.Instructor;
import patika.dev.week03.service.Interface.IInstructorService;

import java.util.List;

public class InstructorServiceImpl implements IInstructorService<Instructor> {

    IInstructorDAO iInstructorDAO;

    public InstructorServiceImpl(IInstructorDAO iInstructorDAO) {
        this.iInstructorDAO = iInstructorDAO;
    }

    @Override
    public List<Instructor> findAll() {
        return null;
    }

    @Override
    public Instructor findById(int id) {
        return null;
    }

    @Override
    public Instructor save(Instructor instructor) {
        return (Instructor) iInstructorDAO.save(instructor);
    }

    @Override

    public void deleteById(int id) {

    }

    @Override
    public Instructor uptadeOnDatabese(Instructor instructor) {
        return null;
    }
}