package com.example.jparelationi1ex.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    @Size(min = 4, max = 10)
    @Column(columnDefinition = "varchar(10) not null")
    private String name;
    @NotNull
    @Positive
    @Column(columnDefinition = "int not null")
    private int age;
    @NotEmpty
    @Email
    @Size(min = 7, max = 20)
    @Column(columnDefinition = "varchar(20) not null")
    private String email;
    @NotNull
    @Positive
    @Column(columnDefinition = "int not null")
    private int salary;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher")
    private Set<Course> courses;
}
