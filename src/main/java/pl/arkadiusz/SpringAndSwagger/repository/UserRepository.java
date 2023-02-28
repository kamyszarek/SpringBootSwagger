package pl.arkadiusz.SpringAndSwagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.arkadiusz.SpringAndSwagger.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findById(long id);

}
