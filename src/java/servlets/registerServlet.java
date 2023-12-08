package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entiity.Employee;
import manager.EmpManager;

/**
 * Servlet implementation class registerServlet
 */
@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
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
				RequestDispatcher requestDispatch = req.getRequestDispatcher("error.jsp");
				requestDispatch.forward(req, resp);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
