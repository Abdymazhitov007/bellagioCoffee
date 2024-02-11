package kg.bellagio.bellagiocoffee.service.Impl;

import kg.bellagio.bellagiocoffee.entity.Category;
import kg.bellagio.bellagiocoffee.entity.Filial;
import kg.bellagio.bellagiocoffee.entity.dto.CategoryDTO;
import kg.bellagio.bellagiocoffee.entity.dto.FilialDTO;
import kg.bellagio.bellagiocoffee.entity.enums.Status;
import kg.bellagio.bellagiocoffee.mapper.CategoryMapper;
import kg.bellagio.bellagiocoffee.mapper.FilialMapper;
import kg.bellagio.bellagiocoffee.repository.FilialRepo;
import kg.bellagio.bellagiocoffee.service.FilialService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FilialServiceImpl implements FilialService {

    private final FilialRepo repo;

    @Override
    public FilialDTO save(FilialDTO dto) {
        Filial entity = FilialMapper.INSTANCE.toEntity(dto);
        entity.setCreatedDate(LocalDateTime.now());
        entity.setStatus(Status.ACTIVATED);
        return FilialMapper.INSTANCE.toDto(repo.save(entity));
    }

    @Override
    public FilialDTO update(FilialDTO dto) {
        Filial entity = FilialMapper.INSTANCE.toEntity(getById(dto.getId()));
        entity.setImage(dto.getImage());
        entity.setStatus(dto.getStatus());
        entity.setDescription(dto.getDescription());
        entity.setLinkTo2Gis(dto.getLinkTo2Gis());
        entity.setAddress(dto.getAddress());
        return FilialMapper.INSTANCE.toDto(repo.saveAndFlush(entity));
    }

    @Override
    public FilialDTO getById(Long id) {
        return FilialMapper.INSTANCE.toDto(repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("not found")));
    }

    @Override
    public List<FilialDTO> getAll() {
        return FilialMapper.INSTANCE.toDtoList(repo.findAll());
    }

    @Override
    public void deleteById(Long id) {
        FilialDTO dto = getById(id);
        dto.setStatus(Status.DELETED);
        update(dto);
    }
}
