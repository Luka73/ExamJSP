package com.mcit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mcit.entities.Patient;
import com.mcit.jdbc.PatientDao;


@WebServlet("/patient-controller")
public class PatientController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public PatientController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entrando no doGet() de Patient");
		List<Patient> list = null;
		PatientDao patDao = new PatientDao();
		
		String action = request.getParameter("action");
		System.out.println("Action:" +  action);
		
		if(action != null && action.equals("delete")) {
			int id = Integer.parseInt(request.getParameter("id"));
			System.out.println("Chamando o método de deletar com id " + id);
			patDao.delete(id);
		}
		
		//1 - Obter lista de pacientes
		list = patDao.getAll();
		
		for(Patient p : list) {
			System.out.println(p.getId());
			System.out.println(p.getFirstName());
			System.out.println(p.getLastName());
			System.out.println(p.getGender());
		}
		
		//2 - Engavetar a lista no request
		request.setAttribute("list1", list);
		
		//3 - Encaminhar para o JSP
		getServletContext().getRequestDispatcher("/patient-list.jsp").forward(request, response);
		//RequestDispatcher output = request.getRequestDispatcher("patient-list.jsp");
		//output.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entrando no doPost() de Patient");
		
		int id = Integer.parseInt(request.getParameter("txtid"));
		String firstName = request.getParameter("txtfirst-name");
		String lastName = request.getParameter("txtlast-name");
		String gender = request.getParameter("txtgender");
		
		System.out.println(id);
		System.out.println(firstName);
		System.out.println(lastName);
		System.out.println(gender);
		
		Patient patient = new Patient(id, firstName, lastName, gender);
		
		PatientDao patDao = new PatientDao();
		patDao.save(patient);
		
		/*PrintWriter writer = response.getWriter();
		writer.println("Cadastrado!");*/
		
		doGet(request, response);	
	}

}
