package com.mydojo.entites;

import com.mydojo.dtos.UserDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="Users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;

    @Column
    private String password;

    @Column
    private Boolean isAdmin;

    public User(UserDto src) {
        if (src.getId() != null) {
            this.id = src.getId();
        }

        if (src.getEmail() != null) {
            this.email = src.getEmail();
        }

        if (src.getPassword() != null) {
            this.password = src.getPassword();
        }

        if (src.getIsAdmin() != null) {
            this.isAdmin = src.getIsAdmin();
        }
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public boolean equals(Object obj) {
        return  (obj instanceof User ?
                Objects.equals(((User) obj).id, id) : false);
    }
}
