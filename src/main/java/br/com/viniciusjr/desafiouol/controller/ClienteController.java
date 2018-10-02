package br.com.viniciusjr.desafiouol.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import br.com.viniciusjr.desafiouol.service.ClienteService;
import br.com.viniciusjr.desafiouol.service.util.UtilService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private UtilService util;

	@RequestMapping(method = RequestMethod.GET, value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Cliente>> getAll() {
		List<Cliente> cli = (List<Cliente>) clienteService.buscarTodos();
		return new ResponseEntity<List<Cliente>>(cli, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/cadastrar", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente,HttpServletRequest request) {
	
		cliente.setIp(util.getClientIpAddress(request));
		Cliente clienteCadastrado = clienteService.cadastrar(cliente);
		return new ResponseEntity<Cliente>(clienteCadastrado, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/excluir/{id}")
	public ResponseEntity<Cliente> excluirCliente(@PathVariable Long id) {
		clienteService.excluir(id);
		return new ResponseEntity<Cliente>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/obter-ip", method = RequestMethod.GET)
	public String getIp(HttpServletRequest request) {

		return util.getClientIpAddress(request);

	}

}
