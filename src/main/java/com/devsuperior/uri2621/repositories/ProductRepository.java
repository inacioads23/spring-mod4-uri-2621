package com.devsuperior.uri2621.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.uri2621.dto.ProductMinDto;
import com.devsuperior.uri2621.entities.Product;
import com.devsuperior.uri2621.projection.ProductMinProjection;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	// SQL nativo
	@Query(nativeQuery = true, value="SELECT pd.name "
			+ "FROM products pd "
			+ "INNER JOIN providers pr ON pd.id_providers = pr.id "
			+ "WHERE pd.amount BETWEEN :min AND :max "
			+ "AND pr.name LIKE CONCAT(UPPER(:beginName), '%')")
	List<ProductMinProjection> search1(Integer min, Integer max, String beginName);

	// JPQL		   Busca novos objetos desse tipo, passa o construtor(id, name)
	@Query("SELECT new com.devsuperior.uri2621.dto.ProductMinDto(pd.name) "
			+ "FROM Product pd " // usa o nome da 'classe Entity'
			+ "WHERE pd.amount BETWEEN :min AND :max " 
			+ "AND pd.provider.name LIKE CONCAT(UPPER(:beginName), '%')") // acesso via objeto 'Product' (Product-> Provider-> name)
	List<ProductMinDto> search2(Integer min, Integer max, String beginName);
}
