package br.com.viniciusjr.desafiouol.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.viniciusjr.desafiouol.model.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
	
	@Query("SELECT cli FROM Cliente cli")
	@Override
	public Iterable<Cliente> findAll();
	
	@Query("SELECT cli FROM Cliente cli WHERE cli.id = :id")
	public Cliente buscarClientePorId(@Param("id") Long id);
	
}
