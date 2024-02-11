package kg.bellagio.bellagiocoffee.entity;

import kg.bellagio.bellagiocoffee.entity.enums.Status;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "tb_work_day_time")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class WorkDayTime {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    LocalDateTime createdDate;

    @Enumerated(EnumType.STRING)
    Status status;

    LocalDate workDay;
    LocalTime workTime;

    @OneToMany
    List<Filial> filial;
}
