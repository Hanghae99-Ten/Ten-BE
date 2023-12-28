package com.sparta.ten.commons.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.util.Streamable;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class PageableDto {

    @Getter
    @Setter
    public static class Request {

        @ApiModelProperty(value = "페이지", example = "0", required = false, position = 1)
        private int page = 0;

        @ApiModelProperty(value = "페이지 당 수", example = "20", required = false, position = 2)
        private int limit = 20;

        @ApiModelProperty(value = "정렬필드", example = "createdAt", required = false, position = 3)
        private String sort = "createdAt";

        @ApiModelProperty(value = "정렬필드", example = "desc", required = false, position = 3)
        private String dir = "desc";

        public Sort toSort() {
            return Sort.by(dir.equals("desc") ? Sort.Direction.DESC : Sort.Direction.ASC, sort);
        }

        public Sort.Order toOrder() {
            return dir.equals("desc") ? Sort.Order.desc(sort) : Sort.Order.asc(sort);
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class Response<T> implements Streamable<T> {

        public Response(Page<T> content) {
            this.totalElements = content.getTotalElements();
            this.number = content.getNumber();
            this.size = content.getSize();
        }

        @ApiModelProperty(value = "총갯수")
        private Long totalElements;

        @ApiModelProperty(value = "페이지당 개수")
        private Integer size;

        @ApiModelProperty(value = "페이지 번호")
        private Integer number;

        private List<T> content;


        @Override
        public Iterator<T> iterator() {
            return content.iterator();
        }

        public static <X, Y extends DomainWithMapper> Response<X> of(Page<Y> page) {
            Response result = new Response<>();
            result.setTotalElements(page.getTotalElements());
            result.setNumber(page.getNumber());
            result.setSize(page.getSize());
            result.setContent(
                    page.getContent()
                            .stream()
                            .map(v -> v.toResponse())
                            .collect(Collectors.toList())
            );

            return result;
        }


        /**
         * PagableDto.Response 형태로 반환
         **/
        public static <X, Y> Response<X> of(Page<Y> page, List<X> dataList) {
            Response<X> result = new Response<>();

            int pageNow = page.getNumber();

            //페이지 당 결과수
            result.setSize(page.getSize());

            //결과 총 수
            result.setTotalElements(page.getTotalElements());

            //현재 페이지 번호
            result.setNumber(pageNow);

            //DATA SET
            result.setContent(dataList);

            pageNow += 1;

            return result;
        }
    }
}

