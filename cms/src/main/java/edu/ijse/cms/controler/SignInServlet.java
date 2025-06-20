package edu.ijse.cms.controler;

import edu.ijse.cms.dto.UserDto;
import edu.ijse.cms.model.SignInModel;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/signin")
@MultipartConfig
public class SignInServlet extends HttpServlet {

    @Resource(name = "java:comp/env/jdbc/pool")
    DataSource dataSource;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userEmail = request.getParameter("userEmail");
        String userPassword = request.getParameter("userPassword");


        System.out.println("userEmail: " + userEmail);
        System.out.println("userPassword: " + userPassword);

        SignInModel signInModel = new SignInModel();


        Connection connection = null;
        try {


            connection = dataSource.getConnection();

            System.out.println("no problem");
            ResultSet rs = signInModel.userLogin(userEmail, connection);
            UserDto user = new UserDto();

            List<UserDto> userList = new ArrayList<>();

            while (rs.next()) {
                user.setUserId(rs.getString("id"));
                user.setUserName(rs.getString("user_name"));
                user.setUserEmail(rs.getString("user_email"));
                user.setUserRoll(rs.getString("user_roll"));
                user.setPassword(rs.getString("password"));
            }

            System.out.println("no problem..............");

            System.out.println(user.getUserEmail());
            System.out.println(user.getUserName());
            System.out.println(user.getUserRoll());


        if (user.getPassword().equals(userPassword)) {
            System.out.println("login successful");

            if ("admin".equals(user.getUserRoll())) {
                System.out.println("admin dashboard .......");
            } else {
                System.out.println("another dashboard .......");
            }
        } else {
            System.out.println("Incorrect password");
        }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
