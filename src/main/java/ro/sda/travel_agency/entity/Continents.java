package ro.sda.travel_agency.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "continents")
public class Continents {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer continent_id;

    @Column(name = "name")
    private String continent_name;
}
