package com.sparta.ten.plans.domain;

import com.sparta.ten.commons.domain.BaseDomainWithId;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Entity
@NoArgsConstructor
@Table(name = "post")
@Setter
public class Post extends BaseDomainWithId {

    @Column(name = "title")
    @Comment("제목")
    private String title;

    @Column(name = "content", columnDefinition = "TEXT")
    @Comment("내용")
    private String content;

    @Column(name = "location", columnDefinition = "TEXT")
    @Comment("위치")
    private String location;

    @Column(name = "start_at")
    @Comment("시작일시")
    private LocalDateTime startAt;

    @Column(name = "end_at")
    @Comment("종료 일시")
    private LocalDateTime endAt;

    @Column(name = "order_index")
    @Comment("순서")
    private Integer orderIndex;

    @ManyToOne
    @JoinColumn(name = "date_id")
    @Comment("일자 외래키")
    private Date date;

    @Column(name = "memo")
    @Comment("메모")
    private String memo;

    @Builder
    public Post(String title, String content, String location, LocalDateTime startAt, LocalDateTime endAt, Integer orderIndex, Date date, String memo) {
        this.title = title;
        this.content = content;
        this.location = location;
        this.startAt = startAt;
        this.endAt = endAt;
        this.orderIndex = orderIndex;
        this.date = date;
        this.memo = memo;
    }
}
