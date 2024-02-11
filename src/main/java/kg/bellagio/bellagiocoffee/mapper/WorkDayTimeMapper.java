package kg.bellagio.bellagiocoffee.mapper;

import kg.bellagio.bellagiocoffee.entity.WorkDayTime;
import kg.bellagio.bellagiocoffee.entity.dto.WorkDayTimeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WorkDayTimeMapper extends BaseMapper<WorkDayTime, WorkDayTimeDTO> {

    WorkDayTimeMapper INSTANCE = Mappers.getMapper(WorkDayTimeMapper.class);

}
