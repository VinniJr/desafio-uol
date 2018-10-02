package br.com.viniciusjr.desafiouol.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.viniciusjr.desafiouol.model.Cliente;
import br.com.viniciusjr.desafiouol.model.Localizacao;
import br.com.viniciusjr.desafiouol.repository.ClienteRepository;
import br.com.viniciusjr.desafiouol.service.util.UtilService;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;
    
    @Autowired
    UtilService util;
    
    
   
   
    public Cliente cadastrar(Cliente cliente){
        return clienteRepository.save(cliente);
    }
   
    public List<Cliente> buscarTodos(){
    	local();
        return (List<Cliente>) clienteRepository.findAll();
    }

    public void excluir(Long id){
        clienteRepository.deleteById(id);
    }

    public Optional<Cliente> buscarPorId(Long id) {
        return clienteRepository.findById(id);
    }

    public Cliente alterar(Cliente cliente){
        return clienteRepository.save(cliente);
    }
    
    public void local() {
    	RestTemplate restTemplate = new RestTemplate();
    	Localizacao localizacao = restTemplate.getForObject("https://ipvigilante.com/8.8.8.8", Localizacao.class);
    	System.out.println("JSON: "+ localizacao);
    }
    
    

}
