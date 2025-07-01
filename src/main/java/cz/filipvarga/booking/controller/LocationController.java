package cz.filipvarga.booking.controller;

import cz.filipvarga.booking.domain.Location;
import cz.filipvarga.booking.persistent.LocationRepository;
import cz.filipvarga.booking.service.LocationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/api/location")
public class LocationController {

    private final LocationRepository locationRepository;
    private final LocationService locationService;

    public LocationController(LocationRepository locationRepository, LocationService locationService) {
        this.locationRepository = locationRepository;
        this.locationService = locationService;
    }

    @GetMapping
    public List<Location> getAllLocations() {
        return locationService.getAllLocations();
    }

}
