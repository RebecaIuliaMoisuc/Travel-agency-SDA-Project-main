package ro.sda.travel_agency.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="countries")
public class Countries {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int country_id;

        @Column(name = "country_name")
        private String country_name;

        @ManyToOne
        @JoinColumn(name = "continent_id", referencedColumnName = "continent_id")
        private Continents continent;


    }

