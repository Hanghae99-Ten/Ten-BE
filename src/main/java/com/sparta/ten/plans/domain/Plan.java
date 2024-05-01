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

//    @Column(name = "title", nullable = false)
//    @Comment("제목")
//    private String title;
//
//    @Column(name = "start_date", nullable = false)
//    @Comment("시작일")
//    private LocalDate startedDate;
//
//    @Column(name = "end_date", nullable = false)
//    @Comment("종료일")
//    private LocalDate endedDate;
//
//    @Column(name = "location", columnDefinition = "TEXT")
//    @Comment("위치")
//    private String location;
//
//    @Column(name = "is_open")
//    @Comment("노출 여부")
//    private Boolean isOpen;
//
//    @Column(name = "hit")
//    @Comment("조회수")
//    private Long hit;
//
//    @Column(name = "is_share")
//    @Comment("공유 여부")
//    private Boolean isShare;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "group_id")
    private Group group;

//    @OneToMany(mappedBy = "plan" , cascade = CascadeType.ALL)
//    @OrderBy("orderIndex asc")
//    private Set<Date> dates = new LinkedHashSet<>();

    @Column(nullable = true)
    @Enumerated(value = EnumType.STRING)
    private PlanMbtiEnum mbti;

    @Builder
    public Plan(Group group, PlanMbtiEnum mbti) {
        this.group = group;
        this.mbti = mbti;
    }
}
