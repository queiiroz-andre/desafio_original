package br.com.original.queiroz.desafio_original.repositories;

import java.util.List;
import java.util.Optional;

import br.com.original.queiroz.desafio_original.presenters.Dieta;

public interface DietaRepository {
	
	
	List<Dieta> getAll();
	Dieta get(Integer id);
	void delete(Integer id);
	Dieta save(Dieta dieta); 
	
	Optional<Dieta> findById(Integer id);
}
