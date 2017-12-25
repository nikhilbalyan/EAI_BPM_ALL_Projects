package testing_user;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import com.spring.hibernate.SpringHibernateMain;
import com.spring.hibernate.UserDAOImpl;

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
		Assert.assertEquals(UserDAOImpl.startConnection(), true);
//		Assert.assertEquals(SpringHibernateMain.addToDatabase(4), true);
	}
	
	/*@Test
	public void createDummyFailTest() {
		Assert.fail();
	}*/
	
}
