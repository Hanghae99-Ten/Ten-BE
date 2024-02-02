package com.sparta.ten.plans.dto;

import com.sparta.ten.accounts.dto.AccountDto;
import io.swagger.annotations.ApiOperation;
import lombok.Getter;
import lombok.Setter;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import java.time.LocalDate;

public class PlanDto {

    @Getter
    @Setter
    @ApiOperation("PlanDto.Create")
    public static class Create{

        @ApiModelProperty("제목")
        private String title;

        @ApiModelProperty("시작일")
        private LocalDate startedDate;

        @ApiModelProperty("종료일")
        private LocalDate endedDate;

        @ApiModelProperty("위치")
        private String location;

        @ApiModelProperty("노출 여부")
        private Boolean isOpen;

        @ApiModelProperty("조회수")
        private Long hit;

        @ApiModelProperty("공유 여부")
        private Boolean isShare;

        @ApiModelProperty("메모")
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

        @ApiModelProperty("노출 여부")
        private Boolean isOpen;

        @ApiModelProperty("조회수")
        private Long hit;

        @ApiModelProperty("공유 여부")
        private Boolean isShare;

        @ApiModelProperty("메모")
        private String memo;

    }

    @Getter
    @Setter
    @ApiOperation("PlanDto.Simple")
    public static class Simple{

        @ApiModelProperty("고유 아이디")
        private Long id;

        @ApiModelProperty("작성자")
        private AccountDto.Simple account;

        @ApiModelProperty("제목")
        private String title;

        @ApiModelProperty("시작일")
        private LocalDate startedDate;

        @ApiModelProperty("종료일")
        private LocalDate endedDate;

        @ApiModelProperty("위치")
        private String location;



    }

}
