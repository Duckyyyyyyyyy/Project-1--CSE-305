package entiity;

public class Manager {
	private int manager_id;
	private String manager_name;
	private String manager_pass;
	
	public Manager(int manager_id, String manager_name, String manager_pass) {
		super();
		this.manager_id = manager_id;
		this.manager_name = manager_name;
		this.manager_pass = manager_pass;
	}

	public int getManager_id() {
		return manager_id;
	}

//	public void setManager_id(int manager_id) {
//		this.manager_id = manager_id;
//	}

	public String getManager_name() {
		return manager_name;
	}

	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
	}

	public String getManager_pass() {
		return manager_pass;
	}

	public void setManager_pass(String manager_pass) {
		this.manager_pass = manager_pass;
	}
	
	
}
