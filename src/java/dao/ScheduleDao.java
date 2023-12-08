package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

import entiity.Manager;
import entiity.Schedule;

public class ScheduleDao {
	private Connection con;

	public ScheduleDao(Connection con) {
		this.con = con;
	}

	public boolean addSchedule(Schedule schedule) {
		String query = "insert into schedule(emp_id, date, place, start, end) values(?, ?, ?, ?, ?)";

		try {
			PreparedStatement ps = this.con.prepareStatement(query);
			ps.setInt(1, schedule.getEmp_id());
			ps.setDate(2, schedule.getDate());
			ps.setString(3, schedule.getPlace());
			ps.setTime(4, schedule.getStart());
			ps.setTime(5, schedule.getEnd());

			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		}
		return true;
	}

	public ArrayList<Schedule> selectAllSchedule() {
		ArrayList<Schedule> scheduleList = new ArrayList<>();
		String query = "select * from schedule";

		try {
			PreparedStatement ps = this.con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				int emp_id = rs.getInt("emp_id");
				Date date = rs.getDate("date");
				String place = rs.getString("place");
				Time start = rs.getTime("start");
				Time end = rs.getTime("end");

				scheduleList.add(new Schedule(id, emp_id, date, place, start, end));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		}
		return scheduleList;
	}

	public ArrayList<Schedule> viewSchedule(int emp_id) {
		ArrayList<Schedule> scheduleList = new ArrayList<>();
		String query = "select * from schedule where emp_id = ?";

		try {
			PreparedStatement ps = this.con.prepareStatement(query);
			ps.setInt(1, emp_id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				Date date = rs.getDate("date");
				String place = rs.getString("place");
				Time start = rs.getTime("start");
				Time end = rs.getTime("end");

				scheduleList.add(new Schedule(id, emp_id, date, place, start, end));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		}
		return scheduleList;
	}

	public ArrayList<Schedule> checkPlace(String place, Time from, Time to, Date date) {
		ArrayList<Schedule> list = new ArrayList<>();
//		Schedule schedule = null;
		String query = "select start, end from schedule where place = ? and date = ?";
		try {
			PreparedStatement ps = this.con.prepareStatement(query);
			ps.setString(1, place);
			ps.setDate(2, date);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Time start = rs.getTime("start");
				Time end = rs.getTime("end");

				list.add(new Schedule(date, place, start, end));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		}
		return list;
	}
	
}
