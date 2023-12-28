package com.sparta.ten.plans.dto;

import io.swagger.annotations.ApiOperation;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;

import javax.persistence.Column;
import java.time.LocalDate;

public class PlanDto {

    @Getter
    @Setter
    @ApiOperation("PlanDto.Create")
    public static class Create{
        private String title;

        private LocalDate startedDate;

        private LocalDate endedDate;

        private String location;

        private Boolean isOpen;

        private Long hit;

        private Boolean isShare;

        private String memo;
    }

    @Getter
    @Setter
    @ApiOperation("PlanDto.Update")
    public static class Update{
        private Integer orderIndex;
    }

    @Setter
    @Getter
    @ApiOperation("PlanDto.Response")
    public static class Response extends Simple{

        @Comment("노출 여부")
        private Boolean isOpen;

        @Comment("조회수")
        private Integer hit;

        @Comment("공유 여부")
        private Boolean isShare;

        @Comment("메모")
        private String memo;

    }

    @Getter
    @Setter
    @ApiOperation("PlanDto.Simple")
    public static class Simple{

        @Comment("고유 아이디")
        private Long id;

        @Comment("작성자")
        private AccountDto.Simple account;

        @Comment("제목")
        private String title;

        @Comment("시작일")
        private LocalDate startedDate;

        @Comment("종료일")
        private LocalDate endedDate;

        @Comment("위치")
        private String location;



    }

}
