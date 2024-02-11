package kg.bellagio.bellagiocoffee.entity.dto;

import kg.bellagio.bellagiocoffee.entity.enums.Status;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;


@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class ProductDTO {

    Long id;
    LocalDateTime createdDate;
    Status status;
    String description;
    String image;
    Double price;
    CategoryDTO category;

}
