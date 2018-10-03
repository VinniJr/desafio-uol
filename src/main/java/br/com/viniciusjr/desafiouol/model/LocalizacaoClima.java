package br.com.viniciusjr.desafiouol.model;

public class LocalizacaoClima {
	 private float id;
	 private String weather_state_name;
	 private String weather_state_abbr;
	 private String wind_direction_compass;
	 private String created;
	 private String applicable_date;
	 private float min_temp;
	 private float max_temp;
	 private String the_temp;
	 private float wind_speed;
	 private float wind_direction;	
	 private String air_pressure;
	 private float humidity;
	 private float visibility;
	 private float predictability;
	 private String detail;

	 	
	 // Getter Methods 

	 public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public float getId() {
	  return id;
	 }

	 public String getWeather_state_name() {
	  return weather_state_name;
	 }

	 public String getWeather_state_abbr() {
	  return weather_state_abbr;
	 }

	 public String getWind_direction_compass() {
	  return wind_direction_compass;
	 }

	 public String getCreated() {
	  return created;
	 }

	 public String getApplicable_date() {
	  return applicable_date;
	 }

	 public float getMin_temp() {
	  return min_temp;
	 }

	 public float getMax_temp() {
	  return max_temp;
	 }

	 public String getThe_temp() {
	  return the_temp;
	 }

	 public float getWind_speed() {
	  return wind_speed;
	 }

	 public float getWind_direction() {
	  return wind_direction;
	 }

	 public String getAir_pressure() {
	  return air_pressure;
	 }

	 public float getHumidity() {
	  return humidity;
	 }

	 public float getVisibility() {
	  return visibility;
	 }

	 public float getPredictability() {
	  return predictability;
	 }

	 // Setter Methods 

	 public void setId(float id) {
	  this.id = id;
	 }

	 public void setWeather_state_name(String weather_state_name) {
	  this.weather_state_name = weather_state_name;
	 }

	 public void setWeather_state_abbr(String weather_state_abbr) {
	  this.weather_state_abbr = weather_state_abbr;
	 }

	 public void setWind_direction_compass(String wind_direction_compass) {
	  this.wind_direction_compass = wind_direction_compass;
	 }

	 public void setCreated(String created) {
	  this.created = created;
	 }

	 public void setApplicable_date(String applicable_date) {
	  this.applicable_date = applicable_date;
	 }

	 public void setMin_temp(float min_temp) {
	  this.min_temp = min_temp;
	 }

	 public void setMax_temp(float max_temp) {
	  this.max_temp = max_temp;
	 }

	 public void setThe_temp(String the_temp) {
	  this.the_temp = the_temp;
	 }

	 public void setWind_speed(float wind_speed) {
	  this.wind_speed = wind_speed;
	 }

	 public void setWind_direction(float wind_direction) {
	  this.wind_direction = wind_direction;
	 }

	 public void setAir_pressure(String air_pressure) {
	  this.air_pressure = air_pressure;
	 }

	 public void setHumidity(float humidity) {
	  this.humidity = humidity;
	 }

	 public void setVisibility(float visibility) {
	  this.visibility = visibility;
	 }

	 public void setPredictability(float predictability) {
	  this.predictability = predictability;
	 }
	
	
}
