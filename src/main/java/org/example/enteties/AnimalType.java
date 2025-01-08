package org.example.enteties;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tbl_animal_types")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 100)
    private String name;
    @OneToMany(mappedBy = "animalType", cascade = CascadeType.PERSIST)
    private List<Animal> animals;

    @Override
    public String toString() {
        return name;
    }
}
