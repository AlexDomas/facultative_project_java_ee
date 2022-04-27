package by.bntu.poisit.library_ee.dao.interfaces;

import by.bntu.poisit.library_ee.dao.DaoException;
import by.bntu.poisit.library_ee.entity.Command;

import java.util.List;

/*
 Интерфейс для entity Command, к стандартным методам добавляем метод выбоки списка комнад доступные определенной
 группе пользователя, чтобы обрабатывать права доступа пользователей к различным командам
 */
public interface CommandDaoInterface extends AbstractEntityInterface<Integer, Command> {
    List<Command> findByRoleId(int roleId) throws DaoException;
}
