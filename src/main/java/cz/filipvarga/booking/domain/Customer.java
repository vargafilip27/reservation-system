package cz.filipvarga.booking.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_customer")
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    @OneToMany(targetEntity = Booking.class, mappedBy = "customer", orphanRemoval = false)
    private List<Booking> bookings;
}
