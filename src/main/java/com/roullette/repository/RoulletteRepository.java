package com.roullette.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.roullette.entity.Roullette;
@Repository
public interface RoulletteRepository extends CrudRepository<Roullette, Long>  {
	

}
