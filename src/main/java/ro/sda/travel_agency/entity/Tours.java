package ro.sda.travel_agency.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tours")
public class Tours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tour_id")
    private int tour_id;

    @ManyToOne
    @JoinColumn(name = "from_city_id", referencedColumnName = "city_id")
    private Cities from_city;

    @ManyToOne
    @JoinColumn(name = "to_city_id", referencedColumnName = "city_id")
    private Cities to_city;

    @ManyToOne
    @JoinColumn(name = "to_hotel_id", referencedColumnName = "hotel_id")
    private Hotels to_hotel;

    @ManyToOne
    @JoinColumn(name = "to_airport_id", referencedColumnName = "airport_id")
    private Airports to_airport;

    @Column(name = "departure_date")
    private Instant departure_date;

    @Column(name = "return_date")
    private Instant return_date;

    @Column(name = "number_of_days")
    private int number_of_days;

    @Column(name = "type")
    private String type;

    @Column(name = "adult_price")
    private double adult_price;

    @Column(name = "child_price")
    private double child_price;

    @Column(name = "promoted")
    private boolean promoted;

    @Column(name = "adult_seats")
    private String adult_seats;

    @Column(name = "child_seats")
    private String child_seats;
}
