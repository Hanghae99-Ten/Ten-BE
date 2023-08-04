package com.sparta.ten.plans.domain;

import com.sparta.ten.commons.domain.BaseDomainWithId;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;


@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "plan")
public class Post extends BaseDomainWithId {
}
