package main_rest_crud;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

@Path("/user/service")
public class UserService {
	
	@PUT
	@Path("/create")
	public void createUser() {
		
	}
	
	@GET
	@Path("/getUser")
	public void getUser() {
		System.out.println("get user called");
	}
	
	@POST
	public void updateUser() {
		
	}
	
	@DELETE
	public void deleteUser() {
		
	}
}