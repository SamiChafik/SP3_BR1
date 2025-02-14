package com.example.employeemanager.controller;


import com.example.employeemanager.dao.UserDAO;
import com.example.employeemanager.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/ReadUser")
public class ReadServlet extends HttpServlet {
    private UserDAO userDAO;

    @Override
    public void init() {
        userDAO = new UserDAO();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> personList = null;
        try {
            personList = userDAO.readUsers();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("personList", personList);
        request.getRequestDispatcher("liste.jsp").forward(request, response);
    }
}
