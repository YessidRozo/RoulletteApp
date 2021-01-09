package com.roullette.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.roullette.entity.User;
@Repository
public interface UserRepository extends CrudRepository<User, Long>{

}
