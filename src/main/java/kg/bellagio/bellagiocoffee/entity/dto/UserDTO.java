package kg.bellagio.bellagiocoffee.entity.dto;

import kg.bellagio.bellagiocoffee.entity.enums.Gender;
import kg.bellagio.bellagiocoffee.entity.enums.Status;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
public class UserDTO {
    Long id;
    LocalDate createdDate;
    LocalDate endDate;
    String fistName;
    String lastName;
    LocalDate dateOfBirth;
    String phoneNumber;
    String email;
    String login;
    String password;
    Gender gender;
    Status status;

}
