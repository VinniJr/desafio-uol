package br.com.viniciusjr.desafiouol.model.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
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
	 
	
}
