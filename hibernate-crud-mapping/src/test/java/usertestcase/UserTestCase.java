package usertestcase;


import org.junit.Assert;
import org.junit.Test;

import com.spring.hibernate.mapping.UserDAOImpl;

public class UserTestCase {
	/*private static AplicationContext context;
	private static UserDetails userDAO;
	
	
	@BeforeClass
	public static void init() {
		context = new SpringHibernateMain();
		context.sca
	}*/
	/*@Test
	public void test() {
		fail("Not yet implemented");
	}*/
	
	@Test
	public void createTest() {
//		Assert.assertEquals(SpringHibernateMain.startConnection(), true);
		UserDAOImpl user = new UserDAOImpl();
		Assert.assertEquals(UserDAOImpl.startConnection(), true);
//		Assert.assertEquals(user.add(5), true);
		Assert.assertEquals(UserDAOImpl.closeConnection(), true);
//		Assert.assertEquals(SpringHibernateMain.addToDatabase(4), true);
	}
	
	/*@Test
	public void createDummyFailTest() {
		Assert.fail();
	}*/
	
}
