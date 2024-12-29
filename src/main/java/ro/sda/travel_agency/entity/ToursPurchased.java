package ro.sda.travel_agency.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tour_purchase")
public class ToursPurchased {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tour_purchase_id")
    private int tour_purchase_id;

    @ManyToOne
    @JoinColumn(name = "tour_id", referencedColumnName = "tour_id")
    private Tours tour;

    @Column(name = "number_of_persons")
    private int number_of_persons;

    @Column(name = "total_price")
    private double total_price;
}
