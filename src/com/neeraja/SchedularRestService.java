/**
 * 
 */
package com.neeraja;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.text.ParseException;
import java.text.SimpleDateFormat;  

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;


@Path("/Schedule") 
@Produces({MediaType.APPLICATION_JSON})
/*
 * This method consumes the application_Json and return the status accepted and passes delivery date and message.
 */
public class SchedularRestService {
	
	private static Logger log = Logger.getLogger(SchedularRestService.class);

	@POST
    @Path("/message")
	@Consumes({MediaType.APPLICATION_JSON})
/*
 * This method returns the response status 	
 */
	public Response recieveMessageInfo(ScheduleWrapper input) {
		schedulePrint(input.getDeliveryDate(),input.getMessage());
		return Response.status(javax.ws.rs.core.Response.Status.ACCEPTED).build();
 
	}
	
	public static void schedulePrint(String deliveryDate,String message){
	   SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
	   Date formattedDate;
	   try {
		   formattedDate = formatter.parse(deliveryDate);
		   Timer currTimer = new Timer();	
		   currTimer.schedule(new TimerTask() {
		   public void run() {
			   log.info("Delivery Message :-"+message);
			    }
			}, formattedDate);
		} 
	   	catch (ParseException e) {
	   		  log.error(e.getMessage());
	   	}
    }
}
