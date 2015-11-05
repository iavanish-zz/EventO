package iavanish.REST;

import iavanish.Database.DatabaseWrite;
import iavanish.Database.UtilityClass;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/modifyEvent")
public class ModifyEvent {
	
    @GET
    @Path("/modifyEvent")  
    @Produces(MediaType.APPLICATION_JSON) 
 
    public String modifyEvent(@QueryParam("eventID") long eventID, @QueryParam("name") String name, @QueryParam("date") String date, @QueryParam("time") String time) {
        
    	String response = "";
    	boolean status = false;
    	
    	if(UtilityClass.isNotNull(name) && UtilityClass.isNotNull(date) && UtilityClass.isNotNull(time)) {
            status = DatabaseWrite.modifyEvent(eventID, name, date, time);
    	}
        
    	if(status) {
    		response = UtilityClass.constructJSON("modifyEvent", true);
    	}
    	else {
    		response = UtilityClass.constructJSON("modifyEvent", false, "Error Occured");
    	}
        
        return response;
 
    }
 
}
