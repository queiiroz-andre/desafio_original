package br.com.original.queiroz.desafio_original.repositories;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import br.com.original.queiroz.desafio_original.presenters.Dieta;

@Repository 
public class DietaRepositoryImpl implements DietaRepository {

	private static final Map<Integer, Dieta> DIETAS_DB = new HashMap<>();
	
	private static final Comparator<Dieta> COMPARATOR = (d1 , d2) -> d2.getCodigo().compareTo(d1.getCodigo());
	
	public DietaRepositoryImpl() { 
	
		var retorno = new Dieta(); 
		retorno.setCodigo(1);
		retorno.setConteudo("4 Carboidrato , 6 proteinas");
		retorno.setMeses(2);
		retorno.setNome("Magresa");
		DIETAS_DB.put(1,retorno);
		
			
		retorno = new Dieta(); 
		retorno.setCodigo(3);
		retorno.setConteudo("2 Carboidrato , 4 proteinas");
		retorno.setMeses(6);
		retorno.setNome("Sobrepeso");
		DIETAS_DB.put(3,retorno);


		retorno = new Dieta(); 
		retorno.setCodigo(4);
		retorno.setConteudo("1 Carboidrato , 2 proteinas");
		retorno.setMeses(8);
		retorno.setNome("Obesidade");
		DIETAS_DB.put(4,retorno);


		retorno = new Dieta(); 
		retorno.setCodigo(2);
		retorno.setConteudo("4 Carboidrato , 4 proteinas");
		retorno.setMeses(4);
		retorno.setNome("Normal");
		DIETAS_DB.put(2,retorno);
		
	}

	@Override
	public List<Dieta> getAll() {
		return DIETAS_DB.values()				
				.stream()
				.sorted(COMPARATOR)
				.collect(Collectors.toList());
		
	}

	@Override
	public Dieta get(Integer id) {
		return DIETAS_DB.get(id);
		
	}

	@Override
	public void delete(Integer id) {
		var dieta = get(id);
		if(dieta != null) {
			DIETAS_DB.remove(id);
		}
		
	}

	@Override
	public Dieta save(Dieta dieta) {
		if(dieta != null) {
			delete(dieta.getCodigo());
			DIETAS_DB.put(dieta.getCodigo(), dieta); 
		}
		return dieta;
		
	}

	@Override
	public Optional<Dieta> findById(Integer id) {
		
		var item = get(id);
		
		if(item != null) {
			return Optional.of(item);
		}
		
		return Optional.empty(); 
		
		
	}
	
	
	
}
