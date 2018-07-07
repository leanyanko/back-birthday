package com.example.backbirthday.Gift;

import lombok.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;

@CrossOrigin
@Data
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@Entity @Table(name = "GIFTS")
public class Gift {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "AMOUNT")
    private int amount;
}