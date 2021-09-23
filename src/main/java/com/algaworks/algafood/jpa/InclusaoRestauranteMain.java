package com.algaworks.algafood.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

public class InclusaoRestauranteMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		RestauranteRepository restaurantes = applicationContext.getBean(RestauranteRepository.class);
		
		Restaurante r1 = new Restaurante();
		r1.setNome("Padaria e Restaurante do Ruan");
		r1.setTaxaFrete(2.50);
		
		Restaurante r2 = new Restaurante();
		r2.setNome("Bar do Marcelo");
		r2.setTaxaFrete(2.50);
		
		
		r1 = restaurantes.save(r1);
		r2 = restaurantes.save(r2);
		
		System.out.printf("%d - %s\n", r1.getId(), r1.getNome());
		System.out.printf("%d - %s\n", r2.getId(), r2.getNome());
	}
	
}
