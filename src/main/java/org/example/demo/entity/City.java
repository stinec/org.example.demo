package org.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "skl_cities_ref")
@SQLDelete(sql = "UPDATE skl_cities_ref SET ct_deleted = true WHERE id = ?")
@Where(clause = "ct_deleted = false")
public class City {
    @Column(name="ct_deleted")
    private final boolean deleted = Boolean.FALSE;

    @Id
    @Column(name="ct_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private Integer id;

    @Column (name="ct_name", length = 31, nullable = false)
    @Getter
    @Setter
    private String name;

//    @Getter
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cityResidenceId")
//    private Set<User> user;
}
