package bean;

public class CartBean {

	String title_retrieve;
	int price;
	String category_retrieve;
	String bid;
	public CartBean(String title_retrieve, int price, String category_retrieve, String bid) {
		this.title_retrieve = title_retrieve;
		this.price = price;
		this.category_retrieve = category_retrieve;
		this.bid = bid;
	}

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public String getTitle_retrieve() {
		return title_retrieve;
	}

	public void setTitle_retrieve(String title_retrieve) {
		this.title_retrieve = title_retrieve;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCategory_retrieve() {
		return category_retrieve;
	}

	public void setCategory_retrieve(String category_retrieve) {
		this.category_retrieve = category_retrieve;
	}

}
