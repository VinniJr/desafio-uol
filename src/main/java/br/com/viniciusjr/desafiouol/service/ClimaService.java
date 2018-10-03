package br.com.viniciusjr.desafiouol.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.viniciusjr.desafiouol.model.Clima;
import br.com.viniciusjr.desafiouol.repository.ClimaRepository;

@Service
public class ClimaService {
	@Autowired
	ClimaRepository climaRepo;

	public Clima cadastrar(Clima clima) {
		return climaRepo.save(clima);
	}

	public Optional<Clima> buscarPorId(Long id) {
		return climaRepo.findById(id);
	}
	
	public Clima buscarPorWeidData(Long woeid, LocalDate data) {
		return climaRepo.buscarPorWeidData(woeid, data);
	}
	
	public Clima buscarPorCliente(Long id) {
		return climaRepo.buscarPorCliente(id);
	}
}
