package kg.bellagio.bellagiocoffee.repository;

import kg.bellagio.bellagiocoffee.entity.Review;
import kg.bellagio.bellagiocoffee.entity.WorkDayTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WorkDayTimeRepo extends JpaRepository<WorkDayTime, Long> {

    @Override
    @Query(value = "select * from tb_work_day_time where id = :id and status = 'ACTIVATED'", nativeQuery = true)
    Optional<WorkDayTime> findById(Long id);

    @Override
    @Query(value = "select * from tb_work_day_time where status = 'ACTIVATED'", nativeQuery = true)
    List<WorkDayTime> findAll();

}
