package kg.bellagio.bellagiocoffee.repository;

import kg.bellagio.bellagiocoffee.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    @Override
    @Query(value = "select * from tb_product where id = :id and status = 'ACTIVATED'", nativeQuery = true)
    Optional<Product> findById(Long id);

    @Override
    @Query(value = "select * from tb_product where status = 'ACTIVATED'", nativeQuery = true)
    List<Product> findAll();

}
