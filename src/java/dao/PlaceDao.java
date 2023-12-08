package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entiity.Places;

public class PlaceDao {
	private Connection con;

	public PlaceDao(Connection con) {
		this.con = con;
	}

	public ArrayList<Places> selectAllPlaces() {
		ArrayList<Places> placeList = new ArrayList<>();
		String query = "select * from places";

		try {
			PreparedStatement ps = this.con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int status = rs.getInt("status");

				placeList.add(new Places(id, name, status));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		}
		return placeList;
	}

	public int checkStatus(String placeName) {
		String query = "select status from places where name = ?";
		int status = -1;
		try {
			PreparedStatement ps = this.con.prepareStatement(query);
			ps.setString(1, placeName);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				status = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return status;
	}

	public void updatePlace(String name) {
		String query = "update places set status = ? where name = ?";

		try {
			PreparedStatement ps = this.con.prepareStatement(query);
			ps.setInt(1, 1);
			ps.setString(2, name);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		}
	}
	
}
