package com.campus.restaurant.booking.repository;

import com.campus.restaurant.booking.model.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TableRepository extends JpaRepository<Table, Integer> {

    List<Table> findByPersonName(String personName);

    @Query(value = "select * from t_table t where t.person_name = ?1", nativeQuery = true)
    Table gibMirAlleByName(String eingabe);


    List<Table> findByNumberOfPersonsGreaterThan(Integer numberOfPersons);
}
