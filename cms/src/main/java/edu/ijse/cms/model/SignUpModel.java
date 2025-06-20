package edu.ijse.cms.model;

import edu.ijse.cms.dto.UserDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SignUpModel {
    public boolean saveUser(Connection connection , UserDto userDto) throws SQLException {

        String userId =  userDto.getUserId();
        String userName =  userDto.getUserName();
        String userEmail =   userDto.getUserEmail();
        String userRoll =   userDto.getUserRoll();
        String password =  userDto.getPassword();
        String confirmPassword =   userDto.getConfirmPassword();

        int i = 0;

        if (password.equals(confirmPassword)) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users VALUES (?, ?, ?, ?, ?)");
            preparedStatement.setString(1, userId);
            preparedStatement.setString(2, userName);
            preparedStatement.setString(3, userEmail);
            preparedStatement.setString(4, userRoll);
            preparedStatement.setString(5, password);

                i = preparedStatement.executeUpdate();

        }

        return i>0;
    }
}
