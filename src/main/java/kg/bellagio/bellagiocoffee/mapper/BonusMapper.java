package kg.bellagio.bellagiocoffee.mapper;

import kg.bellagio.bellagiocoffee.entity.Bonus;
import kg.bellagio.bellagiocoffee.entity.dto.BonusDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BonusMapper extends BaseMapper<Bonus, BonusDTO> {

    BonusMapper INSTANCE = Mappers.getMapper(BonusMapper.class);

}
