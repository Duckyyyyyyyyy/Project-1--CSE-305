package servlets;

import java.io.IOException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entiity.Places;
import entiity.Schedule;
import manager.EmpManager;
import manager.PlacesManager;
import manager.ScheduleManager;

@WebServlet("/createScheduleRegister")
public class createScheduleRegister extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String target = "managerPage.jsp";

		try {
			ScheduleManager scheduleManager = new ScheduleManager();
			PlacesManager placesManager = new PlacesManager();
			EmpManager empManager = new EmpManager();

			System.out.println("-------------");
			int emp_id = Integer.valueOf(req.getParameter("emp_id"));
			String place = req.getParameter("place");
			System.out.println(emp_id);
			System.out.println(place);
			java.util.Date selectedDate = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("date"));
			selectedDate = new java.sql.Date(selectedDate.getTime());
			System.out.println(selectedDate);
			java.util.Date startTime = new SimpleDateFormat("hh:mm").parse(req.getParameter("startTime"));
			java.util.Date endTime = new SimpleDateFormat("hh:mm").parse(req.getParameter("endTime"));

			startTime = new java.sql.Time(startTime.getTime());
			endTime = new java.sql.Time(endTime.getTime());
			System.out.println(startTime);
			System.out.println(endTime);

			Schedule newSchedule = new Schedule(emp_id, (java.sql.Date) selectedDate, place, (Time) startTime,
					(Time) endTime);
			
			int duty = empManager.getDuty(emp_id);
			if (scheduleManager.createSchedule(newSchedule)) {
				empManager.updateDuty(emp_id, duty);
				System.out.println("create schedule successfully");		
				req.getSession().setAttribute("msg", "create schedule success");

			} else {
				System.out.println("create schedule unsuccessfully");
//				target = "managerPage.jsp";
				req.getSession().setAttribute("msg", "create schedule unsuccess");

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		RequestDispatcher requestDispatch = req.getRequestDispatcher(target);
		requestDispatch.forward(req, resp);
	}
}
