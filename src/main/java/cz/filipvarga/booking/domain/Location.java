package cz.filipvarga.booking.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

// Represents a standalone hotel building/branch

@Entity
@Getter
@Setter
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_location")
    private Long id;

    private String name;

    private double latitude;
                                // Precise geographic location (for weather API)
    private double longitude;

    private double temperature;

    private String weather;

    @OneToMany(targetEntity = Room.class, mappedBy = "location", fetch = FetchType.LAZY)
    List<Room> rooms = new ArrayList<>();
}
