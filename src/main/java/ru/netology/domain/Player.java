package ru.netology.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class Player {
    private int id;
    private String name;
    private int strength;
}
