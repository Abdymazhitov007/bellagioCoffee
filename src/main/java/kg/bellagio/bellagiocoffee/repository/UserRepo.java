package kg.bellagio.bellagiocoffee.repository;

import kg.bellagio.bellagiocoffee.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
}
