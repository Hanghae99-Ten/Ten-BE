package com.sparta.ten.accounts.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAccountGroupConnect is a Querydsl query type for AccountGroupConnect
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAccountGroupConnect extends EntityPathBase<AccountGroupConnect> {

    private static final long serialVersionUID = -1629486849L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAccountGroupConnect accountGroupConnect = new QAccountGroupConnect("accountGroupConnect");

    public final QAccount account;

    public final QGroup group;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QAccountGroupConnect(String variable) {
        this(AccountGroupConnect.class, forVariable(variable), INITS);
    }

    public QAccountGroupConnect(Path<? extends AccountGroupConnect> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAccountGroupConnect(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAccountGroupConnect(PathMetadata metadata, PathInits inits) {
        this(AccountGroupConnect.class, metadata, inits);
    }

    public QAccountGroupConnect(Class<? extends AccountGroupConnect> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.account = inits.isInitialized("account") ? new QAccount(forProperty("account")) : null;
        this.group = inits.isInitialized("group") ? new QGroup(forProperty("group")) : null;
    }

}

