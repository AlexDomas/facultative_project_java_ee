package by.bntu.poisit.library_ee.service;

import by.bntu.poisit.library_ee.controller.SessionParamName;
import by.bntu.poisit.library_ee.dao.DaoException;
import by.bntu.poisit.library_ee.dao.DaoFactory;
import by.bntu.poisit.library_ee.dao.DaoFactory;
import by.bntu.poisit.library_ee.dao.impl.CourseDao;
import by.bntu.poisit.library_ee.dao.impl.JournalDao;
import by.bntu.poisit.library_ee.entity.Course;
import by.bntu.poisit.library_ee.entity.Journal;
import by.bntu.poisit.library_ee.entity.Login;

import java.util.List;

public class CourseService {

    private volatile static CourseService instance=null;

    private CourseService(){}

    public static CourseService getInstance(){
        if(instance == null){
            synchronized (CourseService.class) {
                if (instance == null) {
                    instance = new CourseService();
                }
            }
        }
        return instance;
    }

    public boolean subscribe(Integer courseId, Integer userId) throws ServiceException{
        boolean result=false;
        try {
            JournalDao dao = DaoFactory.getInstance().getJournalDao();
            Journal journal = new Journal();
            journal.setStudentId(userId);
            journal.setCourseId(courseId);
            dao.create(journal);
            result=true;
        }catch(DaoException e){

            throw new ServiceException(e.getMessage());
        }
        return result;
    }


    public boolean unSubscribe(Integer courseId, Integer userId) throws ServiceException{
        boolean result=false;
        try {

            JournalDao dao = DaoFactory.getInstance().getJournalDao();
            Journal journal = dao.findByCourseAndStudent(courseId, userId);
            if(journal==null){
                throw new ServiceException("Can't delete journal Object. Not found in DB");
            }else{
                dao.delete(journal.getId());
                result=true;
            }

        }catch(DaoException e){

            throw new ServiceException(e.getMessage());
        }
        return result;
    }


    public boolean addNewCourse(String name, Integer ownerId) throws ServiceException{
        boolean result=false;
        try {
            CourseDao dao = DaoFactory.getInstance().getCourseDao();

            if (dao.create(new Course(name, ownerId))) {
                result=true;
            }
        } catch (DaoException e) {

            throw new ServiceException(e.getMessage());
        }
        return result;
    }


    public Course getForEdit(Integer id) throws ServiceException{
        Course course=null;
        try {
            CourseDao dao = DaoFactory.getInstance().getCourseDao();
            course = dao.findEntityById(id);
        }catch(DaoException e){

            throw new ServiceException(e.getMessage());
        }
        return course;
    }


    public boolean deleteCourse(Integer id) throws ServiceException{
        boolean result=false;
        try {
            CourseDao dao = DaoFactory.getInstance().getCourseDao();
            dao.delete(new Integer(id));
            result=true;
        }catch(DaoException e){

            throw new ServiceException(e.getMessage());
        }
        return result;
    }


    public boolean updateCourse(Integer courseId, String courseName) throws ServiceException{
        boolean result=false;
        try{
            CourseDao dao = DaoFactory.getInstance().getCourseDao();
            Course course=dao.findEntityById(courseId);
            course.setName(courseName);
            dao.update(course);
            result=true;
        }catch (DaoException e){

            throw new ServiceException(e.getMessage());
        }
        return result;
    }

    public List<Course> getAll()throws ServiceException{
        List<Course> courses=null;
        try {
            CourseDao dao = DaoFactory.getInstance().getCourseDao();
            courses = dao.findAll();
        }catch(DaoException e){
            //logger.error(e.getMessage());
            throw new ServiceException(e.getMessage());
        }
        return courses;
    }
    public List<Course> getAllByIdTeacher(Integer teacherId)throws ServiceException{
        List<Course> courses=null;
        try {
            CourseDao dao = DaoFactory.getInstance().getCourseDao();
            courses = dao.findAllByIdTeacher(teacherId);
        }catch(DaoException e){
            //logger.error(e.getMessage());
            throw new ServiceException(e.getMessage());
        }
        return courses;
    }

    public List<Course> findAllBySubscribe(Integer userId)throws ServiceException{
        List<Course> courses = null;
        try {

            courses = DaoFactory.getInstance().getCourseDao().findAllBySubsctibe(userId);

        }catch (DaoException e){

            throw new ServiceException(e.getMessage());
        }

        return courses;
    }

    public List<Course> findAllBySubscribeStudent(Integer userId)throws ServiceException{
        List<Course> courses = null;
        try {

            courses = DaoFactory.getInstance().getCourseDao().findAllBySubsctibeStudent(userId);

        }catch (DaoException e){

            throw new ServiceException(e.getMessage());
        }

        return courses;
    }
}


