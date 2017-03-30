package bean;

public class CheckoutBean {

	private String creditnumber; 
	private String expiry;
	private int cvv; 
	private String username; 
	private int id; 
	private String bid;
	
	public CheckoutBean(String creditnumber, String expiry, int cvv, String username, int id, String bid) {
		super();
		this.creditnumber = creditnumber;
		this.expiry = expiry;
		this.cvv = cvv;
		this.username = username;
		this.id = id;
		this.bid = bid;
	}

	public String getCreditnumber() {
		return creditnumber;
	}

	public void setCreditnumber(String creditnumber) {
		this.creditnumber = creditnumber;
	}

	public String getExpiry() {
		return expiry;
	}

	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	} 
	
	
}
