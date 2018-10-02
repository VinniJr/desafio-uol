package br.com.viniciusjr.desafiouol.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.viniciusjr.desafiouol.model.Localizacao;

@Service
public class LocalizacaoService {
	
	@Autowired
	private HttpServletRequest request;
	
	/**
	 * API aberta de geolocalização por IP https://www.ipvigilante.com/ 
	 * @return JSON
	 * */
	public Localizacao obterLocalizacao() {
		RestTemplate restTemplate = new RestTemplate();
		try {
			return restTemplate.getForObject("https://ipvigilante.com/json/"+obterIpCliente(), Localizacao.class);
		}catch(Exception e) {
			return restTemplate.getForObject("https://ipvigilante.com/json/"+"8.8.8.8", Localizacao.class);
		}
	}
	
	/**
	 * Obtem IP do cliente por request
	 * */
	public String obterIpCliente() {
		String ipAddress = request.getHeader("X-FORWARDED-FOR");  
		if (ipAddress == null) {  
			ipAddress = request.getRemoteAddr();  
		}
		return ipAddress;
	}
	
	

}
