package manager;

import java.util.ArrayList;

import dao.MangDao;
import entiity.Manager;
import helper.ConnectionProvider;

public class MangManager {
	private ArrayList<Manager> mangList;
	private MangDao mangDao;

	public MangManager() {
		mangDao = new MangDao(ConnectionProvider.getConnection());
		updateMang();
	}

	public void updateMang() {
		this.mangList = mangDao.selectMangInfor();
	}

	public boolean insertMang(Manager manager) {
		boolean result = false;
		if (this.getMangByID(manager.getManager_id()) == null) {
			mangDao.insertMang(manager);
			this.updateMang();
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

	public Manager getMangByID(int id) {
		Manager tempMang = null;
		for (int i = 0; i < mangList.size(); i++) {
			tempMang = mangList.get(i);
			if (tempMang.getManager_id() == id) {
				return tempMang;
			}
		}
		return null;
	}

	public ArrayList<Manager> getMangList() {
		return this.mangList;
	}

}
