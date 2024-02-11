package kg.bellagio.bellagiocoffee.service.Impl;

import kg.bellagio.bellagiocoffee.entity.Product;
import kg.bellagio.bellagiocoffee.entity.dto.OrderSummaryDTO;
import kg.bellagio.bellagiocoffee.entity.dto.ProductDTO;
import kg.bellagio.bellagiocoffee.entity.enums.Status;
import kg.bellagio.bellagiocoffee.mapper.CategoryMapper;
import kg.bellagio.bellagiocoffee.mapper.OrderSummaryMapper;
import kg.bellagio.bellagiocoffee.mapper.ProductMapper;
import kg.bellagio.bellagiocoffee.repository.ProductRepo;
import kg.bellagio.bellagiocoffee.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepo repo;

    @Override
    public ProductDTO save(ProductDTO dto) {
        Product entity = ProductMapper.INSTANCE.toEntity(dto);
        entity.setCreatedDate(LocalDateTime.now());
        entity.setStatus(Status.ACTIVATED);
        return ProductMapper.INSTANCE.toDto(repo.save(entity));
    }

    @Override
    public ProductDTO update(ProductDTO dto) {
        Product entity = ProductMapper.INSTANCE.toEntity(getById(dto.getId()));
        entity.setStatus(dto.getStatus());
        entity.setPrice(dto.getPrice());
        entity.setDescription(dto.getDescription());
        entity.setImage(dto.getImage());
        entity.setCategory(CategoryMapper.INSTANCE.toEntity(dto.getCategory()));
        return ProductMapper.INSTANCE.toDto(repo.saveAndFlush(entity));
    }

    @Override
    public ProductDTO getById(Long id) {
        return ProductMapper.INSTANCE.toDto(repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException()));
    }

    @Override
    public List<ProductDTO> getAll() {
        return ProductMapper.INSTANCE.toDtoList(repo.findAll());
    }

    @Override
    public void deleteById(Long id) {
        ProductDTO dto = getById(id);
        dto.setStatus(Status.DELETED);
        update(dto);
    }
}
