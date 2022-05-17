package sn.simplon.GestionStockSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.simplon.GestionStockSpring.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	// Méthode pour récupérer le produit par son nom
	Product findByName(String name);

}
