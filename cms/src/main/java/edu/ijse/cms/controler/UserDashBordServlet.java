package edu.ijse.cms.controler;

import edu.ijse.cms.model.SignInModel;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.dbcp2.BasicDataSource;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/userDashBord")
@MultipartConfig
public class UserDashBordServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String subject = req.getParameter("subject");
        String massage = req.getParameter("massage");

        System.out.println(subject + "  ....................");
        System.out.println(massage + "  ....................");

        SignInServlet signInServlet = new SignInServlet();
        String userEmail = signInServlet.getUserEmail();
        System.out.println("userEmail = " + userEmail);

//        try {
//            Connection connection = dataSource.getConnection();
//            SignInModel signInModel = new SignInModel();
//            signInModel.
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

    }
}
