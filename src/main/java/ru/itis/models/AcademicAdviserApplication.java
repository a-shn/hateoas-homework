package ru.itis.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AcademicAdviserApplication {
    @Id
    @GeneratedValue
    private Long id;

    private Integer required;

    @OneToOne
    private AcademicAdviser academicAdviser;

    @ManyToMany
    @JoinColumn(name = "masters")
    private List<Master> masters;

}
