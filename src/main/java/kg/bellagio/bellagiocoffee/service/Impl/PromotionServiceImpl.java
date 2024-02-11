package kg.bellagio.bellagiocoffee.service.Impl;

import kg.bellagio.bellagiocoffee.entity.Product;
import kg.bellagio.bellagiocoffee.entity.Promotion;
import kg.bellagio.bellagiocoffee.entity.dto.ProductDTO;
import kg.bellagio.bellagiocoffee.entity.dto.PromotionDTO;
import kg.bellagio.bellagiocoffee.entity.enums.Status;
import kg.bellagio.bellagiocoffee.mapper.CategoryMapper;
import kg.bellagio.bellagiocoffee.mapper.FilialMapper;
import kg.bellagio.bellagiocoffee.mapper.ProductMapper;
import kg.bellagio.bellagiocoffee.mapper.PromotionMapper;
import kg.bellagio.bellagiocoffee.repository.PromotionRepo;
import kg.bellagio.bellagiocoffee.service.ProductService;
import kg.bellagio.bellagiocoffee.service.PromotionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PromotionServiceImpl implements PromotionService {

    private final PromotionRepo repo;

    @Override
    public PromotionDTO save(PromotionDTO dto) {
        Promotion entity = PromotionMapper.INSTANCE.toEntity(dto);
        entity.setCreatedDate(LocalDateTime.now());
        entity.setStatus(Status.ACTIVATED);
        return PromotionMapper.INSTANCE.toDto(repo.save(entity));
    }

    @Override
    public PromotionDTO update(PromotionDTO dto) {
        Promotion entity = PromotionMapper.INSTANCE.toEntity(getById(dto.getId()));
        entity.setStatus(dto.getStatus());
        entity.setImage(dto.getImage());
        entity.setPromotion(dto.getPromotion());
        entity.setFilials(FilialMapper.INSTANCE.toEntities(dto.getFilials()));
        return PromotionMapper.INSTANCE.toDto(repo.saveAndFlush(entity));
    }

    @Override
    public PromotionDTO getById(Long id) {
        return PromotionMapper.INSTANCE.toDto(repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException()));
    }

    @Override
    public List<PromotionDTO> getAll() {
        return PromotionMapper.INSTANCE.toDtoList(repo.findAll());
    }

    @Override
    public void deleteById(Long id) {
        PromotionDTO dto = getById(id);
        dto.setStatus(Status.DELETED);
        update(dto);
    }
}
