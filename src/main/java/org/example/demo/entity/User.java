package org.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "skl_users")
@SQLDelete(sql = "UPDATE skl_users SET usr_deleted = true WHERE usr_id = ?")
@Where(clause = "usr_deleted = false")
public class User {
    @Column (name = "usr_deleted")
    private final boolean deleted = Boolean.FALSE;

    @Id
    @Column (name = "usr_id")
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column (name = "usr_first_name", length = 31)
    @Getter
    @Setter
    private String firstName;

    @Column (name = "usr_last_name", length = 31)
    @Getter
    @Setter
    private String lastName;

    @Column (name = "usr_middle_name", length = 31)
    @Getter
    @Setter
    private String middleName;

    @Column(name = "usr_sex", length = 1)
    @Getter
    @Setter
    private String sex;

    @Column (name = "usr_birth_date")
    @Temporal(TemporalType.DATE)
    @Getter
    @Setter
    private Date birthDate;

//    @MapsId
//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @Getter
//    @Setter
//    @JoinColumn (name = "city_residence_id")
//    private City cityResidenceId;

    @Column (name = "usr_photo_url")
    @Getter
    @Setter
    private String photoUrl;

    @Column (name = "usr_description", columnDefinition = "TEXT")
    @Getter
    @Setter
    private String description;

    @Column (name = "usr_nick_name", length = 31)
    @Getter
    @Setter
    private String nickName;

    @Column (name = "usr_hardskills")
    @Getter
    @Setter
    private String hardskills;

    @Column (name = "usr_email", length = 31)
    @Getter
    @Setter
    private String email;

    @Column (name = "usr_phone", length = 20)
    @Getter
    @Setter
    private Integer phone;

    @ManyToOne
    @JoinColumn(name = "usr_ct_id")
    @Getter
    @Setter
    private City city;

    @ManyToMany
    @JoinTable (name = "skl_users_followings")
    @Getter
    @Setter
    private Set<User> followings;


//    @ManyToMany
//    @JoinTable(name = "followings_map",
//        joinColumns = @JoinColumn(name = "id", referencedColumnName = "id"),
//        inverseJoinColumns = @JoinColumn(name = "id", referencedColumnName = "following_id")
//    )
//    private Set<User> followings;

//    @ManyToMany
//    @JoinTable(name = "followings_map",
//            joinColumns = @JoinColumn(name = "following_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "id", referencedColumnName = "follower_id")
//    )
//    private Set<User> followers;

    public User() {
    }

    public User(String firstName, String lastName, String middleName, String sex, Date birthDate, String photoUrl, String description, String nickName, String hardskills, String email, Integer phone, Integer city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.sex = sex;
        this.birthDate = birthDate;
        this.photoUrl = photoUrl;
        this.description = description;
        this.nickName = nickName;
        this.hardskills = hardskills;
        this.email = email;
        this.phone = phone;

    }


    @Override
    public String toString() {
        return "User{" + "id=" + id + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", deleted='" + deleted + '\'' + '}';
    }
}
