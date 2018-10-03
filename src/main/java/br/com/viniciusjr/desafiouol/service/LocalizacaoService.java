package br.com.viniciusjr.desafiouol.service;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import br.com.viniciusjr.desafiouol.model.Geolocalizacao;
import br.com.viniciusjr.desafiouol.model.Localizacao;
import br.com.viniciusjr.desafiouol.model.LocalizacaoClima;

@Service
public class LocalizacaoService {

	@Autowired
	private HttpServletRequest request;

	RestTemplate restTemplate;

	/**
	 * API aberta de geolocalização por IP https://www.ipvigilante.com/
	 * 
	 * @return JSON
	 */
	public Localizacao obterLocalizacao() {
		restTemplate = new RestTemplate();
		try {
			return restTemplate.getForObject("https://ipvigilante.com/json/" + obterIpCliente(), Localizacao.class);
		} catch (Exception e) {
			return restTemplate.getForObject("https://ipvigilante.com/json/" + "8.8.8.8", Localizacao.class);
		}
	}

	public LocalizacaoClima obterLocalClima() {
		Localizacao local = obterLocalizacao();
		restTemplate = new RestTemplate();
		LocalizacaoClima[] listaClima = null;
		
		
		ResponseEntity<Geolocalizacao[]> responseEntity = restTemplate.getForEntity("https://www.metaweather.com/api/location/search/?lattlong="
		+ local.getData().getLatitude() + "," + local.getData().getLongitude(), Geolocalizacao[].class);
		Geolocalizacao[] lista = responseEntity.getBody();
		for (Geolocalizacao geolocalizacao : lista) {
			System.out.println("Woeid: "+geolocalizacao.getWoeid());
						
					
					try {
						restTemplate = new RestTemplate();
				
						ResponseEntity<LocalizacaoClima[]> respEntity = restTemplate.getForEntity("https://www.metaweather.com/api/location/"
							+geolocalizacao.getWoeid().toString().replace(".", "")+obterParamData(), LocalizacaoClima[].class);
						listaClima = respEntity.getBody();
					}
					catch(Exception e) {
					}
					}
				
		

		return listaClima[0];
	}
	

	public String obterParamData() {
		Date data = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		String dia = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
		String mes = String.valueOf(cal.get(Calendar.MONTH));
		String ano = String.valueOf(cal.get(Calendar.YEAR));

		return "/" + ano + "/" + mes + "/" + dia;
	}

	/**
	 * Obtem IP do cliente por request
	 */
	public String obterIpCliente() {
		String ipAddress = request.getHeader("X-FORWARDED-FOR");
		if (ipAddress == null) {
			ipAddress = request.getRemoteAddr();
		}
		return ipAddress;
	}

}
