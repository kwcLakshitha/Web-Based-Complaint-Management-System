package edu.ijse.cms.controler;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.ijse.cms.dto.UserDto;
import edu.ijse.cms.model.SignUpModel;
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

        UserDto user = new UserDto();

        user.setUserId(req.getParameter("userId"));
        user.setUserName(req.getParameter("userName"));
        user.setUserEmail(req.getParameter("userEmail"));
        user.setUserRoll(req.getParameter("userRoll"));
        user.setPassword(req.getParameter("password"));
        user.setConfirmPassword(req.getParameter("confirmPassword"));
        boolean result = false;
        if (req.getParameter("password").equals(req.getParameter("confirmPassword"))) {

            Connection connection = null;
            try {
                connection = dataSource.getConnection();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            SignUpModel signUpModel = new  SignUpModel();
            try {
                result = signUpModel.saveUser(connection,user);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            PrintWriter out = resp.getWriter();
            if (result) {
                out.print("Success");
                resp.setStatus(HttpServletResponse.SC_OK);
                resp.sendRedirect("addComplaint.jsp");
                req.setAttribute("message", "User registered successfully!");
                System.out.println("Added successfully");
            } else {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                req.setAttribute("message", "Failed to register user.");
                System.out.println("Failed to added ");
            }

        }
        else {
            System.out.println("Invalid password");
        }

    }
}
