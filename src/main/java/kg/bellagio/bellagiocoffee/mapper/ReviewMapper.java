package kg.bellagio.bellagiocoffee.mapper;

import kg.bellagio.bellagiocoffee.entity.Review;
import kg.bellagio.bellagiocoffee.entity.dto.ReviewDTO;
import org.mapstruct.factory.Mappers;

public interface ReviewMapper extends BaseMapper<Review, ReviewDTO> {

    ReviewMapper INSTANCE = Mappers.getMapper(ReviewMapper.class);

}
