package kg.bellagio.bellagiocoffee.service.Impl;

import kg.bellagio.bellagiocoffee.entity.Bonus;
import kg.bellagio.bellagiocoffee.entity.dto.BonusDTO;
import kg.bellagio.bellagiocoffee.entity.enums.Status;
import kg.bellagio.bellagiocoffee.mapper.BonusMapper;
import kg.bellagio.bellagiocoffee.mapper.UserMapper;
import kg.bellagio.bellagiocoffee.repository.BonusRepo;
import kg.bellagio.bellagiocoffee.service.BonusService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BonusServiceImpl implements BonusService {

    private final BonusRepo repo;

    @Override
    public BonusDTO save(BonusDTO dto) {
        Bonus entity = BonusMapper.INSTANCE.toEntity(dto);
        entity.setCreatedDate(LocalDateTime.now());
        entity.setStatus(Status.ACTIVATED);
        return BonusMapper.INSTANCE.toDto(repo.save(entity));
    }

    @Override
    public BonusDTO update(BonusDTO dto) {
        Bonus entity = BonusMapper.INSTANCE.toEntity(getById(dto.getId()));
        entity.setUser(UserMapper.INSTANCE.toEntity(dto.getUser()));
        entity.setStatus(dto.getStatus());
        return BonusMapper.INSTANCE.toDto(repo.saveAndFlush(entity));
    }

    @Override
    public BonusDTO getById(Long id) {
        return BonusMapper.INSTANCE.toDto(repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("not found")));
    }

    @Override
    public List<BonusDTO> getAll() {
        return BonusMapper.INSTANCE.toDtoList(repo.findAll());
    }

    @Override
    public void deleteById(Long id) {
        BonusDTO dto = getById(id);
        dto.setStatus(Status.DELETED);
        update(dto);
    }
}
