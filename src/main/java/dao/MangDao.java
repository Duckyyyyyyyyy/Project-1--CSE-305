package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entiity.Manager;



public class MangDao {
	private Connection con;

	public MangDao(Connection con) {
		this.con = con;
	}

	public boolean insertMang(Manager manager) {
		String query = "insert into mang_details(id, name, password) values(?, ?, ?)";

		try {
			PreparedStatement ps = this.con.prepareStatement(query);

			ps.setInt(1, manager.getManager_id());
			ps.setString(2, manager.getManager_name());
			ps.setString(3, manager.getManager_pass());

			ps.executeUpdate();

			ps.close();
//			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public ArrayList<Manager> selectMangInfor(){
		ArrayList<Manager> mangList = new ArrayList<>();
		
		String query =  "select * from mang_details";
		
		try {
			PreparedStatement ps = this.con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String password = rs.getString("password");
				String name = rs.getString("name");
				
				mangList.add(new Manager(id, name, password));
			}
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		}
		return mangList;
	}
	

}
