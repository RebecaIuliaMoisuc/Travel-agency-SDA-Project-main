package ro.sda.travel_agency.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer_packages")
public class CustomerPackages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_package_id")
    private int customerPackageId;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customers customer;

    @ManyToOne
    @JoinColumn(name = "package_id", referencedColumnName = "package_id")
    private Packages travelPackage;

    @Column(name = "purchase_date")
    private Instant purchaseDate;

    @Column(name = "number_of_persons")
    private int numberOfPersons;

    @Column(name = "total_price")
    private double totalPrice;
}
