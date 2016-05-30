package br.com.rafael.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.rafael.entity.ProductDetail;

@Repository
public interface ProductDetailRepository extends PagingAndSortingRepository<ProductDetail, String> {

}
