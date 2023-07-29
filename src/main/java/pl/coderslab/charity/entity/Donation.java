package pl.coderslab.charity.entity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.charity.validation.FirstStep;
import pl.coderslab.charity.validation.FourthStep;
import pl.coderslab.charity.validation.SecondStep;
import pl.coderslab.charity.validation.ThirdStep;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "donations")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Musisz podać liczbę worków", groups = SecondStep.class)
    @Min(value = 1, message = "Mnimalna wartość dla liczby worków to 1", groups = SecondStep.class)
    private Integer quantity;

    @NotEmpty(message = "Musisz podać numer domu", groups = FourthStep.class)
    private String homeNumber;

    private String flatNumber;

    @NotEmpty(message = "Musisz podać nazwę ulicy", groups = FourthStep.class)
    private String street;

    @NotEmpty(message = "Musisz podać nazwę miejscowości", groups = FourthStep.class)
    private String city;

    @NotEmpty(message = "Musisz podać kod pocztowy", groups = FourthStep.class)
    @Pattern(regexp = "^\\d{2}-\\d{3}$", message = "Niepoprawny format kodu pocztowego. Prawidłowa forma to 00-000",
            groups = FourthStep.class)
    private String zipCode;

    @NotEmpty(message = "Musisz podać swój numer telefonu", groups = FourthStep.class)
    @Pattern(regexp = "^\\d{9}$", message = "Niepoprawny format numeru telefonu", groups = FourthStep.class)
    private String phoneNumber;

    @NotNull(message = "Musisz podać datę odbioru", groups = FourthStep.class)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate pickUpDate;

    @NotNull(message = "Musisz podać godzinę odbioru", groups = FourthStep.class)
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime pickUpTime;

    private String pickUpComment;

    @NotNull(message = "Musisz wybrać instytucję, do której chcesz przekazać swoje dary", groups = ThirdStep.class)
    @ManyToOne
    private Institution institution;

    @NotEmpty(message = "Musisz wybrać przynajmniej jedną kategorię", groups = FirstStep.class)
    @ManyToMany
    @JoinTable(name = "donation_category", joinColumns = @JoinColumn(name = "donation_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories;

    @ManyToOne
    private User user;
}
