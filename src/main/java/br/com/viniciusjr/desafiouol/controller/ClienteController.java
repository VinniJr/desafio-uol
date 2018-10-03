package br.com.viniciusjr.desafiouol.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.viniciusjr.desafiouol.model.Cliente;
import br.com.viniciusjr.desafiouol.model.Geolocalizacao;
import br.com.viniciusjr.desafiouol.model.LocalizacaoClima;
import br.com.viniciusjr.desafiouol.service.ClienteService;
import br.com.viniciusjr.desafiouol.service.LocalizacaoService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private LocalizacaoService local;
	
	

	@RequestMapping(method = RequestMethod.GET, value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Cliente>> getAll() {
		
		System.out.println("Temp "+String.valueOf(local.obterLocalClima().getMax_temp()));
		
		List<Cliente> cli = (List<Cliente>) clienteService.buscarTodos();
		return new ResponseEntity<List<Cliente>>(cli, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/cadastrar", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente) {
		Cliente clienteCadastrado = clienteService.cadastrar(cliente);
		return new ResponseEntity<Cliente>(clienteCadastrado, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/excluir/{id}")
	public ResponseEntity<Cliente> excluirCliente(@PathVariable Long id) {
		clienteService.excluir(id);
		return new ResponseEntity<Cliente>(HttpStatus.OK);
	}

}
