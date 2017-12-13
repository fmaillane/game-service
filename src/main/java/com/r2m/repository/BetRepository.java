package com.r2m.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.r2m.model.Bet;

@RepositoryRestResource
public interface BetRepository extends PagingAndSortingRepository<Bet, Long> {

}
