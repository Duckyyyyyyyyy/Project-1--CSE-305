package manager;

import java.util.ArrayList;

import dao.EmpDao;
import entiity.Employee;
import helper.ConnectionProvider;

public class EmpManager {
	private ArrayList<Employee> empList;
	private EmpDao empDao;
	
	public EmpManager() {
		empDao = new EmpDao(ConnectionProvider.getConnection());
		updateEmp();
	}
	
	public void updateEmp() {
		this.empList = empDao.selectEmpInfor();
	}

	public boolean insertEmp(Employee employee) {
		boolean result = false;
		if (this.getEmpByID(employee.getEmp_id()) == null) {
			empDao.insertEmp(employee);
			this.updateEmp();;
			result = true;
		}
		return result;
	}
	
//	public boolean insertEmprById(Employee employee) {
//		boolean result = false;
//		if (this.getEmpByID(employee.getEmp_id()) != null) {
//			empDao.updateEmp(emp);
//			this.updateEmp();;
//			result = true;
//		}
//		return result;
//	}

	public Employee getEmpByID(int id) {
		Employee tempEmp = null;
		for (int i = 0; i < empList.size(); i++) {
			tempEmp = empList.get(i);
			if (tempEmp.getEmp_id() == id) {
				return tempEmp;
			}
		}
		return null;
	}
	
	public ArrayList<Employee> getEmpList() {
		return this.empList;
	}

	public void updateReqDuty(int emp_id, int reqDuty) {
		empDao.changeReqDuty(emp_id, reqDuty);;
		this.updateEmp();
	}
	
	public int getReqDuty(int emp_id) {
		int reqDuty = empDao.getReqDuty(emp_id);
		return reqDuty;
	}
	
	public void updateReqLeave(int emp_id, int reqLeave) {
		empDao.changeReqLeave(emp_id, reqLeave);
		this.updateEmp();
	}
	
	public int getReqLeave(int emp_id) {
		int reqLeave = empDao.getReqLeave(emp_id);
		return reqLeave;
	}
	
	public void updateDuty(int emp_id, int duty) {
		empDao.changeDuty(emp_id, duty);
		this.updateEmp();
	}
	
	public int getDuty(int emp_id) {
		int duty = empDao.getDuty(emp_id);
		return duty;
	}
	
	public void updateLeaves(int emp_id, int leaves) {
		empDao.changeLeaves(emp_id, leaves);
		this.updateEmp();
	}
	
	public int getLeaves(int emp_id) {
		int leaves = empDao.getLeaves(emp_id);
		return leaves;
	}
}
