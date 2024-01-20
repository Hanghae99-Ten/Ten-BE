package com.sparta.ten.accounts.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAccount is a Querydsl query type for Account
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAccount extends EntityPathBase<Account> {

    private static final long serialVersionUID = -2032624268L;

    public static final QAccount account = new QAccount("account");

    public final StringPath accountBackgroundImage = createString("accountBackgroundImage");

    public final StringPath accountName = createString("accountName");

    public final StringPath accountProfileImage = createString("accountProfileImage");

    public final EnumPath<AccountRoleEnum> accountRole = createEnum("accountRole", AccountRoleEnum.class);

    public final StringPath accountUserId = createString("accountUserId");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath introduce = createString("introduce");

    public final BooleanPath isActive = createBoolean("isActive");

    public final NumberPath<Long> kakaoId = createNumber("kakaoId", Long.class);

    public final EnumPath<AccountMbtiEnum> mbti = createEnum("mbti", AccountMbtiEnum.class);

    public final StringPath naverId = createString("naverId");

    public final StringPath password = createString("password");

    public QAccount(String variable) {
        super(Account.class, forVariable(variable));
    }

    public QAccount(Path<? extends Account> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAccount(PathMetadata metadata) {
        super(Account.class, metadata);
    }

}

