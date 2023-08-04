package com.sparta.ten.commons.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<O, P> extends JpaRepository<O, P>, JpaSpecificationExecutor<O> {
}
