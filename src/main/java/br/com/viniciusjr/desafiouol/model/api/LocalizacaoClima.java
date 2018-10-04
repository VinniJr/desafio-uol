package br.com.viniciusjr.desafiouol.model.api;

public class LocalizacaoClima {
	 private Long id;
	 private String weather_state_name;
	 private String weather_state_abbr;
	 private String wind_direction_compass;
	 private String created;
	 private String applicable_date;
	 private Double min_temp;
	 private Double max_temp;
	 private String the_temp;
	 private Double wind_speed;
	 private Double wind_direction;	
	 private String air_pressure;
	 private Double humidity;
	 private Double visibility;
	 private Double predictability;
	 private String detail;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getWeather_state_name() {
		return weather_state_name;
	}
	public void setWeather_state_name(String weather_state_name) {
		this.weather_state_name = weather_state_name;
	}
	public String getWeather_state_abbr() {
		return weather_state_abbr;
	}
	public void setWeather_state_abbr(String weather_state_abbr) {
		this.weather_state_abbr = weather_state_abbr;
	}
	public String getWind_direction_compass() {
		return wind_direction_compass;
	}
	public void setWind_direction_compass(String wind_direction_compass) {
		this.wind_direction_compass = wind_direction_compass;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public String getApplicable_date() {
		return applicable_date;
	}
	public void setApplicable_date(String applicable_date) {
		this.applicable_date = applicable_date;
	}
	public Double getMin_temp() {
		return min_temp;
	}
	public void setMin_temp(Double min_temp) {
		this.min_temp = min_temp;
	}
	public Double getMax_temp() {
		return max_temp;
	}
	public void setMax_temp(Double max_temp) {
		this.max_temp = max_temp;
	}
	public String getThe_temp() {
		return the_temp;
	}
	public void setThe_temp(String the_temp) {
		this.the_temp = the_temp;
	}
	public Double getWind_speed() {
		return wind_speed;
	}
	public void setWind_speed(Double wind_speed) {
		this.wind_speed = wind_speed;
	}
	public Double getWind_direction() {
		return wind_direction;
	}
	public void setWind_direction(Double wind_direction) {
		this.wind_direction = wind_direction;
	}
	public String getAir_pressure() {
		return air_pressure;
	}
	public void setAir_pressure(String air_pressure) {
		this.air_pressure = air_pressure;
	}
	public Double getHumidity() {
		return humidity;
	}
	public void setHumidity(Double humidity) {
		this.humidity = humidity;
	}
	public Double getVisibility() {
		return visibility;
	}
	public void setVisibility(Double visibility) {
		this.visibility = visibility;
	}
	public Double getPredictability() {
		return predictability;
	}
	public void setPredictability(Double predictability) {
		this.predictability = predictability;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	 
	 
	
	
}
