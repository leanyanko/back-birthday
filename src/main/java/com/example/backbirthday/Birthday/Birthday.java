package com.example.backbirthday.Birthday;

import com.example.backbirthday.Gift.Gift;
import com.example.backbirthday.User.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@CrossOrigin
@Data
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@Entity @Table(name = "BIRTHDAYS")
public class Birthday {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="CREATOR")
    @JsonIgnore
    private User creator;

    @Column(name = "TOTAL_GIVEN")
    private int totalGiven;

    @Column(name="ENDING")
    private Date ending;
}