package com.sparta.ten.commons.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBaseDomainWithId is a Querydsl query type for BaseDomainWithId
 */
@Generated("com.querydsl.codegen.DefaultSupertypeSerializer")
public class QBaseDomainWithId extends EntityPathBase<BaseDomainWithId> {

    private static final long serialVersionUID = 383095395L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBaseDomainWithId baseDomainWithId = new QBaseDomainWithId("baseDomainWithId");

    public final com.sparta.ten.accounts.domain.QAccount account;

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.time.LocalDateTime> updatedAt = createDateTime("updatedAt", java.time.LocalDateTime.class);

    public QBaseDomainWithId(String variable) {
        this(BaseDomainWithId.class, forVariable(variable), INITS);
    }

    public QBaseDomainWithId(Path<? extends BaseDomainWithId> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBaseDomainWithId(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBaseDomainWithId(PathMetadata metadata, PathInits inits) {
        this(BaseDomainWithId.class, metadata, inits);
    }

    public QBaseDomainWithId(Class<? extends BaseDomainWithId> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.account = inits.isInitialized("account") ? new com.sparta.ten.accounts.domain.QAccount(forProperty("account")) : null;
    }

}

