package br.com.viniciusjr.desafiouol.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.viniciusjr.desafiouol.model.Cliente;
import br.com.viniciusjr.desafiouol.repository.ClienteRepository;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;
   
   
    public Cliente cadastrar(Cliente cliente){
        return clienteRepository.save(cliente);
    }
   
    public List<Cliente> buscarTodos(){
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

    

}
