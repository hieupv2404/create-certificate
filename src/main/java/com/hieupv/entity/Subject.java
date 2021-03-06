package com.hieupv.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private float score;
    private int process;
    @ManyToOne
    @JoinColumn(name = "student_id") // thông qua khóa ngoại address_id
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Student student;
    private int certificate;
    @Column(name = "date_of_done")
    private Timestamp dateOfDone;
}
