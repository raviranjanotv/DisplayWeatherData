package controller;

import java.sql.Timestamp;
//import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

//import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import models.TempModel;
import ravi.org.WeatherRepo;

@RestController
public class WeatherDisplayController {
@Autowired
WeatherRepo repo;

@GetMapping("/getData")
public List<TempModel> getData()
{
	for (TempModel tempmodel : repo.findAll()) {
		System.out.println(tempmodel.getTemprature());
		System.out.println(tempmodel.getTemptimestamp());
		}
	return repo.findAll();
	 
	
	}
 //@SuppressWarnings("unchecked")
@GetMapping("/getDataByRange")
 public List<TempModel> getDataByRange()
    {
	 Timestamp timestamp = new Timestamp(System.currentTimeMillis()-90000);
	 
     Date date1 = new Date(timestamp.getTime());
     
     Timestamp timestamp2 = new Timestamp(System.currentTimeMillis()-40000);
     
     Date date2 = new Date(timestamp2.getTime());
     
	 List<TempModel> l1=repo.findByTemptimestampBetween(date1, date2);
	 
	 return l1;
	}
	
}
