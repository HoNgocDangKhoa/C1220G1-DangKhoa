package com.example.repository.impl;

import com.example.model.Product;
import com.example.repository.ProductRepository;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;


@Transactional
@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Product> findAll() {
        TypedQuery<Product> query = em.createQuery("select c from Product c", Product.class);

        return query.getResultList();
    }

    @Override
    public void saveProduct(Product product) {
        em.merge(product);
    }

    @Override
    public void updateProduct(int id, Product product) {
        em.persist(product);

    }

    @Override
    public void deleteProduct(int id) {
        Product product = findById(id);
        if (product != null) {
            em.remove(product);
        }
    }

    @Override
    public Product findById(int id) {
        return em.find(Product.class, id);
    }
}
