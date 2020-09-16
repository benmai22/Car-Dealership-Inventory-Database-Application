package com.ben.vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class VehicleService {

  @Autowired
  private VehicleRepository vehicleRepository;

  public Page<Vehicle> getAllVehicles(Pageable paging){
    return vehicleRepository.findAll(paging);
  }

  public Vehicle getVehicle(long id){
    return vehicleRepository.findById(id);
  }
  public Vehicle addVehicle(Vehicle vehicle){
    return vehicleRepository.save(vehicle);
  }

  public void deleteVehicle(long id){
    vehicleRepository.deleteById(id);
  }

  public Page<Vehicle> searchVehicles(String query, Pageable paging){
    return vehicleRepository.searchVehicle(query, paging);
  }
}
