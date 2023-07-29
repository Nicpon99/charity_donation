package pl.coderslab.charity.entity;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import jakarta.persistence.*;

@Entity
@Table(name = "institutions")
@Getter
@Setter
@ToString
public class Institution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Musisz podać nazwę instytucji")
    private String name;

    @NotEmpty(message = "Musisz podać opis instytucji")
    private String description;
}
