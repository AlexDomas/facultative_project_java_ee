package by.bntu.poisit.library_ee.dao.interfaces;

import by.bntu.poisit.library_ee.dao.DaoException;
import by.bntu.poisit.library_ee.entity.Course;

import java.util.List;

/*
Интерфейс для для Курсов, добавляем метод позволяющий получать список курсов на которые подписан определенный студент
 */
public interface CourseDaoInterface extends AbstractEntityInterface<Integer, Course> {
    List<Course> findAllBySubsctibe(Integer studentId) throws DaoException;
}

