package com.sparta.ten.plans.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPlan is a Querydsl query type for Plan
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPlan extends EntityPathBase<Plan> {

    private static final long serialVersionUID = -1638669576L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPlan plan = new QPlan("plan");

    public final com.sparta.ten.commons.domain.QBaseDomainWithId _super;

    // inherited
    public final com.sparta.ten.accounts.domain.QAccount account;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt;

    public final SetPath<Date, QDate> dates = this.<Date, QDate>createSet("dates", Date.class, QDate.class, PathInits.DIRECT2);

    public final DatePath<java.time.LocalDate> endedDate = createDate("endedDate", java.time.LocalDate.class);

    public final NumberPath<Long> hit = createNumber("hit", Long.class);

    //inherited
    public final NumberPath<Long> id;

    public final BooleanPath isOpen = createBoolean("isOpen");

    public final BooleanPath isShare = createBoolean("isShare");

    public final StringPath location = createString("location");

    public final StringPath memo = createString("memo");

    public final DatePath<java.time.LocalDate> startedDate = createDate("startedDate", java.time.LocalDate.class);

    public final StringPath title = createString("title");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt;

    public QPlan(String variable) {
        this(Plan.class, forVariable(variable), INITS);
    }

    public QPlan(Path<? extends Plan> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPlan(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPlan(PathMetadata metadata, PathInits inits) {
        this(Plan.class, metadata, inits);
    }

    public QPlan(Class<? extends Plan> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new com.sparta.ten.commons.domain.QBaseDomainWithId(type, metadata, inits);
        this.account = _super.account;
        this.createdAt = _super.createdAt;
        this.id = _super.id;
        this.updatedAt = _super.updatedAt;
    }

}

