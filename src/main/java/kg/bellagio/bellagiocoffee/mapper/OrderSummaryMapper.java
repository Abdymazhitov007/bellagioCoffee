package kg.bellagio.bellagiocoffee.mapper;

import kg.bellagio.bellagiocoffee.entity.OrderSummary;
import kg.bellagio.bellagiocoffee.entity.dto.OrderSummaryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderSummaryMapper extends BaseMapper<OrderSummary, OrderSummaryDTO> {

    OrderSummaryMapper INSTANCE = Mappers.getMapper(OrderSummaryMapper.class);

}
