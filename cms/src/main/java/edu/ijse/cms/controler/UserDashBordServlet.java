package edu.ijse.cms.controler;

import edu.ijse.cms.dto.ComplainDTO;
import edu.ijse.cms.dto.UserDto;
import edu.ijse.cms.model.SignInModel;
import edu.ijse.cms.model.UserDashBordModel;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.NotNull;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/userDashBord")
@MultipartConfig
public class UserDashBordServlet extends HttpServlet {

    @Resource(name = "java:comp/env/jdbc/pool")
    DataSource dataSource;

    UserDashBordModel userDashBordModel = new UserDashBordModel();
    UserDto user = new UserDto();
    ComplainDTO complainDTO = new ComplainDTO();
    String currentUser;

    void setCurrentUser(String name) {
        currentUser = name;
    }

    @Override
    protected void doPost(@NotNull HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String subject = req.getParameter("subject");
        String massage = req.getParameter("massage");

        System.out.println(userName + "  ....................");
        System.out.println(subject + "  ....................");
        System.out.println(massage + "  ....................");


        try {

            Connection connection = dataSource.getConnection();
            SignInModel signInModel = new SignInModel();
            ResultSet rs = signInModel.getUser(userName, connection);


            List<UserDto> userList = new ArrayList<>();

            while (rs.next()) {
                user.setUserId(rs.getString("id"));
                user.setUserName(rs.getString("user_name"));
                user.setUserEmail(rs.getString("user_email"));
                user.setUserRoll(rs.getString("user_roll"));
                user.setPassword(rs.getString("password"));
            }

            if (userName.equals(user.getUserName())) {


                complainDTO.setUserName(userName);
                complainDTO.setUserEmail(user.getUserEmail());
                complainDTO.setSubject(subject);
                complainDTO.setMessage(massage);

                if (complainDTO.getSubject().equals("") || complainDTO.getMessage().equals("")) {
                    System.out.println("fill all fields");
                }

                else {

                    boolean result = userDashBordModel.addComplaint(complainDTO, connection);

                    if (result) {
                        System.out.println("Complaint added");
                    } else {
                        System.out.println("Complaint not added");
                    }

                }

                setCurrentUser(userName);
            } else {
                System.out.println("Username not matched");
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
