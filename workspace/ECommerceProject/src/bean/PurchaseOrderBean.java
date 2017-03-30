package bean;

public class PurchaseOrderBean {
	
	private int id;
	private String fname;
	private String lname;
	private String status;
	private int address;
	public PurchaseOrderBean(int id, String fname, String lname, String status, int address) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.status = status;
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getAddress() {
		return address;
	}
	public void setAddress(int address) {
		this.address = address;
	}
	

}
