package com.r2m.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.r2m.model.User;

@RepositoryRestResource
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

	List<User> findByLastName(@Param("name") String name);

	//User findOne(String userId);

}
