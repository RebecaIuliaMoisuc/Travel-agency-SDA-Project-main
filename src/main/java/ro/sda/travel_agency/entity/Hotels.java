package ro.sda.travel_agency.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "hotels")
public class Hotels {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer hotel_id;

    @Column(name = "hotel_name")
    private String hotel_name;

    @Column(name = "number_of_stars")
    private Integer number_of_stars;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "city_id")
    private Cities city;
}
