package kg.bellagio.bellagiocoffee.service.Impl;

import kg.bellagio.bellagiocoffee.entity.Promotion;
import kg.bellagio.bellagiocoffee.entity.QRcode;
import kg.bellagio.bellagiocoffee.entity.dto.PromotionDTO;
import kg.bellagio.bellagiocoffee.entity.dto.QRcodeDTO;
import kg.bellagio.bellagiocoffee.entity.enums.Status;
import kg.bellagio.bellagiocoffee.mapper.FilialMapper;
import kg.bellagio.bellagiocoffee.mapper.PromotionMapper;
import kg.bellagio.bellagiocoffee.mapper.QRcodeMapper;
import kg.bellagio.bellagiocoffee.mapper.UserMapper;
import kg.bellagio.bellagiocoffee.repository.PromotionRepo;
import kg.bellagio.bellagiocoffee.repository.QRcodeRepo;
import kg.bellagio.bellagiocoffee.service.QRcodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QRcodeServiceImpl implements QRcodeService {

    private final QRcodeRepo repo;

    @Override
    public QRcodeDTO save(QRcodeDTO dto) {
        QRcode entity = QRcodeMapper.INSTANCE.toEntity(dto);
        entity.setCreatedDate(LocalDateTime.now());
        entity.setStatus(Status.ACTIVATED);
        return QRcodeMapper.INSTANCE.toDto(repo.save(entity));
    }

    @Override
    public QRcodeDTO update(QRcodeDTO dto) {
        QRcode entity = QRcodeMapper.INSTANCE.toEntity(getById(dto.getId()));
        entity.setStatus(dto.getStatus());
        entity.setQr(dto.getQr());
        entity.setUser(UserMapper.INSTANCE.toEntity(dto.getUser()));
        return QRcodeMapper.INSTANCE.toDto(repo.saveAndFlush(entity));
    }

    @Override
    public QRcodeDTO getById(Long id) {
        return QRcodeMapper.INSTANCE.toDto(repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException()));
    }

    @Override
    public List<QRcodeDTO> getAll() {
        return QRcodeMapper.INSTANCE.toDtoList(repo.findAll());
    }

    @Override
    public void deleteById(Long id) {
        QRcodeDTO dto = getById(id);
        dto.setStatus(Status.DELETED);
        update(dto);
    }
}
