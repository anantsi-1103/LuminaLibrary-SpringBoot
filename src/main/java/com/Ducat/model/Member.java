package com.Ducat.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "members")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Member name cannot be blank")
    @Size(max = 255, message = "Name cannot be exceeded 255 Character")
    private String name;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Please provide a valid email address")
    @Size(max = 255, message = "Email cannot exceed 255 characters")
    @Column(unique = true)
    private String email;

    @Size(max = 50, message = "Phone number cannot exceed 50 characters")
    private String phone;

    @NotBlank(message = "Join date cannot be blank")
    private String joinDate;

    public Member(String name, String email, String phone, String joinDate) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.joinDate = joinDate;
    }
}
