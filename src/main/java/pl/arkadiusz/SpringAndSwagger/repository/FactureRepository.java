package pl.arkadiusz.SpringAndSwagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.arkadiusz.SpringAndSwagger.model.Facture;
import pl.arkadiusz.SpringAndSwagger.model.User;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Repository
public interface FactureRepository extends JpaRepository<Facture, Long> {


    List<Facture> findByTotalGreaterThan(double total);


    // List<Facture> findByUser_id(long user_id);

}
