package br.com.viniciusjr.desafiouol.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.viniciusjr.desafiouol.model.Clima;

public interface ClimaRepository extends CrudRepository<Clima, Long> {
	
	@Query("SELECT cli FROM Clima cli WHERE cli.woeid = :woeid and  cli.data = :data")
	public Clima buscarPorWeidData(@Param("woeid") Long woeid, @Param("data")LocalDate data);

	@Query("SELECT clima FROM Cliente cli JOIN cli.clima clima WHERE cli.id = :id")
	public Clima buscarPorCliente(@Param("id") Long id);
	
	
	
}
