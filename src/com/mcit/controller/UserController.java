package com.mcit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mcit.entities.User;
import com.mcit.jdbc.UserDao;

@WebServlet("/user-controller")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entrando no doPost() de User");
		PrintWriter writer = response.getWriter();
		
		String name = request.getParameter("txtname");
		String pass1 = request.getParameter("txtpassword");
		String pass2 = request.getParameter("txtpassword-again");
		
		
		if(!pass1.equals(pass2)) {
			writer.println("Password not match!");
		}
		
		User user = new User(name, pass1);
		UserDao userDao = new UserDao();
		userDao.save(user);
		writer.println("Saved!");
	}

}
