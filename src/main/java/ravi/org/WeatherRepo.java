package ravi.org;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import models.TempModel;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
@Repository
public interface WeatherRepo extends MongoRepository<TempModel,Timestamp>{

	List<TempModel> findByTemptimestampBetween(Date t1, Date t2);

}
