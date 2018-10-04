package br.com.viniciusjr.desafiouol.model.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Geolocalizacao {
	 private Double distance;
	 private String title;
	 private String location_type;
	 private Long woeid;
	 private String latt_long;


}
