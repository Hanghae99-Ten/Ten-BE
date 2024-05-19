package com.sparta.ten.plans.domain;

import com.sparta.ten.accounts.domain.Group;
import com.sparta.ten.commons.domain.BaseDomainWithId;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "plan")
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "group_id")
    private Group group;

    @Column(nullable = true)
    @Enumerated(value = EnumType.STRING)
    private PlanMbtiEnum mbti;

    @Builder
    public Plan(Group group, PlanMbtiEnum mbti) {
        this.group = group;
        this.mbti = mbti;
    }
}
