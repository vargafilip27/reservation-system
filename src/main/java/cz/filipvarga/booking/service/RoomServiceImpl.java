package cz.filipvarga.booking.service;

import cz.filipvarga.booking.domain.Location;
import cz.filipvarga.booking.domain.Room;
import cz.filipvarga.booking.repository.RoomRepository;

import java.util.List;

public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public List<Room> getRoomsByLocation(Location location) {
        return roomRepository.getRoomsByLocation(location);
    }
}
