package edu.ijse.cms.model;

import edu.ijse.cms.dto.ComplainDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDashBordModel {
    public boolean addComplaint(ComplainDTO complainDTO, Connection connection) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO complain (user_name, user_email, subject, message) VALUES (?, ?, ?, ?)");
        preparedStatement.setString(1,complainDTO.getUserName());
        preparedStatement.setString(2,complainDTO.getUserEmail());
        preparedStatement.setString(3,complainDTO.getSubject());
        preparedStatement.setString(4,complainDTO.getMessage());
        int i = preparedStatement.executeUpdate();

        return i > 0;
    }
}
