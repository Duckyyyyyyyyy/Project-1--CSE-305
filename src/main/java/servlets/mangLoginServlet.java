package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entiity.Manager;
import manager.MangManager;


@WebServlet("/mangLoginServlet")
public class mangLoginServlet extends HttpServlet {
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String target = "";
		try {
			int idForm = Integer.parseInt(request.getParameter("mang_id"));
			String passwordForm = request.getParameter("mang_pass");

			MangManager mangManager = new MangManager();
			ArrayList<Manager> mangList = mangManager.getMangList();
//			System.out.println("--------");
//			System.out.println(accList.size());

			for (int i = 0; i < mangList.size(); i++) {
				int id = mangList.get(i).getManager_id();
				System.out.println("-----");
				System.out.println(id);
				String password = mangList.get(i).getManager_pass();
				if (id == idForm && (password.equals(passwordForm))) {
					System.out.println("login success");
					target = "managerPage.jsp";
					HttpSession mySession = request.getSession();
					mySession.setAttribute("mang_id", idForm);
					mySession.setAttribute("mang_pass", passwordForm);
					System.out.println("session from mySession " + mySession.getAttribute("mang_id"));
					System.out.println("session from mySession " + mySession.getAttribute("mang_pass"));
					break;
				}
			}
			if (target == "") {
				System.out.println("login unsuccess");
				target = "manager_login.jsp";
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
