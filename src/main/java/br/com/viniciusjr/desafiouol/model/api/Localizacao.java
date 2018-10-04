package br.com.viniciusjr.desafiouol.model.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Localizacao {
	private String status;
	 Data DataObject;

	 public String getStatus() {
	  return status;
	 }

	 public Data getData() {
	  return DataObject;
	 }


}
