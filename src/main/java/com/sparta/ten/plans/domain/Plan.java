package com.sparta.ten.plans.domain;

import com.sparta.ten.commons.domain.BaseDomainWithId;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "plan")
public class Plan extends BaseDomainWithId {

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
    private Integer hit;

    @Column(name = "is_share")
    @Comment("공유 여부")
    private Boolean isShare;

    @Column(name = "memo")
    @Comment("메모")
    private String memo;

    @OneToMany(mappedBy = "plan" , cascade = CascadeType.ALL)
    @OrderBy("orderIndex asc")
    private Set<Date> dates = new LinkedHashSet<>();

}
