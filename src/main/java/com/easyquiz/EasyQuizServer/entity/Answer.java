package com.easyquiz.EasyQuizServer.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by sgva1 on 4/5/2020.
 */

@Table(name = "answers")
@Entity
@Getter
@Setter
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String answer;
    private Integer right_answer;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "quize")
    private Quize quize;

    public Answer() {
    }

    public Answer(String answer, Quize quize, Integer right_answer) {


        this.answer = answer;

        this.quize = quize;

        this.right_answer = right_answer;


   }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", answer='" + answer + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Answer answer1 = (Answer) o;

        if (id != null ? !id.equals(answer1.id) : answer1.id != null) return false;
        return answer != null ? answer.equals(answer1.answer) : answer1.answer == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (answer != null ? answer.hashCode() : 0);
        return result;
    }
}
