package com.neeraja;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ScheduleWrapper {
	
	  private String message;
      private String deliveryDate;
	  
      public ScheduleWrapper(){} 

	   public void setMessage(String message) { 
	      this.message = message; 
	   } 
	   public String getMessage() { 
	      return message; 
	   } 
	   public void setdeliveryDate(String deliveryDate) { 
	      this.deliveryDate = deliveryDate; 
	   } 
	   
	   public String getDeliveryDate() { 
		      return deliveryDate; 
	   } 
}
