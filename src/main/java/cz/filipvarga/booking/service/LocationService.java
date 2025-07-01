package cz.filipvarga.booking.service;

import cz.filipvarga.booking.domain.Location;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LocationService {

    public List<Location> getAllLocations();
}
