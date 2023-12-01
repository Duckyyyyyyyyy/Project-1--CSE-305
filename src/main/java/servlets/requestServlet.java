package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.EmpManager;

@WebServlet("/requestServlet")
public class requestServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String targer = "";
		int duties = 0;
		int leaves = 0;
		String acceptDuty = null;
		String acceptLeave = null;
		String rejectDuty = null;
		String rejectLeave = null;
		int id = 0;
		int empId = 0;

		try {
			EmpManager empManager = new EmpManager();
			if (req.getParameter("requestDuty") != null) {
				duties = Integer.valueOf(req.getParameter("requestDuty"));
				System.out.println("duties: " + duties);

			}
			if (req.getParameter("requestLeave") != null) {
				leaves = Integer.valueOf(req.getParameter("requestLeave"));
				System.out.println("leaves: " + leaves);
			}
			if (req.getParameter("empId") != null) {
				empId = Integer.valueOf(req.getParameter("empId"));
				System.out.println("empId: " + empId);
			}

			if (req.getParameter("emp_id") != null) {
				id = Integer.valueOf(req.getParameter("emp_id"));
				System.out.println("id: " + id);
				if (req.getParameter("acceptDuty") != null) {
					acceptDuty = req.getParameter("acceptDuty");
					System.out.println("acceptDuty: " + acceptDuty);
					if (acceptDuty.equalsIgnoreCase("acceptDuty")) {
						System.out.println("acceptDuty success");
						empManager.updateReqDuty(id, 0);
						int duty = empManager.getDuty(id);
						empManager.updateDuty(id, duty);
						targer = "managerPage.jsp";
					}
				}
				if (req.getParameter("acceptLeave") != null) {
					acceptLeave = req.getParameter("acceptLeave");
					System.out.println("acceptLeave: " + acceptLeave);
					if (acceptLeave.equalsIgnoreCase("acceptLeave") && acceptLeave != null) {
						System.out.println("acceptLeave success");
						empManager.updateReqLeave(id, 0);
						int leave = empManager.getLeaves(id);
						empManager.updateLeaves(id, leave);
						targer = "managerPage.jsp";
					}
				}
				if (req.getParameter("rejectDuty") != null) {
					rejectDuty = req.getParameter("rejectDuty");
					System.out.println("rejectDuty: " + rejectDuty);
					if (rejectDuty.equalsIgnoreCase("rejectDuty")) {
						empManager.updateReqDuty(id, 0);
						targer = "managerPage.jsp";
					}
				}
				if (req.getParameter("rejectLeave") != null) {
					rejectLeave = req.getParameter("rejectLeave");
					System.out.println("rejectLeave: " + rejectLeave);
					if (rejectLeave.equalsIgnoreCase("rejectLeave")) {
						empManager.updateReqLeave(id, 0);
						targer = "managerPage.jsp";
					}
				}
			}

			if (duties == 1) {
				System.out.println("updateDuty success");
				empManager.updateReqDuty(empId, duties);
				targer = "empPage.jsp";
			}
//			
			if (leaves == 1) {
				System.out.println("updateLeaves success");
				empManager.updateReqLeave(empId, leaves);
				targer = "empPage.jsp";
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		RequestDispatcher requestDispatch = req.getRequestDispatcher(targer);
		requestDispatch.forward(req, resp);
	}

}
