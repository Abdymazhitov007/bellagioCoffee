package kg.bellagio.bellagiocoffee.service.Impl;

import kg.bellagio.bellagiocoffee.entity.Review;
import kg.bellagio.bellagiocoffee.entity.WorkDayTime;
import kg.bellagio.bellagiocoffee.entity.dto.ReviewDTO;
import kg.bellagio.bellagiocoffee.entity.dto.WorkDayTimeDTO;
import kg.bellagio.bellagiocoffee.entity.enums.Status;
import kg.bellagio.bellagiocoffee.mapper.FilialMapper;
import kg.bellagio.bellagiocoffee.mapper.ReviewMapper;
import kg.bellagio.bellagiocoffee.mapper.UserMapper;
import kg.bellagio.bellagiocoffee.mapper.WorkDayTimeMapper;
import kg.bellagio.bellagiocoffee.repository.WorkDayTimeRepo;
import kg.bellagio.bellagiocoffee.service.WorkDayTimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkDayTimeServiceImpl implements WorkDayTimeService {

    private final WorkDayTimeRepo repo;

    @Override
    public WorkDayTimeDTO save(WorkDayTimeDTO dto) {
        WorkDayTime entity = WorkDayTimeMapper.INSTANCE.toEntity(dto);
        entity.setCreatedDate(LocalDateTime.now());
        entity.setStatus(Status.ACTIVATED);
        return WorkDayTimeMapper.INSTANCE.toDto(repo.save(entity));
    }

    @Override
    public WorkDayTimeDTO update(WorkDayTimeDTO dto) {
        WorkDayTime entity = WorkDayTimeMapper.INSTANCE.toEntity(getById(dto.getId()));
        entity.setStatus(dto.getStatus());
        entity.setFilial(FilialMapper.INSTANCE.toEntities(dto.getFilial()));
        entity.setWorkDay(dto.getWorkDay());
        entity.setWorkTime(dto.getWorkTime());
        return WorkDayTimeMapper.INSTANCE.toDto(repo.saveAndFlush(entity));
    }

    @Override
    public WorkDayTimeDTO getById(Long id) {
        return WorkDayTimeMapper.INSTANCE.toDto(repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException()));
    }

    @Override
    public List<WorkDayTimeDTO> getAll() {
        return WorkDayTimeMapper.INSTANCE.toDtoList(repo.findAll());
    }

    @Override
    public void deleteById(Long id) {
        WorkDayTimeDTO dto = getById(id);
        dto.setStatus(Status.DELETED);
        update(dto);
    }
}
