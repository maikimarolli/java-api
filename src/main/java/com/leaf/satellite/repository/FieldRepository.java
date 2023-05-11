package com.leaf.satellite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leaf.satellite.model.Field;

@Repository
public interface FieldRepository extends JpaRepository<Field, Long>{

}
