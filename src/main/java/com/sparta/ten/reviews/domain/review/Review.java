package com.sparta.ten.reviews.domain.review;

import com.sparta.ten.accounts.domain.Account;
import com.sparta.ten.commons.domain.BaseDomainWithId;
import com.sparta.ten.plans.domain.Plan;
import com.sparta.ten.plans.domain.Post;
import lombok.*;
import org.hibernate.annotations.Comment;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "review")
public class Review extends BaseDomainWithId {

    @ManyToOne
    @JoinColumn(name = "plan_id")
    @Comment("포스트")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "accound_id")
    @Comment("유저 아이디")
    private Account account;

    @Column(name = "content", columnDefinition = "TEXT")
    @Comment("내용")
    private String content;

    @Column(name = "isOpen", nullable = false)
    @Comment("노출 여부")
    private boolean isOpen;

    @Column(name = "score", nullable = false)
    @Comment("별점")
    private float score;

}
