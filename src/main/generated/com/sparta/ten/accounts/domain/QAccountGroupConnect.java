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

    public static final QAccountGroupConnect accountGroupConnect = new QAccountGroupConnect("accountGroupConnect");

    public final SetPath<Account, QAccount> accounts = this.<Account, QAccount>createSet("accounts", Account.class, QAccount.class, PathInits.DIRECT2);

    public final SetPath<Group, QGroup> groups = this.<Group, QGroup>createSet("groups", Group.class, QGroup.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QAccountGroupConnect(String variable) {
        super(AccountGroupConnect.class, forVariable(variable));
    }

    public QAccountGroupConnect(Path<? extends AccountGroupConnect> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAccountGroupConnect(PathMetadata metadata) {
        super(AccountGroupConnect.class, metadata);
    }

}

