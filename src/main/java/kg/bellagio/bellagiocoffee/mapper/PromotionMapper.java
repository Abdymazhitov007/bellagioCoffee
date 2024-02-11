package kg.bellagio.bellagiocoffee.mapper;

import kg.bellagio.bellagiocoffee.entity.Promotion;
import kg.bellagio.bellagiocoffee.entity.dto.PromotionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PromotionMapper extends BaseMapper<Promotion, PromotionDTO> {

    PromotionMapper INSTANCE = Mappers.getMapper(PromotionMapper.class);

}
