package com.bank.profile.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="profile")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="phone_number")
    private long phoneNumber;

    @Column(name="email")
    private String email;

    @Column(name="name_on_card")
    private String nameOnCard;

    @Column(name="inn")
    private long inn;

    @Column(name="snils")
    private long snils;

    @Column(name="passport_id")
    private long passportId;

    @Column(name="actual_registration_id")
    private long actualRegistrationId;

    public Profile(long phoneNumber, String email, String nameOnCard, long inn, long snils, long passportId, long actualRegistrationId) {
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.nameOnCard = nameOnCard;
        this.inn = inn;
        this.snils = snils;
        this.passportId = passportId;
        this.actualRegistrationId = actualRegistrationId;
    }
}
