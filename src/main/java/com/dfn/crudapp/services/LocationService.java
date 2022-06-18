package com.dfn.crudapp.services;

import com.dfn.crudapp.dto.UserDTO;
import com.dfn.crudapp.entity.Location;
import com.dfn.crudapp.entity.User;
import com.dfn.crudapp.repository.LocationRepository;
import com.dfn.crudapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {


    private final LocationRepository locationRepo;

    @Autowired
    public LocationService(LocationRepository locationRepo) {
        this.locationRepo = locationRepo;
    }

    public void createLocation(Location location) throws Exception {
        locationRepo.save(location);
    }

    public List<Location> getLocations() {
        return (List<Location>) locationRepo.findAll();
    }

    public Location getLocation(Long uid) throws Exception{
        return locationRepo.findById(uid).get();
    }

    public void deleteLocation(Long uid) {
        locationRepo.deleteById(uid);
    }

    public void updateLocation(Location location) {
        locationRepo.save(location);
    }
}
