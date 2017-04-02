package junittest;

import static org.junit.Assert.*;

import org.junit.Test;
import bean.VisitEventBean;

public class VisitEventBeanTest {
	
	@Test
	public void testVisitBeanConstructor() {
		String day = "03012017";
		String bid = "b001";
		String eventtype = "Purchase"; 
		String username = "frank111";
		
		VisitEventBean bean = new VisitEventBean(day, bid, eventtype, username);
		assertEquals(bean.getUsername(), username);
		assertEquals(bean.getDay(), day);
		assertEquals(bean.getEventtype(), eventtype);
		assertEquals(bean.getBid(), bid);
	
	}
	
	@Test
	public void testUsername() {
		String day = "03012017";
		String bid = "b001";
		String eventtype = "Purchase"; 
		String username = "frank111";
		
		VisitEventBean bean = new VisitEventBean(day, bid, eventtype, username);
		bean.setUsername("bob1111");
		assertEquals(bean.getUsername(), "bob1111");
		assertEquals(bean.getDay(), day);
		assertEquals(bean.getEventtype(), eventtype);
		assertEquals(bean.getBid(), bid);
	
	}
	
	@Test
	public void testDay() {
		String day = "03012017";
		String bid = "b001";
		String eventtype = "Purchase"; 
		String username = "frank111";
		
		VisitEventBean bean = new VisitEventBean(day, bid, eventtype, username);
		bean.setDay("030101");
		assertEquals(bean.getUsername(), username);
		assertEquals(bean.getDay(), "030101");
		assertEquals(bean.getEventtype(), eventtype);
		assertEquals(bean.getBid(), bid);
	
	}
	
	@Test
	public void testEventType() {
		String day = "03012017";
		String bid = "b001";
		String eventtype = "Purchase"; 
		String username = "frank111";
		
		VisitEventBean bean = new VisitEventBean(day, bid, eventtype, username);
		bean.setEventtype("View");
		assertEquals(bean.getUsername(), username);
		assertEquals(bean.getDay(), day);
		assertEquals(bean.getEventtype(), "View");
		assertEquals(bean.getBid(), bid);
	
	}
	
	
	@Test
	public void testBid() {
		String day = "03012017";
		String bid = "b001";
		String eventtype = "Purchase"; 
		String username = "frank111";
		
		VisitEventBean bean = new VisitEventBean(day, bid, eventtype, username);
		bean.setBid("b003");
		assertEquals(bean.getUsername(), username);
		assertEquals(bean.getDay(), day);
		assertEquals(bean.getEventtype(), eventtype);
		assertEquals(bean.getBid(), "b003");
	}
}
