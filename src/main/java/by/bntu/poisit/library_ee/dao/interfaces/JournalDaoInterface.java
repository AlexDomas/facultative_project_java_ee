package by.bntu.poisit.library_ee.dao.interfaces;

import by.bntu.poisit.library_ee.dao.DaoException;
import by.bntu.poisit.library_ee.entity.Journal;

import java.util.List;

/*
Интерфейс для журнала. Добавляет 2 метода.
- поиск в журнале записи о конкретном студенте конкретного курса. нужен для возможности отписки от курса
- поиск записией в журнале, чтобы получить список студентов подписанных на определенный курс, чтобы препод. мог проставлять
 */
public interface JournalDaoInterface extends AbstractEntityInterface<Integer, Journal> {
    Journal findByCourseAndStudent(Integer courseId, Integer studentId) throws DaoException;
    List<Journal> findByCourse(Integer course_id) throws DaoException;
}

