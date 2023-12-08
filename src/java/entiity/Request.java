package entiity;

public class Request {
	private boolean requestDuty = false;
	private boolean requestLeave = false;
	private int emp_id;
	public boolean isRequestDuty() {
		return requestDuty;
	}
	public void setRequestDuty(boolean requestDuty) {
		this.requestDuty = requestDuty;
	}
	public boolean isRequestLeave() {
		return requestLeave;
	}
	public void setRequestLeave(boolean requestLeave) {
		this.requestLeave = requestLeave;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public Request(boolean requestDuty, boolean requestLeave, int emp_id) {
		super();
		this.requestDuty = requestDuty;
		this.requestLeave = requestLeave;
		this.emp_id = emp_id;
	}
	
}
