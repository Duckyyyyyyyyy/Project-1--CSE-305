package manager;

import java.util.ArrayList;

import dao.PlaceDao;
import entiity.Places;
import helper.ConnectionProvider;

public class PlacesManager {
	private ArrayList<Places> placeList;
	private PlaceDao placeDao;

	public PlacesManager() {
		placeDao = new PlaceDao(ConnectionProvider.getConnection());
		updatePlace();
	}

	public void updatePlace() {
		this.placeList = placeDao.selectAllPlaces();
	}

	public ArrayList<Places> getPlaceList() {
		updatePlace();
		return this.placeList;
	}

	public boolean checkPlace(String name) {
		int status = placeDao.checkStatus(name);
		if (status == 0) {
			placeDao.updatePlace(name);
			updatePlace();
			return true;
		}
		return false;
	}
}
