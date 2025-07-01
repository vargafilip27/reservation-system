package cz.filipvarga.booking.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_room")
    private Long id;

    private String number;  // Identification of a room in a hotel (110, 2B for example)

    private int capacity;

    private int price;  // Price for one night

    @OneToMany(targetEntity = Booking.class, mappedBy = "room", fetch = FetchType.LAZY)
    List<Booking> bookings = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Location.class)
    @Column(name = "id_location")
    private Location location;
}
