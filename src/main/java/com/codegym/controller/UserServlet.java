package com.codegym.controller;

import com.codegym.dao.UserDAO;
import com.codegym.model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = "/users")
public class UserServlet extends HttpServlet {
    private UserDAO userDAO;

    public void init() {
        userDAO = new UserDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "search":
                searchUserByCountry(request, response);
                break;
            case "sort":
                sortUserByName(request, response);
                break;
            default:
                listUser(request, response);
                break;
        }
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<User> listUser = userDAO.selectAllUsers();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
        dispatcher.forward(request, response);
    }

    private void searchUserByCountry(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String country = request.getParameter("country");
        List<User> listUser = userDAO.selectUsersByCountry(country);
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
        dispatcher.forward(request, response);
    }

    private void sortUserByName(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<User> listUser = userDAO.sortUsersByName();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
        dispatcher.forward(request, response);
    }
}