package com.example.backbirthday.User;

import com.example.backbirthday.Birthday.Birthday;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@CrossOrigin
@Data
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@Entity @Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "creator", cascade=CascadeType.ALL)
    @JsonIgnore
    private Set<Birthday> birthdays = new HashSet<> ();

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "DONATORS",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "birthday_id") })
    private Set<Birthday> donators = new HashSet<>();

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "ABOUT_ME")
    private String aboutMe;

    @Column(name = "PASSWORD")
    private String password;
}