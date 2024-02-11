package kg.bellagio.bellagiocoffee.entity;

import kg.bellagio.bellagiocoffee.entity.Filial;
import kg.bellagio.bellagiocoffee.entity.User;
import kg.bellagio.bellagiocoffee.entity.enums.Status;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;



@Entity
@Table(name = "tb_review")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    LocalDateTime createdDate;

    @Enumerated(EnumType.STRING)
    Status status;

    String review;

    @OneToOne
    User user;

    @OneToOne
    Filial filial;
}
