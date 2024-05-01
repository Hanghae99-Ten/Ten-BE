package com.sparta.ten.plans.domain;

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
@Table(name = "planData")
public class PlanData extends BaseDomainWithId {
    @Column(name = "title", nullable = false)
    @Comment("제목")
    private String title;

    @Column(name = "start_date", nullable = false)
    @Comment("시작일")
    private LocalDate startedDate;

    @Column(name = "end_date", nullable = false)
    @Comment("종료일")
    private LocalDate endedDate;

    @Column(name = "location", columnDefinition = "TEXT")
    @Comment("위치")
    private String location;

    @Column(name = "is_open")
    @Comment("노출 여부")
    private Boolean isOpen;

    @Column(name = "hit")
    @Comment("조회수")
    private Long hit;

    @Column(name = "is_share")
    @Comment("공유 여부")
    private Boolean isShare;

    @OneToOne
    @JoinColumn(name = "planData_id")
    private Plan plan;

    @OneToMany
    @OrderBy("orderIndex asc")
    private Set<Date> dates = new LinkedHashSet<>();

    @Builder
    public PlanData(String title, LocalDate startedDate, LocalDate endedDate, String location, Boolean isOpen, Long hit, Boolean isShare, Plan plan, Set<Date> dates) {
        this.title = title;
        this.startedDate = startedDate;
        this.endedDate = endedDate;
        this.location = location;
        this.isOpen = isOpen;
        this.hit = hit;
        this.isShare = isShare;
        this.plan = plan;
        this.dates = dates;
    }
}
