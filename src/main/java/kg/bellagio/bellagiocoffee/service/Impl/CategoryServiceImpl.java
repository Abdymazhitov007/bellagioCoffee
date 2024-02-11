package kg.bellagio.bellagiocoffee.service.Impl;

import kg.bellagio.bellagiocoffee.entity.Bonus;
import kg.bellagio.bellagiocoffee.entity.Category;
import kg.bellagio.bellagiocoffee.entity.dto.BonusDTO;
import kg.bellagio.bellagiocoffee.entity.dto.CategoryDTO;
import kg.bellagio.bellagiocoffee.entity.enums.Status;
import kg.bellagio.bellagiocoffee.mapper.BonusMapper;
import kg.bellagio.bellagiocoffee.mapper.CategoryMapper;
import kg.bellagio.bellagiocoffee.mapper.UserMapper;
import kg.bellagio.bellagiocoffee.repository.CategoryRepo;
import kg.bellagio.bellagiocoffee.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepo repo;

    @Override
    public CategoryDTO save(CategoryDTO dto) {
        Category entity = CategoryMapper.INSTANCE.toEntity(dto);
        entity.setCreatedDate(LocalDateTime.now());
        entity.setStatus(Status.ACTIVATED);
        return CategoryMapper.INSTANCE.toDto(repo.save(entity));
    }

    @Override
    public CategoryDTO update(CategoryDTO dto) {
        Category entity = CategoryMapper.INSTANCE.toEntity(getById(dto.getId()));
        entity.setImage(dto.getImage());
        entity.setStatus(dto.getStatus());
        entity.setCategory(dto.getCategory());
        entity.setDescription(dto.getDescription());
        return CategoryMapper.INSTANCE.toDto(repo.saveAndFlush(entity));
    }

    @Override
    public CategoryDTO getById(Long id) {
        return CategoryMapper.INSTANCE.toDto(repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("not found")));
    }

    @Override
    public List<CategoryDTO> getAll() {
        return CategoryMapper.INSTANCE.toDtoList(repo.findAll());
    }

    @Override
    public void deleteById(Long id) {
        CategoryDTO dto = getById(id);
        dto.setStatus(Status.DELETED);
        update(dto);
    }
}
