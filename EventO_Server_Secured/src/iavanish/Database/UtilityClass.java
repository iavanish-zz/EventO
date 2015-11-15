package iavanish.Database;

import java.util.Iterator;
import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class UtilityClass {

    public static boolean isNotNull(String text) {
        return (((text != null) && (text.trim().length() >= 0)) ? true : false);
    }

    public static String constructJSON(String tag, boolean status) {
        
    	JSONObject obj = new JSONObject();
        try {
        	obj.put("tag", tag);
            obj.put("status", new Boolean(status));
        } 
        catch(JSONException e) {
            e.printStackTrace();
        }
        return obj.toString();
        
    }

    public static String constructJSON(String tag, boolean status, String errorMessage) {
    	
        JSONObject obj = new JSONObject();
        try {
            obj.put("tag", tag);
            obj.put("status", new Boolean(status));
            obj.put("errorMessage", errorMessage);
        } 
        catch(JSONException e) {
            e.printStackTrace();
        }
        return obj.toString();
        
    }
    
    public static String constructJSON(List <User> users) {
    	
    	JSONObject usersObj = new JSONObject();
    			
    	try {
    		
    		JSONArray userArray = new JSONArray();
    	
    		Iterator <User> iterator = users.iterator();
    	
    		while(iterator.hasNext()) {
    		
    			User user = (User)iterator.next();
    		
    			JSONObject temp = new JSONObject();
    			temp.put("rollNo", user.rollNo);
    			temp.put("name", user.name);
    			temp.put("typeOfUser", user.typeOfUser);
    			temp.put("emailID", user.emailID);
    			
    			userArray.put(temp);
    			
    		}
    		
    		usersObj.put("users", userArray);
    		
    	}
    	
    	catch(JSONException e) {
    		e.printStackTrace();
    	}
    	
    	return usersObj.toString();
    	
    }
    
    public static String constructJSON(List <Event> events, boolean flag) {
    	
    	JSONObject eventsObj = new JSONObject();
    			
    	try {
    		
    		JSONArray eventArray = new JSONArray();
    	
    		Iterator <Event> iterator = events.iterator();
    	
    		while(iterator.hasNext()) {
    		
    			Event event = (Event)iterator.next();
    		
    			JSONObject temp = new JSONObject();
    			temp.put("eventID", event.eventID);
    			temp.put("name", event.name);
    			temp.put("date", event.date);
    			temp.put("time", event.time);
    			temp.put("rollNo", event.rollNo);
    			
    			eventArray.put(temp);
    			
    		}
    		
    		eventsObj.put("events", eventArray);
    		
    	}
    	
    	catch(JSONException e) {
    		e.printStackTrace();
    	}
    	
    	return eventsObj.toString();
    	
    }
    
    public static String constructJSON(User user) {
    	
    	JSONObject userObj = new JSONObject();
    			
    	try {
    		
    		JSONObject temp = new JSONObject();
			temp.put("rollNo", user.rollNo);
			temp.put("name", user.name);
			temp.put("typeOfUser", user.typeOfUser);
			temp.put("emailID", user.emailID);
    		
    		userObj.put("user", temp);
    		
    	}
    	
    	catch(JSONException e) {
    		e.printStackTrace();
    	}
    	
    	return userObj.toString();
    	
    }
 
}