package com.sparta.ten.plans.dto;

import com.sparta.ten.plans.domain.Date;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.JoinColumn;
import java.time.LocalDateTime;

public class PostDto {

    @Getter
    @Setter
    public static class CreatePostDto{
        @Schema(description = "title")
        private String title;

        @Schema(description = "content")
        private String content;

        @Schema(description = "location")
        private String location;

        @Schema(description = "start_at")
        private LocalDateTime startAt;

        @Schema(description = "end_at")
        private LocalDateTime endAt;

        @Schema(description = "order_index")
        private Integer orderIndex;

        @JoinColumn(name = "date_id")
        private Date date;

        @Schema(description = "memo")
        private String memo;
    }

    public static class UpdatePostDto{
        @Schema(description = "order_index")
        private Integer orderIndex;
    }

    @Getter
    @Setter
    public static class ResponsePostDto{
        @Schema(description = "id")
        private Long id;

        @Schema(description = "created_at")
        private LocalDateTime createdAt;

        @Schema(description = "updated_at")
        private LocalDateTime updatedAt;

        @Schema(description = "title")
        private String title;

        @Schema(description = "content")
        private String content;

        @Schema(description = "location")
        private String location;

        @Schema(description = "start_at")
        private LocalDateTime startAt;

        @Schema(description = "end_at")
        private LocalDateTime endAt;

        @Schema(description = "order_index")
        private Integer orderIndex;

        @JoinColumn(name = "date_id")
        private Date date;

        @Schema(description = "memo")
        private String memo;
    }
}
