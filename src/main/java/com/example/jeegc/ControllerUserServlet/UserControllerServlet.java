package com.example.jeegc.ControllerUserServlet;

import com.example.jeegc.DAO.InterfaceUserDAO;
import com.example.jeegc.DAO.UserDAO;
import com.example.jeegc.Module.User;
import com.example.jeegc.Module.UserModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "cs", value = "*.php")
public class UserControllerServlet extends HttpServlet {

    private InterfaceUserDAO metier;

    @Override
    public void init() {
        metier = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String path = req.getServletPath();
        if(path.equals("/cherche.php")) {
            String ville = req.getParameter("ville");
            UserModel userModel = new UserModel();
            userModel.setVille(ville);
            List<User> users = metier.usersParVille("%"+ville+"%");
            userModel.setUsers(users);
            req.setAttribute("userModel", userModel);
            req.getRequestDispatcher("users.jsp").forward(req, resp);
        }
    }
}
