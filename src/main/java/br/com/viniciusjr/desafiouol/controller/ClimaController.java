package br.com.viniciusjr.desafiouol.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.viniciusjr.desafiouol.model.Clima;
import br.com.viniciusjr.desafiouol.service.ClimaService;

@RestController
@RequestMapping("/clima")
public class ClimaController {
	
	@Autowired
	private ClimaService climaService;
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/obterClimaCliente/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Clima> buscarPorCliente(@PathVariable Long id) {
		Clima clima = climaService.buscarPorCliente(id);
		return new ResponseEntity<Clima>(clima, HttpStatus.OK);
	}

}
