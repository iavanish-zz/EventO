package iavanish.REST;

import iavanish.Database.DatabaseRead;
import iavanish.Database.User;
import iavanish.Database.UtilityClass;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/viewAllUsers")
public class ViewAllUsers {
	
    @GET
    @Path("/viewAllUsers")  
    @Produces(MediaType.APPLICATION_JSON) 
 
    public String viewAllUsers() {
        
    	String response = "";
    	List <User> users = DatabaseRead.viewAllUsers();
        
    	response = UtilityClass.constructJSON(users);
        
        return response;
 
    }
 
}