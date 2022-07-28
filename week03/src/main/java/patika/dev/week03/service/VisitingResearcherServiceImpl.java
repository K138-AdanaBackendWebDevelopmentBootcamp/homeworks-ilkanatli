package patika.dev.week03.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import patika.dev.week03.dao.Interface.IInstructorDAO;

import patika.dev.week03.models.VisitingResearcher;
import patika.dev.week03.service.Interface.IInstructorService;

import java.util.List;
@Service
public class VisitingResearcherServiceImpl implements IInstructorService<VisitingResearcher> {

    IInstructorDAO iInstructorDAO;
    @Autowired
    public VisitingResearcherServiceImpl(@Qualifier("visitingResearcherDAOJPAImpl") IInstructorDAO iInstructorDAO) {
        this.iInstructorDAO = iInstructorDAO;
    }


    @Override
    public List<VisitingResearcher> findAll() {
        return null;
    }

    @Override
    public VisitingResearcher findById(int id) {
        return null;
    }

    @Override
    public VisitingResearcher save(VisitingResearcher visitingResearcher) {
        return (VisitingResearcher) iInstructorDAO.save(visitingResearcher);
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public VisitingResearcher uptadeOnDatabese(VisitingResearcher object) {
        return null;
    }
}