package com.sparta.ten.plans.dto;

import io.swagger.annotations.ApiOperation;
import lombok.Getter;
import lombok.Setter;

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

    }

    @Setter
    @Getter
    @ApiOperation("PlanDto.Response")
    public static class Response extends Simple{

    }

    @Getter
    @Setter
    @ApiOperation("PlanDto.Simple")
    public static class Simple{

    }

}
