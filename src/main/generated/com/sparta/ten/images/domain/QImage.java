package com.sparta.ten.images.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QImage is a Querydsl query type for Image
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QImage extends EntityPathBase<Image> {

    private static final long serialVersionUID = -1767327920L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QImage image = new QImage("image");

    public final com.sparta.ten.commons.domain.QBaseDomainWithId _super;

    // inherited
    public final com.sparta.ten.accounts.domain.QAccount account;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt;

    //inherited
    public final NumberPath<Long> id;

    public final EnumPath<ImageType> imageType = createEnum("imageType", ImageType.class);

    public final StringPath img = createString("img");

    public final NumberPath<Long> typeId = createNumber("typeId", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt;

    public QImage(String variable) {
        this(Image.class, forVariable(variable), INITS);
    }

    public QImage(Path<? extends Image> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QImage(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QImage(PathMetadata metadata, PathInits inits) {
        this(Image.class, metadata, inits);
    }

    public QImage(Class<? extends Image> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new com.sparta.ten.commons.domain.QBaseDomainWithId(type, metadata, inits);
        this.account = _super.account;
        this.createdAt = _super.createdAt;
        this.id = _super.id;
        this.updatedAt = _super.updatedAt;
    }

}

