package com.sparta.ten.accounts.domain;


import com.sparta.ten.plans.domain.Plan;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "account_group")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private GroupTypeEnum type;

    @Column(nullable = false)
    private String groupName;

//    @ManyToOne
//    @JoinColumn(name = "plan_id")
//    private Plan plans;

}
