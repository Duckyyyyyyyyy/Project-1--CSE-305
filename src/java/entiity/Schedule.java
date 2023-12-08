package entiity;

import java.sql.Date;
import java.sql.Time;

public class Schedule {
	private int id;
	private int emp_id;
	private Date date;
	private String place;
	private Time start;
	private Time end;
	
	public Schedule(int id, int emp_id, Date date, String place, Time start, Time end) {
		super();
		this.id = id;
		this.emp_id = emp_id;
		this.date = date;
		this.place = place;
		this.start = start;
		this.end = end;
	}

	public Schedule(int emp_id, Date date, String place, Time start, Time end) {
		super();
		this.emp_id = emp_id;
		this.date = date;
		this.place = place;
		this.start = start;
		this.end = end;
	}

	public Schedule() {}

	public Schedule(Date date, String place, Time start, Time end) {
		super();
		this.date = date;
		this.place = place;
		this.start = start;
		this.end = end;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Time getStart() {
		return start;
	}

	public void setStart(Time start) {
		this.start = start;
	}

	public Time getEnd() {
		return end;
	}

	public void setEnd(Time end) {
		this.end = end;
	}
	
	
}
