package pl.coderslab.charity.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Musisz podać adres e-mail")
    @Email
    private String username;

    @Pattern(regexp = "^[A-Z].+$",
            message = "Imię powinno zaczynać się od wielkiej litery i posiadać co najmniej 2 znaki")
    private String name;

    @Pattern(regexp = "^[A-Z].+$",
            message = "Nazwisko powinno zaczynać się od wielkiej litery i posiadać co najmniej 2 znaki")
    private String surname;

    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[0-9]).{6,}$",
            message = "Hasło musi zawierać przynajmniej jedną wielką literę, przynajmniej jedną cyfrę" +
                    " i składać się z co najmniej 6 znaków")
    private String password;

    private int enabled;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

}
