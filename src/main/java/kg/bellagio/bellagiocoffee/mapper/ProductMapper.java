package kg.bellagio.bellagiocoffee.mapper;

import kg.bellagio.bellagiocoffee.entity.Product;
import kg.bellagio.bellagiocoffee.entity.dto.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper extends BaseMapper<Product, ProductDTO> {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

}
