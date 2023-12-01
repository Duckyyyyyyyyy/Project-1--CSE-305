package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entiity.Manager;
import manager.MangManager;

@WebServlet("/mangRegisterServlet")
public class mangRegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			MangManager mangManager = new MangManager();

			int mang_id;
			String mang_name, mang_pass;

			mang_id = Integer.valueOf(req.getParameter("mang_id"));
			mang_name = req.getParameter("mang_name");
			mang_pass = req.getParameter("mang_pass");
			System.out.println(mang_id);

			Manager manager = new Manager(mang_id, mang_name, mang_pass);

			if (mangManager.insertMang(manager)) {
				System.out.println("Insert successfully");
				RequestDispatcher requestDispatch = req.getRequestDispatcher("manager_login.jsp");
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
