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
		    
		    
		    
		   /* JSONParser parser = new JSONParser();
		    Double temp = null;
		    Date d1= new Date();
	        //BasicDBObject timeNow = new BasicDBObject("date", d1);
		    try {
	            Object obj = parser.parse(data);
	            JSONObject jo = (JSONObject) obj;
	            Map<?, ?> mp = ((Map<?, ?>)jo.get("main"));
	            Iterator<?> itr1 = mp.entrySet().iterator();
	            while (itr1.hasNext()) 
	            {
	                @SuppressWarnings("rawtypes")
					Map.Entry pair = (Entry) itr1.next();
	                if(pair.getKey().equals("temp")){
	                temp=(Double) pair.getValue();
	                	}
	              }
	           // service.saveData(temp, d1);
	           // System.out.println("Data is Being Saved...");
	           
	        } catch (Exception e) {
	            e.printStackTrace();
	            */
	            
		        System.out.println("Data is Being Saved...");
	            service.saveData(temp, d1);
	            
	            
	        
		    return temp;
		    
		    
		    
		}
	
}
