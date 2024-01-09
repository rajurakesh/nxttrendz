package com.example.nxttrendz1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;
import java.util.List;
import com.example.nxttrendz1.repository.ProductRepository;
import com.example.nxttrendz1.model.Product;
import com.example.nxttrendz1.repository.ProductJpaRepository;

@Service
public class ProductJpaService implements ProductRepository {
	@Autowired
	private ProductJpaRepository productJpaRepository;

	@Override
	public ArrayList<Product> getProducts() {
		List<Product> productList = productJpaRepository.findAll();
		ArrayList<Product> products = new ArrayList<>(productList);
		return products;
	}

	@Override
	public Product addProduct(Product product) {
		productJpaRepository.save(product);
		return product;
	}

	@Override
	public Product getProductById(int productId) {
		try {
			Product product = productJpaRepository.findById(productId).get();
			return product;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Product updateProduct(int productId, Product product) {
		try {
			Product newProduct = productJpaRepository.findById(productId).get();
			if (product.getProductName() != null) {
				newProduct.setProductName(product.getProductName());
			}
			if (product.getPrice() != 0) {
				newProduct.setPrice(product.getPrice());
			}
			productJpaRepository.save(newProduct);
			return newProduct;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public void deleteProduct(int productId) {
		productJpaRepository.deleteById(productId);

	}

}