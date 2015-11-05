package iavanish.REST;

import iavanish.Database.DatabaseWrite;
import iavanish.Database.UtilityClass;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/deleteEvent")
public class DeleteEvent {
	
    @GET
    @Path("/deleteEvent")  
    @Produces(MediaType.APPLICATION_JSON) 
 
    public String deleteEvent(@QueryParam("eventID") long eventID) {
        
    	String response = "";
    	boolean status = DatabaseWrite.deleteEvent(eventID);
        
    	if(status) {
    		response = UtilityClass.constructJSON("deleteEvent", true);
    	}
    	else {
    		response = UtilityClass.constructJSON("deleteEvent", false, "Error Occured");
    	}
        
        return response;
 
    }
 
}
