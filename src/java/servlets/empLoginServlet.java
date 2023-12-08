package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entiity.Employee;
import manager.EmpManager;

@WebServlet("/empLoginServlet")
public class empLoginServlet extends HttpServlet {

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String target = "";
		try {
			int idForm = Integer.parseInt(request.getParameter("emp_id"));
			String passwordForm = request.getParameter("emp_pass");

			EmpManager empManager = new EmpManager();
			ArrayList<Employee> empList = empManager.getEmpList();
//			System.out.println("--------");
			System.out.println(empList.size());

			for (int i = 0; i < empList.size(); i++) {
				int id = empList.get(i).getEmp_id();
				System.out.println(id);
				System.out.println("-----");
				System.out.println(id);
				String password = empList.get(i).getEmp_pass();
				if (id == idForm && (password.equals(passwordForm))) {
					System.out.println("login success");
					target = "empPage.jsp";
					HttpSession mySession = request.getSession();
					mySession.setAttribute("emp_id", idForm);
					mySession.setAttribute("emp_pass", passwordForm);
					System.out.println("session from mySession " + mySession.getAttribute("emp_id"));
					System.out.println("session from mySession " + mySession.getAttribute("emp_pass"));
					break;
				}
			}
			if (target == "") {
				System.out.println("login unsuccess");
				target = "emp_login.jsp";
			}
			RequestDispatcher requestDispatch = request.getRequestDispatcher(target);
			requestDispatch.forward(request, response);
		} catch (Exception exx) {
			System.out.println(exx.getMessage());
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

}