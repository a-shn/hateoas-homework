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
public class MasterApplication {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Master master;

    @ManyToMany
    @JoinColumn(name = "advisers")
    private List<AcademicAdviser> advisers;

}
