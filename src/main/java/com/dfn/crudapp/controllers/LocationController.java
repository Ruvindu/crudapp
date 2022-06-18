package com.dfn.crudapp.controllers;

import com.dfn.crudapp.dto.UserDTO;
import com.dfn.crudapp.entity.Location;
import com.dfn.crudapp.entity.User;
import com.dfn.crudapp.services.LocationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/v1")
public class LocationController {

    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }


    //  Get all Locations
    @GetMapping(path = "/getlocations")
    public ResponseEntity<List<Location>> getUsers() {
        return ResponseEntity.ok().body(locationService.getLocations());
    }

    //  Get specific location by id
    @GetMapping(path = "getlocation/{lid}")
    public ResponseEntity<Location> getuser(@PathVariable Long lid) {
        try {
            Location locations = locationService.getLocation(lid);
            return ResponseEntity.ok().body(locations);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping(path = "/addlocation")
    public ResponseEntity createUser(@RequestBody Location location) {

        try {
            locationService.createLocation(location);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
//            throw new IllegalStateException("User can't be create");
            return ResponseEntity.internalServerError().build();
        }

    }

    //  Update existing user
    @PutMapping(path = "/updatelocation")
    public ResponseEntity updateLocation(@RequestBody Location location) {

        try {
            locationService.updateLocation(location);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
//            throw new IllegalStateException("User can't be create");
            return ResponseEntity.internalServerError().build();
        }


    }

    //  Delete user
    @DeleteMapping(path = "/deletelocation/{lid}")
    public ResponseEntity putUsers(@PathVariable Long lid) {

        try {
            locationService.deleteLocation(lid);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }


}
