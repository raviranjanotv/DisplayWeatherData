package ravi.org;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

	@Autowired
	WeatherDataSaver datasaver;
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        datasaver.saveData();
        
    }
}