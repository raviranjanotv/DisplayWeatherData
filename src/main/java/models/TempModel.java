package models;
import java.util.Date;

public class TempModel {
	private Double temprature;
	private Date temptimestamp;
public Double getTemprature() {
		return temprature;
	}
	public void setTemprature(Double temprature) {
		this.temprature = temprature;
	}
	public TempModel() {
		super();
	}
	public Date getTemptimestamp() {
		return temptimestamp;
	}
	public void setTemptimestamp(Date d1) {
		this.temptimestamp = d1;
	}
	public TempModel(Double temprature, Date temptimestamp) {
		super();
		this.temprature = temprature;
		this.temptimestamp = temptimestamp;
	}
	@Override
	public String toString() {
		return "TempModel [temprature=" + temprature + ", temptimestamp=" + temptimestamp + "]";
	}


	
	
}
