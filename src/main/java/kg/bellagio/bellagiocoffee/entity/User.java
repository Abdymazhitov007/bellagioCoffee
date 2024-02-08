package kg.bellagio.bellagiocoffee.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import kg.bellagio.bellagiocoffee.entity.enums.Gender;
import kg.bellagio.bellagiocoffee.entity.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate createdDate;
    private LocalDate endDate;
    private String fistName;
    private String lastName;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfBirth;
    @Column(unique = true)
    private String phoneNumber;
    private String email;
    private String login;
    private String password;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Enumerated(EnumType.STRING)
    private Status status;

}
