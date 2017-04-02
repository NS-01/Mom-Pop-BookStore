package junittest;

import static org.junit.Assert.*;

import org.junit.Test;

import bean.AddressBean;
import bean.CartBean;

public class CartBeanTest {

	@Test
	public void testCartBeanConstructor() {
		String title_retrieve = "Dracula";
		int price = 50;
		String category_retrieve= "Horror";
		String bid = "b002";
		String pic_url = "http://31.media.tumblr.com/a9b69cfdc5eb6c4140a6df01f53b7367/tumblr_n2c1eilZpB1qezqpuo1_500.jpg";;
		CartBean bean = new CartBean (title_retrieve,price, category_retrieve, bid, pic_url);
		assertEquals(bean.getTitle_retrieve(), title_retrieve);
		assertEquals(bean.getPrice(), price);
		assertEquals(bean.getCategory_retrieve(), category_retrieve);
		assertEquals(bean.getBid(), bid);
		assertEquals(bean.getPic_url(), pic_url);

	}
	
	@Test
	public void testTitle_Retreive() {
		String title_retrieve = "Dracula";
		int price = 50;
		String category_retrieve= "Horror";
		String bid = "b002";
		String pic_url = "http://31.media.tumblr.com/a9b69cfdc5eb6c4140a6df01f53b7367/tumblr_n2c1eilZpB1qezqpuo1_500.jpg";;
		CartBean bean = new CartBean (title_retrieve,price, category_retrieve, bid, pic_url);
		bean.setTitle_retrieve("Horns");
		assertEquals(bean.getTitle_retrieve(), "Horns");
		assertEquals(bean.getPrice(), price);
		assertEquals(bean.getCategory_retrieve(), category_retrieve);
		assertEquals(bean.getBid(), bid);
		assertEquals(bean.getPic_url(), pic_url);
	}
	
	@Test
	public void testPrice() {
		String title_retrieve = "Dracula";
		int price = 50;
		String category_retrieve= "Horror";
		String bid = "b002";
		String pic_url = "http://31.media.tumblr.com/a9b69cfdc5eb6c4140a6df01f53b7367/tumblr_n2c1eilZpB1qezqpuo1_500.jpg";;
		CartBean bean = new CartBean (title_retrieve,price, category_retrieve, bid, pic_url);
		bean.setPrice(10);
		assertEquals(bean.getTitle_retrieve(), title_retrieve);
		assertEquals(bean.getPrice(), 10);
		assertEquals(bean.getCategory_retrieve(), category_retrieve);
		assertEquals(bean.getBid(), bid);
		assertEquals(bean.getPic_url(), pic_url);
	}
	
	@Test
	public void testCategory() {
		String title_retrieve = "Dracula";
		int price = 50;
		String category_retrieve= "Horror";
		String bid = "b002";
		String pic_url = "http://31.media.tumblr.com/a9b69cfdc5eb6c4140a6df01f53b7367/tumblr_n2c1eilZpB1qezqpuo1_500.jpg";;
		CartBean bean = new CartBean (title_retrieve,price, category_retrieve, bid, pic_url);
		bean.setCategory_retrieve("Romance");
		assertEquals(bean.getTitle_retrieve(), title_retrieve);
		assertEquals(bean.getPrice(), price);
		assertEquals(bean.getCategory_retrieve(), "Romance");
		assertEquals(bean.getBid(), bid);
		assertEquals(bean.getPic_url(), pic_url);
	}
	
	@Test
	public void testBid() {
		String title_retrieve = "Dracula";
		int price = 50;
		String category_retrieve= "Horror";
		String bid = "b002";
		String pic_url = "http://31.media.tumblr.com/a9b69cfdc5eb6c4140a6df01f53b7367/tumblr_n2c1eilZpB1qezqpuo1_500.jpg";;
		CartBean bean = new CartBean (title_retrieve,price, category_retrieve, bid, pic_url);
		bean.setBid("b009");
		assertEquals(bean.getTitle_retrieve(), title_retrieve);
		assertEquals(bean.getPrice(), price);
		assertEquals(bean.getCategory_retrieve(), category_retrieve);
		assertEquals(bean.getBid(), "b009");
		assertEquals(bean.getPic_url(), pic_url);
	}
	
	@Test
	public void testPic_Url() {
		String title_retrieve = "Dracula";
		int price = 50;
		String category_retrieve= "Horror";
		String bid = "b002";
		String pic_url = "http://31.media.tumblr.com/a9b69cfdc5eb6c4140a6df01f53b7367/tumblr_n2c1eilZpB1qezqpuo1_500.jpg";;
		CartBean bean = new CartBean (title_retrieve,price, category_retrieve, bid, pic_url);
		bean.setPic_url("testingpic.com");
		assertEquals(bean.getTitle_retrieve(), title_retrieve);
		assertEquals(bean.getPrice(), price);
		assertEquals(bean.getCategory_retrieve(), category_retrieve);
		assertEquals(bean.getBid(), bid);
		assertEquals(bean.getPic_url(), "testingpic.com");
	}
}
