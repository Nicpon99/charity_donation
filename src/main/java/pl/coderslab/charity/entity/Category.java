package pl.coderslab.charity.entity;

import lombok.*;

import jakarta.persistence.*;

@Entity
@Table(name = "categories")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
