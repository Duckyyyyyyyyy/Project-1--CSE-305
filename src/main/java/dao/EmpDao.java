package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entiity.Employee;

public class EmpDao {
	private Connection con;

	public EmpDao(Connection con) {
		this.con = con;
	}

	public boolean insertEmp(Employee emp) {
		String query = "insert into emp_details(id, name, password, leaves, duty) values(?, ?, ?, ?, ?)";

		try {
			PreparedStatement ps = this.con.prepareStatement(query);

			ps.setInt(1, emp.getEmp_id());
			ps.setString(2, emp.getEmp_name());
			ps.setString(3, emp.getEmp_pass());
			ps.setInt(4, 0);
			ps.setInt(5, 0);

			ps.executeUpdate();

			ps.close();
//			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public ArrayList<Employee> selectEmpInfor() {
		ArrayList<Employee> empList = new ArrayList<>();

		String query = "select * from emp_details";

		try {
			PreparedStatement ps = this.con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String password = rs.getString("password");
				String name = rs.getString("name");
				int leaves = rs.getInt("leaves");
				int duty = rs.getInt("duty");
				int req_duty= rs.getInt("reqDuty");
				int req_leave= rs.getInt("reqLeave");


				empList.add(new Employee(id, name, password, leaves, duty,req_leave, req_duty));
				
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		}
		return empList;
	}

	public void changeDuty(int emp_id, int duty) {
		String query = "update emp_details set duty = ? where id = ?";

		try {
			PreparedStatement ps = this.con.prepareStatement(query);
			ps.setInt(1, duty + 1);
			ps.setInt(2, emp_id);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		}
	}

	public void changeLeaves(int emp_id, int leaves) {
		String query = "update emp_details set leaves = ? where id = ?";

		try {
			PreparedStatement ps = this.con.prepareStatement(query);
			ps.setInt(1, leaves + 1);
			ps.setInt(2, emp_id);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		}
	}

	public int getDuty(int emp_id) {
		String query = "select duty from emp_details where id = ?";
		int duty = 0;
		try {
			PreparedStatement ps = this.con.prepareStatement(query);
			ps.setInt(1, emp_id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				duty = rs.getInt("duty");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		}
		return duty;
	}
	
	public int getLeaves(int emp_id) {
		String query = "select leaves from emp_details where id = ?";
		int leaves = 0;
		try {
			PreparedStatement ps = this.con.prepareStatement(query);
			ps.setInt(1, emp_id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				leaves = rs.getInt("leaves");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		}
		return leaves;
	}
	
	public void changeReqDuty(int emp_id, int reqDuty) {
		String query = "update emp_details set reqDuty = ? where id = ?";
		System.out.println("-------- " + reqDuty);
		System.out.println("-------- " + emp_id);
		try {
			PreparedStatement ps = this.con.prepareStatement(query);
			ps.setInt(1, reqDuty);
			ps.setInt(2, emp_id);
			System.out.println("update reqDuty");
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		}
	}
	
	public void changeReqLeave(int emp_id, int reqLeave) {
		String query = "update emp_details set reqLeave = ? where id = ?";

		try {
			PreparedStatement ps = this.con.prepareStatement(query);
			ps.setInt(1, reqLeave);
			ps.setInt(2, emp_id);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		}
	}
	
	
	public int getReqLeave(int emp_id) {
		String query = "select reqLeave from emp_details where id = ?";
		int reqLeave = 0;
		try {
			PreparedStatement ps = this.con.prepareStatement(query);
			ps.setInt(1, emp_id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				reqLeave = rs.getInt("reqLeave");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		}
		return reqLeave;
	}
	
	
	public int getReqDuty(int emp_id) {
		String query = "select reqDuty from emp_details where id = ?";
		int reqDuty = 0;
		try {
			PreparedStatement ps = this.con.prepareStatement(query);
			ps.setInt(1, emp_id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				reqDuty = rs.getInt("reqDuty");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		}
		return reqDuty;
	}
}
