package com.sparta.ten.plans.dto;

import com.sparta.ten.accounts.dto.AccountDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

public class PlanDto {

    @Getter
    @Setter
    public static class Create{

        @Schema(description = "제목")
        private String title;

        @Schema(description = "시작일")
        private LocalDate startedDate;

        @Schema(description = "종료일")
        private LocalDate endedDate;

        @Schema(description = "위치")
        private String location;

        @Schema(description = "노출 여부")
        private Boolean isOpen;

        @Schema(description = "조회수")
        private Long hit;

        @Schema(description = "공유 여부")
        private Boolean isShare;

        @Schema(description = "메모")
        private String memo;
    }

    @Getter
    @Setter
    public static class Update{
        private Integer orderIndex;
    }

    @Setter
    @Getter
    public static class Response extends Simple{

        @Schema(description = "노출 여부")
        private Boolean isOpen;

        @Schema(description = "조회수")
        private Long hit;

        @Schema(description = "공유 여부")
        private Boolean isShare;

        @Schema(description = "메모")
        private String memo;

    }

    @Getter
    @Setter
    public static class Simple{

        @Schema(description = "고유 아이디")
        private Long id;

        @Schema(description = "작성자")
        private AccountDto.Simple account;

        @Schema(description = "제목")
        private String title;

        @Schema(description = "시작일")
        private LocalDate startedDate;

        @Schema(description = "종료일")
        private LocalDate endedDate;

        @Schema(description = "위치")
        private String location;



    }

}
