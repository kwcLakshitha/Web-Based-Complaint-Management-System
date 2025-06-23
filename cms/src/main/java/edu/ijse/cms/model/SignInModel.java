package edu.ijse.cms.model;

import edu.ijse.cms.dto.UserDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SignInModel {
    public ResultSet userLogin(String userEmail, Connection connection) throws SQLException {

        System.out.println("signInModel.userLogin");
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE user_email=?");
        preparedStatement.setString(1, userEmail);
        ResultSet resultSet = preparedStatement.executeQuery();

//        System.out.println("query no problem");
//        UserDto userDto = new UserDto(resultSet.getString("id"), resultSet.getString("user_name"),
//                resultSet.getString("user_email"), resultSet.getString("user_roll"),
//                resultSet.getString("password"), resultSet.getString("password"));

        System.out.println("set data in dto");
        return resultSet  ;
    }

    public ResultSet getUser(String userName, Connection connection) throws SQLException {

        System.out.println("signInModel.userLogin");
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE user_name=?");
        preparedStatement.setString(1, userName);
        ResultSet resultSet = preparedStatement.executeQuery();

//        System.out.println("query no problem");
//        UserDto userDto = new UserDto(resultSet.getString("id"), resultSet.getString("user_name"),
//                resultSet.getString("user_email"), resultSet.getString("user_roll"),
//                resultSet.getString("password"), resultSet.getString("password"));

        System.out.println("set data in dto");
        return resultSet  ;
    }
}
