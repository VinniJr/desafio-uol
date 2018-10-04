package br.com.viniciusjr.desafiouol.service;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.viniciusjr.desafiouol.model.Clima;
import br.com.viniciusjr.desafiouol.model.api.Geolocalizacao;
import br.com.viniciusjr.desafiouol.model.api.Localizacao;
import br.com.viniciusjr.desafiouol.model.api.LocalizacaoClima;

@Service
public class LocalizacaoService {

	private static final String SC = "search/?lattlong=";

	private static final String API_IPVIGILANT = "https://ipvigilante.com/json/";

	private static final String API_LOCATION = "https://www.metaweather.com/api/location/";

	@Autowired
	private HttpServletRequest request;
	
	
	Clima clima = new Clima();

	RestTemplate restTemplate;

	/**
	 * API aberta de geolocalização por IP https://www.ipvigilante.com/
	 * 
	 * @return JSON
	 */
	public Localizacao obterLocalizacao() {
		restTemplate = new RestTemplate();
		try {
			return restTemplate.getForObject(API_IPVIGILANT + obterIpCliente(), Localizacao.class);
		} catch (Exception e) {
			return restTemplate.getForObject(API_IPVIGILANT + "8.8.8.8", Localizacao.class);
		}
	}

	/**
	 * Retorna objeto com a temperatura e do dia e local
	 * */
	public Clima obterLocalClima() {
		
		Localizacao local = obterLocalizacao();
		restTemplate = new RestTemplate();
		ResponseEntity<Geolocalizacao[]> responseEntity =null;
		String LAT = local.getData().getLatitude();
		String LONG = local.getData().getLongitude();
		
		responseEntity = restTemplate.getForEntity(API_LOCATION+SC+ LAT + "," + LONG, Geolocalizacao[].class);
		
		Geolocalizacao[] lista = responseEntity.getBody();
		obtemClimaPorLocalidadeData(lista);

		return clima;
	}

	private void obtemClimaPorLocalidadeData(Geolocalizacao[] lista) {
		LocalizacaoClima[] listaClima;
		for (Geolocalizacao geolocalizacao : lista) {
			try {
				restTemplate = new RestTemplate();

				ResponseEntity<LocalizacaoClima[]> respEntity = 
						restTemplate.getForEntity(API_LOCATION+geolocalizacao.getWoeid()+obterParamData(),LocalizacaoClima[].class);
				listaClima = respEntity.getBody();
				montarClima(listaClima, geolocalizacao);
				break;
			} catch (Exception e) {
			}
		}
	}

	private void montarClima(LocalizacaoClima[] listaClima, Geolocalizacao geolocalizacao) {
		clima.setData(LocalDate.now());
		clima.setWoeid(geolocalizacao.getWoeid());
		clima.setTempMin(listaClima[0].getMin_temp());
		clima.setTempMax(listaClima[0].getMax_temp());
	}

	/**
	 * Obtem data do servidor para passar como parametro de consulta da API
	 * */
	public String obterParamData() {
		Date data = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		String dia = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
		String mes = String.valueOf(cal.get(Calendar.MONTH)+1);
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
