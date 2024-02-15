package org.example.demo.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;

@Entity
@Table(name = "USERS")
@SQLDelete(sql = "UPDATE USERS SET deleted = true WHERE id=?")
//@Where(clause = "deleted=false")
public class Users {
    private final boolean deleted = Boolean.FALSE;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;

    public Users() {
    }

    public Users(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", deleted='" + deleted + '\'' + '}';
    }
}
