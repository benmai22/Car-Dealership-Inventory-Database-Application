package com.ben.vehicle;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VehicleRepository extends JpaRepository<Vehicle, String>{
  
  public void deleteById(long id);
  public Vehicle findById(long id);
  Page<Vehicle> findAll(Pageable pageable);

  @Query("SELECT v FROM Vehicle v WHERE UPPER(v.name) LIKE UPPER(concat('%',?1,'%')) OR UPPER(v.model) LIKE UPPER(concat('%',?1,'%')) OR UPPER(v.color) LIKE UPPER(concat('%',?1,'%'))")
  public Page<Vehicle> searchVehicle(String query, Pageable pageable);

}
