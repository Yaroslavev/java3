package org.example.enteties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_animals")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 100, nullable = false)
    private String name;
    private int age;
    @ManyToOne
    @JoinColumn(name = "animal_type_id", nullable = false)
    private AnimalType animalType;
    @ManyToOne
    @JoinColumn(name = "gender_id", nullable = false)
    private Gender gender;

    @Override
    public String toString() {
        return "Id: " + id + " Name: " + name + " Age: " + age + " Animal type: " + animalType + " Gender: " + gender;
    }
}
