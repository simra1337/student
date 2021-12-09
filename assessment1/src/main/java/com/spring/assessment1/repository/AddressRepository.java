package com.spring.assessment1.repository;

import com.spring.assessment1.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {

    @Query(value = "select * from address where student_id=:id", nativeQuery = true)
    List<Address> findAddressByUserId(@Param("id") Long id);
}
