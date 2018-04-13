package ravi.org;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import models.TempModel;

@Service
public class SaveService {
@Autowired	
WeatherRepo repo;
	
public void saveData(Double temprature,  Date d1)	{
	TempModel m1=new TempModel();
	m1.setTemprature(temprature);
	m1.setTemptimestamp(d1);
    repo.save(m1);
	}


}
