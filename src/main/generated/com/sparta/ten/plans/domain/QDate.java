package com.sparta.ten.plans.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDate is a Querydsl query type for Date
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QDate extends EntityPathBase<Date> {

    private static final long serialVersionUID = -1639037059L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDate date = new QDate("date");

    public final com.sparta.ten.commons.domain.QBaseDomainWithId _super;

    // inherited
    public final com.sparta.ten.accounts.domain.QAccount account;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt;

    //inherited
    public final NumberPath<Long> id;

    public final NumberPath<Integer> orderIndex = createNumber("orderIndex", Integer.class);

    public final QPlan plan;

    public final SetPath<Post, QPost> posts = this.<Post, QPost>createSet("posts", Post.class, QPost.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt;

    public QDate(String variable) {
        this(Date.class, forVariable(variable), INITS);
    }

    public QDate(Path<? extends Date> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QDate(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QDate(PathMetadata metadata, PathInits inits) {
        this(Date.class, metadata, inits);
    }

    public QDate(Class<? extends Date> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new com.sparta.ten.commons.domain.QBaseDomainWithId(type, metadata, inits);
        this.account = _super.account;
        this.createdAt = _super.createdAt;
        this.id = _super.id;
        this.plan = inits.isInitialized("plan") ? new QPlan(forProperty("plan"), inits.get("plan")) : null;
        this.updatedAt = _super.updatedAt;
    }

}

