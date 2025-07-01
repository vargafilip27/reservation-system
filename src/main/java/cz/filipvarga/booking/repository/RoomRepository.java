package cz.filipvarga.booking.repository;

import cz.filipvarga.booking.domain.Location;
import cz.filipvarga.booking.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    @Query("SELECT r FROM Room r WHERE r.location = :location")
    List<Room> getRoomsByLocation(@Param("location") Location location);

    @Query("""
        SELECT r
        FROM Room r
        WHERE r.location = :location
        AND r.id NOT IN (
          SELECT b.room.id
          FROM Booking b
          WHERE b.startDate < :checkout AND b.endDate > :checkin
        )
    """)
    List<Room> getAvailableRoomsByLocation(@Param("location") Location location,
                                           @Param("checkin") Date checkin,
                                           @Param("checkout") Date checkout);
}
