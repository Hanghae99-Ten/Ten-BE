package com.sparta.ten.plans.dto;

import com.sparta.ten.plans.domain.Date;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;

import io.swagger.annotations.ApiModelProperty;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

public class PostDto {

    @Getter
    @Setter
    public static class CreatePostDto{
        @ApiModelProperty(name = "date_id")
        private Long dateId;

        @ApiModelProperty(name = "title")
        private String title;

        @ApiModelProperty(name = "content")
        private String content;

        @ApiModelProperty(name = "location")
        private String location;

        @ApiModelProperty(name = "start_at")
        private LocalDateTime startAt;

        @ApiModelProperty(name = "end_at")
        private LocalDateTime endAt;

        @ApiModelProperty(name = "order_index")
        private Integer orderIndex;

        @JoinColumn(name = "date_id")
        private Date date;

        @ApiModelProperty(name = "memo")
        private String memo;
    }

    public static class UpdatePostDto{
        @ApiModelProperty(name = "order_index")
        private Integer orderIndex;
    }

    @Getter
    @Setter
    public static class ResponsePostDto{
        @ApiModelProperty(name = "id")
        private Long id;

        @ApiModelProperty(name = "created_at")
        private LocalDateTime createdAt;

        @ApiModelProperty(name = "updated_at")
        private LocalDateTime updatedAt;

        @ApiModelProperty(name = "title")
        private String title;

        @ApiModelProperty(name = "content")
        private String content;

        @ApiModelProperty(name = "location")
        private String location;

        @ApiModelProperty(name = "start_at")
        private LocalDateTime startAt;

        @ApiModelProperty(name = "end_at")
        private LocalDateTime endAt;

        @ApiModelProperty(name = "order_index")
        private Integer orderIndex;

        @JoinColumn(name = "date_id")
        private Date date;

        @ApiModelProperty(name = "memo")
        private String memo;
    }
}
