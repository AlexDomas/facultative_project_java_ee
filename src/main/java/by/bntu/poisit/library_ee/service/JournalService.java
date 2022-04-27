package by.bntu.poisit.library_ee.service;

import by.bntu.poisit.library_ee.dao.DaoException;
import by.bntu.poisit.library_ee.dao.DaoFactory;
import by.bntu.poisit.library_ee.dao.impl.JournalDao;
import by.bntu.poisit.library_ee.entity.Journal;

import java.util.List;


public class JournalService {

    private volatile static JournalService instance=null;
    private JournalService(){}

    public static JournalService getInstance(){
        if(instance==null){
            synchronized (JournalService.class) {
                if (instance == null) {
                    instance = new JournalService();
                }
            }
        }
        return instance;
    }

    public Journal findById(Integer id)throws ServiceException{
        Journal journal = null;
        try {
            JournalDao jd = DaoFactory.getInstance().getJournalDao();
            journal=jd.findEntityById(id);
        }catch (DaoException exc){

            throw new ServiceException(exc.getMessage());
        }
        return journal;
    }

    public void setMark(Integer itemId, Integer mark, String note) throws ServiceException{
        try {
            JournalDao jd = DaoFactory.getInstance().getJournalDao();
            Journal journal = jd.findEntityById(itemId);
            journal.setNote(note);
            journal.setMark(mark);
            jd.update(journal);
        }catch (DaoException exc){

            throw new ServiceException(exc.getMessage());
        }
    }

    public List<Journal> getStudentsList(Integer courseId) throws ServiceException{
        List<Journal> students=null;
        try {
            JournalDao jd = DaoFactory.getInstance().getJournalDao();
            students = jd.findByCourse(courseId);
        }catch (DaoException exc){

            throw new ServiceException(exc.getMessage());
        }
        return students;
    }
}
