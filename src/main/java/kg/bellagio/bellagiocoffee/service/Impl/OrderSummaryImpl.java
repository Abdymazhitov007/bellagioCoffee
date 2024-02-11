package kg.bellagio.bellagiocoffee.service.Impl;

import kg.bellagio.bellagiocoffee.entity.OrderSummary;
import kg.bellagio.bellagiocoffee.entity.dto.OrderSummaryDTO;
import kg.bellagio.bellagiocoffee.entity.enums.Status;
import kg.bellagio.bellagiocoffee.mapper.OrderSummaryMapper;
import kg.bellagio.bellagiocoffee.mapper.UserMapper;
import kg.bellagio.bellagiocoffee.repository.OrderSummaryRepo;
import kg.bellagio.bellagiocoffee.service.OrderSummaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderSummaryImpl implements OrderSummaryService {

    private final OrderSummaryRepo repo;

    @Override
    public OrderSummaryDTO save(OrderSummaryDTO dto) {
        OrderSummary entity = OrderSummaryMapper.INSTANCE.toEntity(dto);
        entity.setCreatedDate(LocalDateTime.now());
        entity.setStatus(Status.ACTIVATED);
        return OrderSummaryMapper.INSTANCE.toDto(repo.save(entity));
    }

    @Override
    public OrderSummaryDTO update(OrderSummaryDTO dto) {
        OrderSummary entity = OrderSummaryMapper.INSTANCE.toEntity(getById(dto.getId()));
        entity.setStatus(dto.getStatus());
        entity.setOrderSummary(dto.getOrderSummary());
        entity.setUser(UserMapper.INSTANCE.toEntity(dto.getUser()));
        return OrderSummaryMapper.INSTANCE.toDto(repo.saveAndFlush(entity));
    }

    @Override
    public OrderSummaryDTO getById(Long id) {
        return OrderSummaryMapper.INSTANCE.toDto(repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException()));
    }

    @Override
    public List<OrderSummaryDTO> getAll() {
        return OrderSummaryMapper.INSTANCE.toDtoList(repo.findAll());
    }

    @Override
    public void deleteById(Long id) {
        OrderSummaryDTO dto = getById(id);
        dto.setStatus(Status.DELETED);
        update(dto);
    }
}
