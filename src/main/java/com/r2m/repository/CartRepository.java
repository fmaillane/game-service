package com.r2m.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.r2m.model.Cart;
import com.r2m.model.User;

@RepositoryRestResource
public interface CartRepository extends PagingAndSortingRepository<Cart, Long> {

	Cart findByUser(@Param("user") User user);

}
