package br.com.viniciusjr.desafiouol.model.api;

public class Geolocalizacao {
	 private Double distance;
	 private String title;
	 private String location_type;
	 private Long woeid;
	 private String latt_long;


	 // Getter Methods 


	 public String getTitle() {
	  return title;
	 }

	 public String getLocation_type() {
	  return location_type;
	 }


	 public String getLatt_long() {
	  return latt_long;
	 }

	 // Setter Methods 


	 public void setTitle(String title) {
	  this.title = title;
	 }

	 public void setLocation_type(String location_type) {
	  this.location_type = location_type;
	 }


	 public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}


	public Long getWoeid() {
		return woeid;
	}

	public void setWoeid(Long woeid) {
		this.woeid = woeid;
	}

	public void setLatt_long(String latt_long) {
	  this.latt_long = latt_long;
	 }

}
