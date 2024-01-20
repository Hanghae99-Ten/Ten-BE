package com.sparta.ten.commons.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBaseDomain is a Querydsl query type for BaseDomain
 */
@Generated("com.querydsl.codegen.DefaultSupertypeSerializer")
public class QBaseDomain extends EntityPathBase<BaseDomain> {

    private static final long serialVersionUID = -658374846L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBaseDomain baseDomain = new QBaseDomain("baseDomain");

    public final com.sparta.ten.accounts.domain.QAccount account;

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> updatedAt = createDateTime("updatedAt", java.time.LocalDateTime.class);

    public QBaseDomain(String variable) {
        this(BaseDomain.class, forVariable(variable), INITS);
    }

    public QBaseDomain(Path<? extends BaseDomain> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBaseDomain(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBaseDomain(PathMetadata metadata, PathInits inits) {
        this(BaseDomain.class, metadata, inits);
    }

    public QBaseDomain(Class<? extends BaseDomain> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.account = inits.isInitialized("account") ? new com.sparta.ten.accounts.domain.QAccount(forProperty("account")) : null;
    }

}

