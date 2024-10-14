package com.polgubau.udemy.relations.practice_relationcs.repositories;

import org.springframework.data.repository.CrudRepository;

import com.polgubau.udemy.relations.practice_relationcs.entities.ClientDetails;

public interface ClientDetailsRepository extends CrudRepository<ClientDetails, Long> {

}
