package com.sparta.ten.images.domain;

import com.sparta.ten.commons.domain.BaseDomainWithId;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Comment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "post")
public class Image extends BaseDomainWithId {

    @Column(name = "image")
    @Comment("이미지")
    private ImageType imageType;

    @Column(name = "typeId")
    @Comment("타입 아이디")
    private Long typeId;

    @Column(name = "img")
    @Comment("이미지 링크")
    private String img;
}
