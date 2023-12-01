package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entiity.Employee;
import manager.EmpManager;

@WebServlet("/empRegisterServlet")
//public class empRegisterServlet implements Servlet {
//	ServletConfig conf;
//
//	public void destroy() {
//		// TODO Auto-generated method stub
//
//	}
//
//	public ServletConfig getServletConfig() {
//		return this.conf;
//	}
//
//	public String getServletInfo() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public void init(ServletConfig config) throws ServletException {
//		System.out.println("Creating Servlet Object....");
//		this.conf = conf;
//	}
//
//	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
//		String dbDriver = "com.mysql.cj.jdbc.Driver";
//		String dbURL = "jdbc:mysql://localhost:3306/ ";
//		String dbName = "project305";
//		String dbUsername = "root";
//		String dbPassword = "12345678";
//
//		try {
//			Class.forName(dbDriver); // Loading & Registering the MySQL Driver
//			Connection con = DriverManager.getConnection(dbURL + dbName, dbUsername, dbPassword); // Creating connection
//																									// object
//			PreparedStatement st = con.prepareStatement("insert into emp_details(id, name, password) values(?, ?, ?)");
//			// Creating statement object
//			
//			System.out.println("-----");
//			System.out.println(Integer.valueOf(req.getParameter("emp_id")));
//			System.out.println(req.getParameter("emp_name"));
//			System.out.println(req.getParameter("emp_pass"));
//			System.out.println("----------");
//
//			st.setInt(1, Integer.valueOf(req.getParameter("emp_id")));
//			st.setString(2, req.getParameter("emp_name"));
//			st.setString(3, req.getParameter("emp_pass"));
//			
//			st.executeUpdate();
//			
//			st.close();
//			con.close();
//			
//			RequestDispatcher rd = req.getRequestDispatcher("emp_login.jsp");
//			 rd.forward(req, res);
//	
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//	}
public class empRegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			EmpManager empManager = new EmpManager();

			int emp_id;
			String emp_name, emp_pass;

			emp_id = Integer.valueOf(req.getParameter("emp_id"));
			emp_name = req.getParameter("emp_name");
			emp_pass = req.getParameter("emp_pass");
			System.out.println(emp_id);

			Employee employee = new Employee(emp_id, emp_name, emp_pass);

			if (empManager.insertEmp(employee)) {
				System.out.println("Insert successfully");
				RequestDispatcher requestDispatch = req.getRequestDispatcher("emp_login.jsp");
				requestDispatch.forward(req, resp);
			} else {
				System.out.println("Insert unsuccessfully");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}