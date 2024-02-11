package kg.bellagio.bellagiocoffee.mapper;

import kg.bellagio.bellagiocoffee.entity.QRcode;
import kg.bellagio.bellagiocoffee.entity.dto.QRcodeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface QRcodeMapper extends BaseMapper<QRcode, QRcodeDTO> {

    QRcodeMapper INSTANCE = Mappers.getMapper(QRcodeMapper.class);

}
