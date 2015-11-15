package iavanish.REST;

import iavanish.Database.DatabaseRead;
import iavanish.Database.User;
import iavanish.Database.UtilityClass;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/getUserDetails")
public class GetUserDetails {
	
    @GET
    @Path("/getUserDetails")  
    @Produces(MediaType.APPLICATION_JSON) 
 
    public String getUserDetails(@QueryParam("rollNo") String rollNo) {
        
    	String response = "";
    	User user = DatabaseRead.getUserDetails(rollNo);
        
    	response = UtilityClass.constructJSON(user);
        
        return response;
 
    }
 
}