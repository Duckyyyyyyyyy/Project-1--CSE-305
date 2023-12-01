package entiity;

public class Employee {
	private int emp_id;
	private String emp_name;
	private String emp_pass;
	private int leaves;
	private int duty;
	private int reqLeave;
	private int reqDuty;
	
	public Employee(int emp_id, String emp_name, String emp_pass) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.emp_pass = emp_pass;
	}

	public Employee(int emp_id, String emp_name, String emp_pass, int leaves, int duty) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.emp_pass = emp_pass;
		this.leaves = leaves;
		this.duty = duty;
	}

	public Employee(int emp_id, String emp_name, String emp_pass, int leaves, int duty, int reqLeave, int reqDuty) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.emp_pass = emp_pass;
		this.leaves = leaves;
		this.duty = duty;
		this.reqLeave = reqLeave;
		this.reqDuty = reqDuty;
	}

	public int getEmp_id() {
		return emp_id;
	}

//	public void setEmp_id(int emp_id) {
//		this.emp_id = emp_id;
//	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getEmp_pass() {
		return emp_pass;
	}

	public void setEmp_pass(String emp_pass) {
		this.emp_pass = emp_pass;
	}

	public int getLeaves() {
		return leaves;
	}

	public void setLeaves(int leaves) {
		this.leaves = leaves;
	}

	public int getDuty() {
		return duty;
	}

	public void setDuty(int duty) {
		this.duty = duty;
	}

	public int getReqLeave() {
		return reqLeave;
	}

	public void setReqLeave(int reqLeave) {
		this.reqLeave = reqLeave;
	}

	public int getReqDuty() {
		return reqDuty;
	}

	public void setReqDuty(int reqDuty) {
		this.reqDuty = reqDuty;
	}
	
	
}
