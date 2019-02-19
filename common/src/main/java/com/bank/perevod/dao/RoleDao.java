package com.bank.perevod.dao;

import com.bank.perevod.domain.to.Role;
import com.bank.perevod.exception.DaoException;

import java.util.List;

public interface RoleDao extends GenericDAO <Role, Integer>{

    Integer getUserRole(Role roleName) throws DaoException;

}
