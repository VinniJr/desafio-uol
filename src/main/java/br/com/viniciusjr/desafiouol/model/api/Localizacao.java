package br.com.viniciusjr.desafiouol.model.api;

public class Localizacao {
	private String status;
	 Data DataObject;

	 public String getStatus() {
	  return status;
	 }

	 public Data getData() {
	  return DataObject;
	 }

	 public void setStatus(String status) {
	  this.status = status;
	 }

	 public void setData(Data dataObject) {
	  this.DataObject = dataObject;
	 }
}
