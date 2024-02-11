package kg.bellagio.bellagiocoffee.repository;

import kg.bellagio.bellagiocoffee.entity.OrderSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderSummaryRepo extends JpaRepository<OrderSummary, Long> {

    @Override
    @Query(value = "select * from tb_order_summary where id = :id and status = 'ACTIVATED'", nativeQuery = true)
    Optional<OrderSummary> findById(Long id);

    @Override
    @Query(value = "select * from tb_order_summary where status = 'ACTIVATED'", nativeQuery = true)
    List<OrderSummary> findAll();

}
