package kg.bellagio.bellagiocoffee.service.Impl;

import kg.bellagio.bellagiocoffee.entity.QRcode;
import kg.bellagio.bellagiocoffee.entity.Review;
import kg.bellagio.bellagiocoffee.entity.dto.QRcodeDTO;
import kg.bellagio.bellagiocoffee.entity.dto.ReviewDTO;
import kg.bellagio.bellagiocoffee.entity.enums.Status;
import kg.bellagio.bellagiocoffee.mapper.FilialMapper;
import kg.bellagio.bellagiocoffee.mapper.QRcodeMapper;
import kg.bellagio.bellagiocoffee.mapper.ReviewMapper;
import kg.bellagio.bellagiocoffee.mapper.UserMapper;
import kg.bellagio.bellagiocoffee.repository.ReviewRepo;
import kg.bellagio.bellagiocoffee.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.data.elasticsearch.ReactiveElasticsearchRepositoriesAutoConfiguration;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepo repo;

    @Override
    public ReviewDTO save(ReviewDTO dto) {
        Review entity = ReviewMapper.INSTANCE.toEntity(dto);
        entity.setCreatedDate(LocalDateTime.now());
        entity.setStatus(Status.ACTIVATED);
        return ReviewMapper.INSTANCE.toDto(repo.save(entity));
    }

    @Override
    public ReviewDTO update(ReviewDTO dto) {
        Review entity = ReviewMapper.INSTANCE.toEntity(getById(dto.getId()));
        entity.setStatus(dto.getStatus());
        entity.setUser(UserMapper.INSTANCE.toEntity(dto.getUser()));
        entity.setReview(dto.getReview());
        entity.setFilial(FilialMapper.INSTANCE.toEntity(dto.getFilial()));
        return ReviewMapper.INSTANCE.toDto(repo.saveAndFlush(entity));
    }

    @Override
    public ReviewDTO getById(Long id) {
        return ReviewMapper.INSTANCE.toDto(repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException()));
    }

    @Override
    public List<ReviewDTO> getAll() {
        return ReviewMapper.INSTANCE.toDtoList(repo.findAll());
    }

    @Override
    public void deleteById(Long id) {
        ReviewDTO dto = getById(id);
        dto.setStatus(Status.DELETED);
        update(dto);
    }
}
