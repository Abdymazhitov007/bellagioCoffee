package kg.bellagio.bellagiocoffee.mapper;

import kg.bellagio.bellagiocoffee.entity.User;
import kg.bellagio.bellagiocoffee.entity.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper extends BaseMapper<User, UserDTO> {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

}
