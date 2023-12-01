package manager;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

import dao.EmpDao;
import dao.ScheduleDao;
import entiity.Schedule;
import helper.ConnectionProvider;

public class ScheduleManager {
	private ArrayList<Schedule> scheduleList;
	private ScheduleDao scheduleDao;
	private EmpDao empDao;

	public ScheduleManager() {
		scheduleDao = new ScheduleDao(ConnectionProvider.getConnection());
		updateSchedule();
	}

	public void updateSchedule() {
		this.scheduleList = scheduleDao.selectAllSchedule();
	}

	public ArrayList<Schedule> getSchedulesList() {
		updateSchedule();
		return this.scheduleList;
	}

	public ArrayList<Schedule> getScheduleById(int id) {
		ArrayList<Schedule> list = new ArrayList<>();
		Schedule tempSchedule = null;
		for (int i = 0; i < scheduleList.size(); i++) {
			tempSchedule = scheduleList.get(i);
			if (tempSchedule.getEmp_id() == id) {
				list.add(tempSchedule);
			}
		}
		return list;
	}

	public boolean createSchedule(Schedule newSchedule) {
		boolean result = true;
		ArrayList<Schedule> list = new ArrayList<>();
		Date date = newSchedule.getDate();
		String place = newSchedule.getPlace();
		Time startTime = newSchedule.getStart();
		Time endTime = newSchedule.getEnd();

		list = scheduleDao.checkPlace(place, startTime, endTime, date);
		for (Schedule schedule : list) {
			Time checkStart = schedule.getStart();
			Time checkEnd = schedule.getEnd();

			if (checkStart.equals(startTime) && checkEnd.equals(endTime)) {
				result = false;
			}
		}
		if (result) {
			scheduleDao.addSchedule(newSchedule);
			this.updateSchedule();
		}
		return result;
	}

}
