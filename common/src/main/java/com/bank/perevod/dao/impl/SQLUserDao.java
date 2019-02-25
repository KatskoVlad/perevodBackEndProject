package com.bank.perevod.dao.impl;

import com.bank.perevod.dao.UserDao;
import com.bank.perevod.dao.connection_pool.ConnectionPool;
import com.bank.perevod.dao.connection_pool.ConnectionPoolException;
import com.bank.perevod.domain.to.User;
import com.bank.perevod.exception.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Logger;

public class SQLUserDao implements UserDao {

    private static final String SELECT_ALL = "SELECT * FROM users";
    private static final String SELECT_BY_ID = "SELECT * FROM users WHERE id_user = ?";
    private static final String SELECT_BY_USER_ID = "SELECT * FROM users JOIN role ON users.id_role=role.id_role";
    private static final String SELECT_BY_LOGIN_AND_PASSWORD = "SELECT * FROM users WHERE login = ? AND password = ?";
    private static final String DELETE_USER = "DELETE FROM users WHERE id_user = ?";
    private static final String INSERT_USER =
            "INSERT INTO users (login, password, name, date_registr, "+
            "is_bloked, id_role, sex, surname, email) "+
            "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_USER = "UPDATE users SET " +
            "login=?, password=?, name=?, id_role=?, date_registr=?, "+
            "is_bloked=?, sex=?, surname=?, email=? "+
            "WHERE id_user=?";
    private static final String LAST_INSERT_ID = "SELECT last_insert_id() as lastId FROM users";

    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String ID_USER = "id_user";
    private static final String NAME = "name";
    private static final String DATE_REGISTR = "date_registr";
    private static final String IS_BLOCK = "is_bloked";
    private static final String ID_ROLE = "id_role";
    private static final String SEX = "sex";
    private static final String SURNAME = "surname";
    private static final String EMAIL = "email";
    private static final String LAST_ID = "lastId";
    private static final ConnectionPool pool = ConnectionPool.getInstance();
    private static final String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
    public SQLUserDao() {
        super();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    @Override
    public User getUserNode(String login, String password) throws DaoException {
        try(Connection connect = pool.getConnection();
            PreparedStatement statement = connect.prepareStatement(SELECT_BY_LOGIN_AND_PASSWORD)) {
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet set = statement.executeQuery();

            if(set.next()) {
               User user = new User();
               user.setLogin(set.getString(LOGIN));
               user.setPassword(set.getString(PASSWORD));
               user.setIdUser(set.getInt(ID_USER));
               return user;
            } else {
               return null;
            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
    }

    @Override
    public boolean checkUser(String login, String password) throws DaoException {
        try(Connection connect = pool.getConnection();
            PreparedStatement statement = connect.prepareStatement(SELECT_BY_LOGIN_AND_PASSWORD)) {
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet set = statement.executeQuery();
            boolean userFound = set.next();
            if (!userFound){
                throw new DaoException("Вы не зарегистрированы! Зарегистрируйтесь!");
            }
            return userFound;
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception SQL, connect DataBase", e);
        }
    }
    @Override
    public User checkUserById(int id) throws DaoException {
            try(Connection connect = pool.getConnection();
                PreparedStatement statement = connect.prepareStatement(SELECT_BY_USER_ID)) {
                statement.setInt(1, id);
                ResultSet set = statement.executeQuery();
                if(set.next()){
                    User user = new User();
                    user.setIdUser(set.getInt(ID_USER));
                    user.setLogin(set.getString(LOGIN));
                    user.setPassword(set.getString(PASSWORD));
                    user.setEmail(set.getString(EMAIL));
                    user.setDateReg(set.getString(DATE_REGISTR));
                    user.setBloked(set.getBoolean(IS_BLOCK));
                    user.setIdRole(set.getInt(ID_ROLE));
                    return user;
                } else {
                    return null;
                }
            } catch (SQLException | ConnectionPoolException e) {
                throw new DaoException("Exception", e);
            }
    }

    @Override
    public List<User> findAll() throws DaoException {
            List<User> userList = new ArrayList<>();

            try(Connection connection = pool.getConnection();
                PreparedStatement statement = connection.prepareStatement(SELECT_ALL)) {
                ResultSet resultSet = statement.executeQuery();
                while(resultSet.next()) {
                    User user = new User();

                    user.setIdUser(resultSet.getInt(ID_USER));
                    user.setLogin(resultSet.getString(LOGIN));
                    user.setPassword(resultSet.getString(PASSWORD));
                    user.setEmail(resultSet.getString(EMAIL));
                    user.setDateReg(resultSet.getString(DATE_REGISTR));
                    user.setBloked(resultSet.getBoolean(IS_BLOCK));
                    user.setIdRole(resultSet.getInt(ID_ROLE));
                    userList.add(user);
                }
            }catch (SQLException  e){
                Logger.getGlobal();
                throw new DaoException("SQL Error - Role");
            } catch (ConnectionPoolException e) {
                Logger.getGlobal();
                e.printStackTrace();
            }
            return userList;

        }

    @Override
    public User findById(Integer id) throws DaoException {
        try(Connection connect = pool.getConnection();
            PreparedStatement statement = connect.prepareStatement(SELECT_BY_ID)) {
            statement.setLong(1, id);
            ResultSet set = statement.executeQuery();

            if(set.next()) {
                User user = new User();
                user.setLogin(set.getString(LOGIN));
                user.setPassword(set.getString(PASSWORD));
                user.setIdRole(set.getInt(ID_ROLE));
                return user;
            } else {
                return null;
            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
    }

    @Override
    public boolean delete(Integer id) throws DaoException {
        try (Connection connect = pool.getConnection();
             PreparedStatement statement = connect.prepareStatement(DELETE_USER)) {
            statement.setInt(1,  id);
            statement.executeUpdate();
            return true;
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
    }

    @Override
    public int create(User user) throws DaoException {

        try(Connection connect = pool.getConnection();
            PreparedStatement statement = connect.prepareStatement(INSERT_USER);
            PreparedStatement statementTwo = connect.prepareStatement(LAST_INSERT_ID)) {
            //statement.setInt(1, user.getIdUser());
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getName());
            statement.setString(4, timeStamp);
            statement.setBoolean(5, user.isBloked());
            statement.setInt(6, user.getIdRole());
            statement.setString(7,  user.getSex());
            statement.setString(8, user.getSurname());
            statement.setString(9, user.getEmail());

            statement.executeUpdate();

            ResultSet set = statementTwo.executeQuery();
            set.next();
            return set.getInt(LAST_ID);
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
    }

    @Override
    public Integer update(User userUpdate) throws DaoException {
        try(Connection connect = pool.getConnection();
            PreparedStatement statement = connect.prepareStatement(UPDATE_USER)) {
            statement.setString(1, userUpdate.getLogin());
            statement.setString(2, userUpdate.getPassword());
            statement.setString(3, userUpdate.getName());
            statement.setInt(4, userUpdate.getIdRole());
            statement.setString(5, userUpdate.getDateReg());
            statement.setBoolean(6, userUpdate.isBloked());
            statement.setString(7, userUpdate.getSex());
            statement.setString(8, userUpdate.getSurname());
            statement.setString(9, userUpdate.getEmail());
            statement.setInt(10, userUpdate.getIdUser());
            statement.executeUpdate();
            return userUpdate.getIdUser();

        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
    }

    @Override
    public void currentUser(String login, String password) throws DaoException {

        if (login.isEmpty() || password.isEmpty()) {
            throw new DaoException("Login and Password, not is empty!");
        }
        if (login.equals(password)) {
            throw new DaoException("Login and Password, must be different!");
        }
        if (login.length() < 4) {
            throw new DaoException("Login not valid, must be length min 8!");
        }
        if (password.length() < 8) {
            throw new DaoException("Password not valid, must be length min 8!");
        }

    }

    public static UserDao getInstance() {
        return SingletonHolder.instance;
    }

    private static class SingletonHolder {
        private static final UserDao instance = new SQLUserDao();
    }
}
//Demand Holder Idiom


