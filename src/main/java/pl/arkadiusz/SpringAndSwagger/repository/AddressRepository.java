package pl.arkadiusz.SpringAndSwagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.arkadiusz.SpringAndSwagger.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    //Address findByUser_Id(long user_id);


}
