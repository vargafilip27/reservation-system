package cz.filipvarga.booking.service;

import cz.filipvarga.booking.domain.Location;
import cz.filipvarga.booking.persistent.LocationRepository;

import java.util.List;

public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public List<Location> getAllLocations() {
        List<Location> locations = locationRepository.findAll();

        for (Location location : locations) {

        }

        return locations;
    }
}
