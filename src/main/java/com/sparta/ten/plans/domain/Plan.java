package com.sparta.ten.plans.domain;

import com.sparta.ten.commons.domain.BaseDomainWithId;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private String title;

    @Column(name = "start_date", nullable = false)
    private LocalDate startedDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endedDate;

    @Column(name = "location")
    private String location;

    @Column(name = "is_open")
    private Boolean isOpen;

    @Column(name = "hit")
    private Boolean isOpen;

    @Column(name = "is_share")
    private Boolean isShare;

    @Column(name = "memo")
    private String memo;

    @OneToMany(mappedBy = "plan", cascade = CascadeType.ALL)
    @OrderBy("createdAt")
    private Set<Post> posts = new LinkedHashSet<>();


}
