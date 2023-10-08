package org.example.demo.entity;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name = "USERS")
@SQLDelete(sql = "UPDATE USERS SET deleted = true WHERE id=?")
//@Where(clause = "deleted=false")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private boolean deleted = Boolean.FALSE;

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
