package cz.filipvarga.booking.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_booking")
    private Long id;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "customer_count")
    private int customerCount;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Room.class)
    @JoinColumn(name = "id_room")
    Room room;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Customer.class)
    @JoinColumn(name = "id_customer")
    Customer customer;
}
