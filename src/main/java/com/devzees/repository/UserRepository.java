package com.devzees.repository;

import com.devzees.model.User;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

/**
 * Author: Zeeshan Adil
 * User:mhmdz
 * Date:24-08-2024
 * Time:18:33
 */

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}