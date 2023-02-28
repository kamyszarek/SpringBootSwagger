package pl.arkadiusz.SpringAndSwagger.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Entity(name = "facture")
@Getter
@Setter
public class Facture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

//    @Temporal(TemporalType.DATE)
    private Date orderdate;
    private Date repdate;

    private double total;
    private long userid;

}