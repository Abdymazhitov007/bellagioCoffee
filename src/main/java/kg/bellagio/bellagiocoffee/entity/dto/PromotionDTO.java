package kg.bellagio.bellagiocoffee.entity.dto;

import kg.bellagio.bellagiocoffee.entity.enums.Status;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;


@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class PromotionDTO {

    Long id;
    LocalDateTime createdDate;
    Status status;
    String promotion;
    String image;
    List<FilialDTO> filials;
}
