package kg.bellagio.bellagiocoffee.entity.dto;

import kg.bellagio.bellagiocoffee.entity.enums.Status;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;


@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class WorkDayTimeDTO {

    Long id;
    LocalDateTime createdDate;
    Status status;
    LocalDate workDay;
    LocalTime workTime;
    List<FilialDTO> filial;
}
