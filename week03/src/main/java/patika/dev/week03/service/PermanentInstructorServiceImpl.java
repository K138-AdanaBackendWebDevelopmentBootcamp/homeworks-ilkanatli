package patika.dev.week03.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import patika.dev.week03.dao.Interface.IInstructorDAO;
import patika.dev.week03.models.PermanentInstructor;
import patika.dev.week03.service.Interface.IInstructorService;

import java.util.List;
@Service
public class PermanentInstructorServiceImpl implements IInstructorService<PermanentInstructor> {

    IInstructorDAO iInstructorDAO;
    @Autowired
    public PermanentInstructorServiceImpl(@Qualifier("permanentInstructorDAOJPAImpl") IInstructorDAO iInstructorDAO) {
        this.iInstructorDAO = iInstructorDAO;
    }


    @Override
    public List<PermanentInstructor> findAll() {
        return null;
    }

    @Override
    public PermanentInstructor findById(int id) {
        return null;
    }

    @Override
    public PermanentInstructor save(PermanentInstructor instructor) {
        return (PermanentInstructor) iInstructorDAO.save(instructor);
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public PermanentInstructor uptadeOnDatabese(PermanentInstructor instructor) {
        return null;
    }
}