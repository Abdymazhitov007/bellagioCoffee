package kg.bellagio.bellagiocoffee.mapper;

import kg.bellagio.bellagiocoffee.entity.Filial;
import kg.bellagio.bellagiocoffee.entity.dto.FilialDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FilialMapper extends BaseMapper<Filial, FilialDTO> {

    FilialMapper INSTANCE = Mappers.getMapper(FilialMapper.class);

}
