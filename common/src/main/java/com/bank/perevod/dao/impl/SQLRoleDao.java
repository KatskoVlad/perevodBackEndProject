package com.bank.perevod.dao.impl;

import com.bank.perevod.dao.RoleDao;
import com.bank.perevod.dao.connection_pool.ConnectionPool;
import com.bank.perevod.dao.connection_pool.ConnectionPoolException;
import com.bank.perevod.domain.to.Role;
import com.bank.perevod.exception.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class SQLRoleDao implements RoleDao {

    private static final String SELECT_ALL_ROLE = "SELECT * FROM role";
    private static final String SELECT_BY_ID_ROLE = "SELECT * FROM role WHERE id_role = ?";
    private static final String SELECT_BY_NAME_ROLE = "SELECT id_role, role FROM role WHERE role = ?";
    private static final String DELETE_ROLE = "DELETE FROM role WHERE id_role = ?";
    private static final String INSERT_ROLE = "INSERT INTO role (id_role, role) VALUES (?, ?)";
    private static final String UPDATE_ROLE = "UPDATE role SET role=? WHERE id_role=?";
    private static final String LAST_INSERT_ID = "SELECT last_insert_id() as lastId FROM role";
    private static final String LAST_ID = "lastId";
    private static final String ROLE_ID = "id_role";
    private static final String ROLE_NAME = "role";

    private static final ConnectionPool pool = ConnectionPool.getInstance();


    public static RoleDao getInstance() {
        return SingletonHolder.instance;
    }

    private static class SingletonHolder {
        private static final RoleDao instance = new SQLRoleDao();
    }

    @Override
    public boolean delete(Integer role_Id) throws DaoException {
        try (Connection connect = pool.getConnection();
             PreparedStatement statement = connect.prepareStatement(DELETE_ROLE)) {
            statement.setInt(1, role_Id);
            statement.executeUpdate();
            return true;
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
    }
    @Override
    public Integer getUserRole(Role roleName) throws DaoException {
        try(Connection connect = pool.getConnection();
            PreparedStatement statement = connect.prepareStatement(SELECT_BY_NAME_ROLE)) {

            statement.setString(1, roleName.getRoleName());

            ResultSet set = statement.executeQuery();
            Role role = new Role();
            while(set.next()){
                role.setRoleId(set.getInt(ROLE_ID));
                role.setRoleName(set.getString(ROLE_NAME));
            }
            return role.getRoleId();
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception error - role name", e);
        }
    }

    @Override
    public List<Role> findAll() throws DaoException {
        List<Role> roleList = new ArrayList<>();

        try(Connection connection = pool.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_ROLE)) {
                ResultSet resultSet = statement.executeQuery();
                while(resultSet.next()) {
                    Role roleInstance = new Role();

                    roleInstance.setRoleId(resultSet.getInt(SELECT_BY_ID_ROLE));
                    roleInstance.setRoleName(resultSet.getString(SELECT_BY_NAME_ROLE));
                    roleList.add(roleInstance);
                }
        }catch (SQLException  e){
            Logger.getGlobal();
            throw new DaoException("SQL Error - Role");
        } catch (ConnectionPoolException e) {
            Logger.getGlobal();
            e.printStackTrace();
        }
        return roleList;
    }

    @Override
    public Role findById(Integer id) throws DaoException {
        try(Connection connect = pool.getConnection();
            PreparedStatement statement = connect.prepareStatement(SELECT_BY_ID_ROLE)) {
            statement.setInt(1, id);
            ResultSet set = statement.executeQuery();
            if(set.next()){
               Role role = new Role();
               role.setRoleId(set.getInt(ROLE_ID));
               role.setRoleName(set.getString(ROLE_NAME));
               return role;
            } else {
               return null;
            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
    }

    @Override
    public int create(Role newRole) throws DaoException {
        try(Connection connect = pool.getConnection();
            PreparedStatement statement = connect.prepareStatement(INSERT_ROLE);
            PreparedStatement statementTwo = connect.prepareStatement(LAST_INSERT_ID)) {
            statement.setInt(1, newRole.getRoleId());
            statement.setString(2, newRole.getRoleName());

            statement.executeUpdate();

            ResultSet set = statementTwo.executeQuery();
            set.next();
            return set.getInt(LAST_ID);
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
    }

    @Override
    public Integer update(Role updateRole) throws DaoException {
        try(Connection connect = pool.getConnection();
            PreparedStatement statement = connect.prepareStatement(UPDATE_ROLE)) {
            statement.setInt(2, updateRole.getRoleId());
            statement.setString(1, updateRole.getRoleName());
            statement.executeUpdate();
            return updateRole.getRoleId();

        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException("Exception", e);
        }
    }
}
