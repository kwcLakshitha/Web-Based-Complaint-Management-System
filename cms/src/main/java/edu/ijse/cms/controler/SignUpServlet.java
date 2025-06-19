package edu.ijse.cms.controler;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.dbcp2.BasicDataSource;
import org.jetbrains.annotations.NotNull;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

@WebServlet("/signup")
@MultipartConfig
public class SignUpServlet extends HttpServlet {

    @Resource(name = "java:comp/env/jdbc/pool")
    DataSource dataSource;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("SignUpServlet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        ObjectMapper mapper = new ObjectMapper();
//        Map <String , String> map = mapper.readValue(req.getInputStream(), Map.class);

        String userId = req.getParameter("userId");
        String userName = req.getParameter("userName");
        String userEmail = req.getParameter("userEmail");
        String userRoll = req.getParameter("userRoll");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");

        System.out.println(userName + "\n" + userEmail + "\n" + userRoll + "\n" + password + "\n" + confirmPassword);

        try {
            Connection connection = dataSource.getConnection();

            int i = 0;

            if (password.equals(confirmPassword)) {
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users VALUES (?, ?, ?, ?, ?)");
                preparedStatement.setString(1, userId);
                preparedStatement.setString(2, userName);
                preparedStatement.setString(3, userEmail);
                preparedStatement.setString(4, userRoll);
                preparedStatement.setString(5, password);

                if (password.equals(confirmPassword)) {
                    i = preparedStatement.executeUpdate();
                }

                else {
                    System.out.println("invalid password");
                }

            }

            if(i>0) {
                System.out.println("added successfully");
            } else {
                System.out.println("failed");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
