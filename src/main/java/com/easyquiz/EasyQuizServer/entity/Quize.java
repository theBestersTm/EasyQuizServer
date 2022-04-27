package com.easyquiz.EasyQuizServer.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by sgva1 on 4/5/2020.
 */

@Entity
@Setter
@Getter
@Table(name = "quize")
public class Quize {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String question;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "quize")
    private Set<Answer> answers;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "users")
    private User users;

    @Override
    public String toString() {
        return "Quize{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", users=" + users +
                '}';
    }
}
