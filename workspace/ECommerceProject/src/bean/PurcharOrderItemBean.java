package bean;

public class PurcharOrderItemBean {
	
	private int id;
	private String bid;
	private int price;
	public PurcharOrderItemBean(int id, String bid, int price) {
		super();
		this.id = id;
		this.bid = bid;
		this.price = price;
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
	public void setBig(String bid) {
		this.bid = bid;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	

}
