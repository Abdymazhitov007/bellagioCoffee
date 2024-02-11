package kg.bellagio.bellagiocoffee.repository;

import kg.bellagio.bellagiocoffee.entity.QRcode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QRcodeRepo extends JpaRepository<QRcode, Long> {

    @Override
    @Query(value = "select * from tb_qrcode where id = :id and status = 'ACTIVATED'", nativeQuery = true)
    Optional<QRcode> findById(Long id);

    @Override
    @Query(value = "select * from tb_qrcode where status = 'ACTIVATED'", nativeQuery = true)
    List<QRcode> findAll();

}
