package com.sparta.ten.reviews.domain.review;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReview is a Querydsl query type for Review
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReview extends EntityPathBase<Review> {

    private static final long serialVersionUID = -1629428434L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReview review = new QReview("review");

    public final com.sparta.ten.commons.domain.QBaseDomainWithId _super;

    public final com.sparta.ten.accounts.domain.QAccount account;

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt;

    //inherited
    public final NumberPath<Long> id;

    public final BooleanPath isOpen = createBoolean("isOpen");

    public final com.sparta.ten.plans.domain.QPost post;

    public final NumberPath<Float> score = createNumber("score", Float.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt;

    public QReview(String variable) {
        this(Review.class, forVariable(variable), INITS);
    }

    public QReview(Path<? extends Review> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReview(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReview(PathMetadata metadata, PathInits inits) {
        this(Review.class, metadata, inits);
    }

    public QReview(Class<? extends Review> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new com.sparta.ten.commons.domain.QBaseDomainWithId(type, metadata, inits);
        this.account = inits.isInitialized("account") ? new com.sparta.ten.accounts.domain.QAccount(forProperty("account")) : null;
        this.createdAt = _super.createdAt;
        this.id = _super.id;
        this.post = inits.isInitialized("post") ? new com.sparta.ten.plans.domain.QPost(forProperty("post"), inits.get("post")) : null;
        this.updatedAt = _super.updatedAt;
    }

}

