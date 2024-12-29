package ro.sda.travel_agency.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="airports")
public class Airports {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer airport_id;


    @Column(name = "airport_name")
    private String airport_name;

    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "city_id")
    private Cities city;
}
