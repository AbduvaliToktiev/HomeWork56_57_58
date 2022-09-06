package com.example.homework56_57_58.dao;

import com.example.homework56_57_58.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserRepository {

    @Autowired
    private DataSource dataSource;

    public void registrationUser(User user) {
        String SQL_REGISTRATION_USER = "insert into \"homework56-57-58\".users (fio, email, password) VALUES (?, ?, ?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_REGISTRATION_USER)) {

            preparedStatement.setString(1, user.getFio());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public User authorizationUser(String email, String password) {
        String SQL_USER_AUTHORIZATION = "select * from \"homework56-57-58\".users where email = ? and password = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_USER_AUTHORIZATION)) {

            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            preparedStatement.executeUpdate();

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    User user = new User();
                    user.setId(resultSet.getInt("ID"));
                    user.setFio(resultSet.getString("FIO"));
                    user.setEmail(resultSet.getString("EMAIL"));
                    user.setPassword(resultSet.getString("PASSWORD"));
                    return user;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return null;
    }
}
