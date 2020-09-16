package com.ben.vehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;

	@RequestMapping("/vehicles")
	public ResponseEntity<Map<String, Object>> getAllVehicles(
		@RequestParam(value="query", required = false) String query,
		@RequestParam(defaultValue = "0") int page,
		@RequestParam(defaultValue = "10") int size
		) {

    try
    {
      List<Vehicle> vehicles = new ArrayList<Vehicle>();
      Pageable paging = PageRequest.of(page, size);
      Page<Vehicle> pageVehicles;
      if (query != null){
        pageVehicles = vehicleService.searchVehicles(query, paging);
      }
      else {
        pageVehicles = vehicleService.getAllVehicles(paging);
      }
      
      vehicles = pageVehicles.getContent();
      Map<String, Object> response = new HashMap<>();
      response.put("vehicles", vehicles);
      response.put("currentPage", pageVehicles.getNumber());
      response.put("totalItems", pageVehicles.getTotalElements());
      response.put("totalPages", pageVehicles.getTotalPages());

      if (vehicles.isEmpty()) {
        return new ResponseEntity<>(response, HttpStatus.OK);
      }
      return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
		  return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value="/vehicles", method=RequestMethod.POST)
	public Vehicle addNewVehicle(@RequestBody Vehicle vehicle) {
		return vehicleService.addVehicle(vehicle);
	}
	
	@Transactional
	@RequestMapping(value="/vehicles/{id}", method=RequestMethod.DELETE)
	public void deleteVehicle(@PathVariable Long id){
		vehicleService.deleteVehicle(id);
	}

	@RequestMapping(value="/vehicles/{id}")
	public Vehicle getVehicle(@PathVariable Long id){
		return vehicleService.getVehicle(id);
	}
}
