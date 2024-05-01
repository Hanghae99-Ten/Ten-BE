package com.sparta.ten.accounts.domain;


import com.sparta.ten.plans.domain.Plan;
import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity(name = "account_group")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private GroupTypeEnum groupType;

    @Column(nullable = false)
    private String groupName;

//    @ManyToOne
//    @JoinColumn(name = "plan_id")
//    private Plan plans;


    @Builder
    public Group(Long id, GroupTypeEnum groupType, String groupName) {
        this.id = id;
        this.groupType = groupType;
        String newName;
        if (groupType == GroupTypeEnum.TEAM) {
            newName = groupName + "의 팀";
        } else {
            newName = groupName;
        }
        this.groupName = newName;
    }
}
