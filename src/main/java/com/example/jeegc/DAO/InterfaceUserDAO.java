package com.example.jeegc.DAO;

import com.example.jeegc.Module.User;

import java.sql.SQLException;
import java.util.List;

public interface InterfaceUserDAO {
    User save(User user);
    List<User> usersParVille(String ville);
    User getUser(int id);
    User update(User user);
    User delete(int id);
}
