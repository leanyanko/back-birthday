package com.example.backbirthday.Birthday;

import com.example.backbirthday.User.User;
import lombok.*;
import javax.persistence.*;
import java.util.HashSet;

@Data
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@Entity @Table(name = "BIRTHDAYS")
public class Birthday {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "user", cascade=CascadeType.ALL)
    private User user = new User ();

    @Column(name = "WANTED_GIFTS")
    private String wantedGifts;
}