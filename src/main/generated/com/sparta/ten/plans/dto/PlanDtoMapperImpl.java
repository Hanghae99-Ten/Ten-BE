package com.sparta.ten.plans.dto;

import com.sparta.ten.accounts.domain.Account;
import com.sparta.ten.accounts.dto.AccountDto;
import com.sparta.ten.plans.domain.Plan;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-05T13:16:29+0900",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 17.0.10 (Amazon.com Inc.)"
)
@Component
public class PlanDtoMapperImpl implements PlanDtoMapper {

    @Override
    public Plan dtoToEntity(PlanDto.Create dto) {
        if ( dto == null ) {
            return null;
        }

        Plan plan = new Plan();

        plan.setTitle( dto.getTitle() );
        plan.setStartedDate( dto.getStartedDate() );
        plan.setEndedDate( dto.getEndedDate() );
        plan.setLocation( dto.getLocation() );
        plan.setIsOpen( dto.getIsOpen() );
        if ( dto.getHit() != null ) {
            plan.setHit( dto.getHit().intValue() );
        }
        plan.setIsShare( dto.getIsShare() );
        plan.setMemo( dto.getMemo() );

        return plan;
    }

    @Override
    public PlanDto.Response entityToResponse(Plan entity) {
        if ( entity == null ) {
            return null;
        }

        PlanDto.Response response = new PlanDto.Response();

        response.setId( entity.getId() );
        response.setAccount( accountToSimple( entity.getAccount() ) );
        response.setTitle( entity.getTitle() );
        response.setStartedDate( entity.getStartedDate() );
        response.setEndedDate( entity.getEndedDate() );
        response.setLocation( entity.getLocation() );
        response.setIsOpen( entity.getIsOpen() );
        response.setHit( entity.getHit() );
        response.setIsShare( entity.getIsShare() );
        response.setMemo( entity.getMemo() );

        return response;
    }

    @Override
    public void map(PlanDto.Create dto, Plan entity) {
        if ( dto == null ) {
            return;
        }

        entity.setTitle( dto.getTitle() );
        entity.setStartedDate( dto.getStartedDate() );
        entity.setEndedDate( dto.getEndedDate() );
        entity.setLocation( dto.getLocation() );
        entity.setIsOpen( dto.getIsOpen() );
        if ( dto.getHit() != null ) {
            entity.setHit( dto.getHit().intValue() );
        }
        else {
            entity.setHit( null );
        }
        entity.setIsShare( dto.getIsShare() );
        entity.setMemo( dto.getMemo() );
    }

    protected AccountDto.Simple accountToSimple(Account account) {
        if ( account == null ) {
            return null;
        }

        AccountDto.Simple simple = new AccountDto.Simple();

        simple.setId( account.getId() );
        simple.setAccountUserId( account.getAccountUserId() );
        simple.setActive( account.isActive() );
        simple.setAccountProfileImage( account.getAccountProfileImage() );
        simple.setAccountBackgroundImage( account.getAccountBackgroundImage() );
        simple.setIntroduce( account.getIntroduce() );
        simple.setMbti( account.getMbti() );
        simple.setKakaoId( account.getKakaoId() );
        simple.setNaverId( account.getNaverId() );
        simple.setAccountRole( account.getAccountRole() );

        return simple;
    }
}
