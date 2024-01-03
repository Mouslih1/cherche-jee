package com.example.jeegc.DAO;

import com.example.jeegc.Module.User;

import java.util.List;

public class TestDAO {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
        User user1 = userDAO.save(new User("amina", "khenifra", 19));
        User user2 = userDAO.save(new User("nour", "casablanca", 24));
        System.out.println(user1.toString());
        System.out.println(user2.toString());
        System.out.println("****************************************");
        List<User> users = userDAO.usersParVille("%casa%");

        for (User user : users)
        {
            System.out.println(user);
        }
    }
}
