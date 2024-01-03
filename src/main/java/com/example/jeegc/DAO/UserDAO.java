package com.example.jeegc.DAO;

import com.example.jeegc.Module.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class UserDAO implements InterfaceUserDAO{
    static Connection connection = DataBaseConnection.getConnection();

    @Override
    public User save(User user)
    {
        try{
            String query = "INSERT INTO users (name, ville, age) VALUES (?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, user.getName());
            ps.setString(2, user.getVille());
            ps.setInt(3, user.getAge());
            ps.executeUpdate();

            String selectQuery = "SELECT MAX(id) AS MAX_ID FROM users";
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next())
            {
                user.setId(resultSet.getInt("MAX_ID"));
            }


        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public List<User> usersParVille(String ville) {
        List<User> users = new ArrayList<>();
        try{
            String query = "SELECT * FROM users WHERE ville LIKE ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, ville);
            ResultSet rs = ps.executeQuery();

            while(rs.next())
            {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setVille(rs.getString("ville"));
                user.setAge(rs.getInt("age"));
                users.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    @Override
    public User getUser(int id) {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public User delete(int id) {
        return null;
    }
}
