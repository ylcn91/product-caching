package com.doksanbir.productcaching.repositories;

import com.doksanbir.productcaching.model.entity.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    User findByEmail(String email);

    @Query(value="select * from Users u where u.first_name = ?1",nativeQuery=true)
    List<User> findUserByFirstName(String firstName);

    @Query(value="select * from Users u where u.last_name = :lastName",nativeQuery=true)
    List<User> findUserByLastName(@Param("lastName") String lastName);

}
