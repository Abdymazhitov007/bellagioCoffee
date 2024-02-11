package kg.bellagio.bellagiocoffee.mapper;

import kg.bellagio.bellagiocoffee.entity.Category;
import kg.bellagio.bellagiocoffee.entity.dto.CategoryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper extends BaseMapper<Category, CategoryDTO> {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

}
