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

@WebServlet("/UpdateUser")
public class UpdateServlet extends HttpServlet {
    private UserDAO userDAO;

    @Override
    public void init() {
        userDAO = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userDAO.getUserById(id);
        request.setAttribute("person", user);
        request.getRequestDispatcher("updatePersonForm.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        String numero = request.getParameter("numero");
        String poste = request.getParameter("poste");
        double salaire = Double.parseDouble(request.getParameter("salaire"));

        User user = new User(nom, prenom, email, numero, poste, salaire);
        user.setId(id);
        try {
            userDAO.createUser(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        response.sendRedirect("readPerson");
    }
}
