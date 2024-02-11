package kg.bellagio.bellagiocoffee.repository;

import kg.bellagio.bellagiocoffee.entity.Bonus;
import kg.bellagio.bellagiocoffee.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {

    @Override
    @Query(value = "select * from tb_category where id = :id and status = 'ACTIVATED'", nativeQuery = true)
    Optional<Category> findById(Long id);

    @Override
    @Query(value = "select * from tb_category where status = 'ACTIVATED'", nativeQuery = true)
    List<Category> findAll();

}
