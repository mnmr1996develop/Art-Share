package com.michaelrichards.artshare.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;


@Getter
@Setter
@Builder
@Entity
@Table(name = "m_user",
        uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email")
})
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Size(max = 20)
    @Column(nullable = false, unique = true, length = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email(message = "Must be a valid email")
    @Column(nullable = false, unique = true, length = 50)
    private String email;

    @NotBlank
    @Size(max = 20)
    @Column(name = "first_name", length = 20, nullable = false)
    private String firstName;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;


    @NotBlank
    @Column(name = "last_name", length = 20, nullable = false)
    private String lastName;

    @Past(message = "birthday must be in the past")
    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;

    @Size(max = 120)
    @Column(name = "avatar_url", length = 120)
    private String avatarUrl;

    @Size(max = 500)
    @Column(length = 500)
    private String bio;

    @Transient
    public Integer getAge() {
        if (this.birthday == null) {
            return null; // Or throw an exception if birthday is mandatory
        }
        return Period.between(this.birthday, LocalDate.now()).getYears();
    }
}
