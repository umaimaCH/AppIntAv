package chtioui.zelleg.restapi.ressource;


import java.security.SecureRandom;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;

import chtioui.zelleg.restapi.model.Collocation;
import chtioui.zelleg.restapi.model.Service;
import chtioui.zelleg.restapi.model.User;
import chtioui.zelleg.restapi.security.Secured;
import chtioui.zelleg.restapi.service.UserManager;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


@Path("/collocation")
public class UserRessource {
	
UserManager umanager = new UserManager();
	
	@Path("/insert")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public User addUser(User user) {
		
		 return umanager.insertUser(user);
		
	}
	
	@Path("/connect/{email}/{password}")
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	public String checkUser(@PathParam("email") String email,@PathParam("password") String password) throws SQLException {
		
		 return " connected \n your token for next requests is : "+umanager.checkUser(email,password);
		
	}
	
	@Path("/createCollocation")
	@POST
	@Secured
	@Consumes(MediaType.APPLICATION_JSON)
	public Collocation create(Collocation collocation) {
		
		 return umanager.createCollocation(collocation);
		
	}
	
	@Path("/createService")
	@POST
	@Secured
	@Consumes(MediaType.APPLICATION_JSON)
	public Service createS(Service service) {
		
		 return umanager.createService(service);
		
	}
	
	
}
