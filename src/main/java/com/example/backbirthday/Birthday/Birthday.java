package com.example.backbirthday.Birthday;

import com.example.backbirthday.Gift.Gift;
import com.example.backbirthday.User.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;

@CrossOrigin
@Data
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@Entity @Table(name = "BIRTHDAYS")
public class Birthday {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CREATOR", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "WANTED_GIFTS", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Gift gift;
}