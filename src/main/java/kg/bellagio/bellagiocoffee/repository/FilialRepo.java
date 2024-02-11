package kg.bellagio.bellagiocoffee.repository;

import kg.bellagio.bellagiocoffee.entity.Filial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FilialRepo extends JpaRepository<Filial, Long> {

    @Override
    @Query(value = "select * from tb_filial where id = :id and status = 'ACTIVATED'", nativeQuery = true)
    Optional<Filial> findById(Long id);

    @Override
    @Query(value = "select * from tb_filial where status = 'ACTIVATED'", nativeQuery = true)
    List<Filial> findAll();

}
