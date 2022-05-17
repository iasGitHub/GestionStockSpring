package sn.simplon.GestionStockSpring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sn.simplon.GestionStockSpring.model.Product;
import sn.simplon.GestionStockSpring.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	// Méthode qui ns permet d'enregistrer un produit
	public Product saveProduct(Product product) {
		return repository.save(product);
	}
	
	// Méthode qui ns permet d'enregistrer une liste de produits
	public List<Product> saveProducts(List<Product> products) {
		return repository.saveAll(products);
	}
	
	// Méthode qui ns permet de récupérer tous les produit
	public List<Product> getProducts() {
		return repository.findAll();
	}
	
	// Méthode qui ns permet de récupérer un produit via son id
	public Product getProductById(int id) {
		return repository.findById(id).orElse(null);
	}
	
	// Méthode qui ns permet de récupérer un produit via son nom
	public Product getProductByName(String name) {
		return repository.findByName(name);
	}
	
	// Méthode qui ns permet de supprimer un produit via son id
	public String deleteProduct(int id) {
		repository.deleteById(id);
		return "Product " + id + "removed successfully !";
	}

	public Product updateProduct(Product product) {
		 Product existingProduct = repository.findById(product.getId()).orElse(null);
	     existingProduct.setName(product.getName());
	     existingProduct.setQuantity(product.getQuantity());
	     existingProduct.setPrice(product.getPrice());
	     return repository.save(existingProduct);
	}
	


}
