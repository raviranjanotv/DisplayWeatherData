package ravi.org;

//import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.mongodb.util.JSON;

import models.RootObject;

//import com.mongodb.BasicDBObject;

@Component
public class WeatherDataSaver {

	    @Autowired
	    SaveService service;
		public Double saveData()
		{
		    final String uri="http://samples.openweathermap.org/data/2.5/weather?lat=20&lon=77&appid=116c411664db76b6aa7594f525bcdaee"; 
		    RestTemplate restTemplate = new RestTemplate();
		    
		    
		    String data = restTemplate.getForObject(uri,String.class);
		    
		    Gson gson = new Gson();
		    
		    RootObject data1 = gson.fromJson(data, RootObject.class);
		    
		    Double temp=data1.getMain().getTempMax();
		    double max_temp=data1.getMain().getTempMax();
		    double min_temp=data1.getMain().getTempMin();
		    System.out.println("=====================================================");
		    System.out.println("temp:= "+temp+" max temp:= "+max_temp+" min_temp:= "+min_temp);
		    
		    Date d1= new Date();
		    
		    System.out.println("Data is Being Saved...");
	        service.saveData(temp, d1);
	            
	            
	        
		    return temp;
		    
		    
		    
		}
	
}
