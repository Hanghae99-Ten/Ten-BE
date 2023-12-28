package com.sparta.ten.plans.domain;

import com.sparta.ten.commons.domain.BaseDomain;
import com.sparta.ten.commons.domain.BaseDomainWithId;
import com.sparta.ten.commons.dto.DomainWithMapper;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "date")
public class Date extends BaseDomainWithId implements DomainWithMapper {

    private Integer orderIndex;

    @ManyToOne(fetch = FetchType.LAZY)
    private Plan plan;

    @OneToMany(mappedBy = "date", cascade = CascadeType.ALL)
    @OrderBy("orderIndex asc ")
    private Set<Post> posts = new LinkedHashSet<>();

    @Override
    public Object toResponse() {
        return null;
    }
}
