package cz.filipvarga.booking.service;

import cz.filipvarga.booking.domain.Location;
import cz.filipvarga.booking.domain.Room;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoomService {
    public List<Room> getRoomsByLocation(Location location);
}
