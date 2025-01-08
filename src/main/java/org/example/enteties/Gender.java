package org.example.enteties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tbl_genders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Gender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 50)
    private String name;
    @OneToMany(mappedBy = "gender", cascade = CascadeType.PERSIST)
    private List<Animal>  animals;

    @Override
    public String toString() {
        return name;
    }
}
