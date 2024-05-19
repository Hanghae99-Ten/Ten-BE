package com.sparta.ten.plans.services;

import com.sparta.ten.accounts.domain.Account;
import com.sparta.ten.accounts.domain.AccountGroupConnect;
import com.sparta.ten.accounts.domain.Group;
import com.sparta.ten.accounts.domain.GroupTypeEnum;
import com.sparta.ten.accounts.repository.AccountGroupConnectRepository;
import com.sparta.ten.accounts.repository.AccountRepository;
import com.sparta.ten.accounts.repository.GroupRepository;
import com.sparta.ten.exception.CustomException;
import com.sparta.ten.plans.domain.Plan;
import com.sparta.ten.plans.repository.PlanRepository;
import com.sparta.ten.plans.dto.PlanMapper;
import com.sparta.ten.plans.dto.PlanPorJCreateRequest;
import com.sparta.ten.plans.dto.PlanPorJCreateResponse;
import com.sparta.ten.security.UserDetailsImpl;
import com.sparta.ten.util.StatusResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.sparta.ten.accounts.domain.AccountGroupRoleEnum.CREATOR;
import static com.sparta.ten.exception.message.ErrorMsg.NOT_FOUND_ACCOUNT;
import static com.sparta.ten.exception.message.SuccessMsg.P_OR_J_SELECT_SUCCESS;


@Service
@RequiredArgsConstructor
public class PlanService {

    private final AccountRepository accountRepository;
    private final PlanMapper planMapper;
    private final GroupRepository groupRepository;
    private final AccountGroupConnectRepository accountGroupConnectRepository;
    private final PlanRepository planRepository;

    @Transactional
    public StatusResponseDto<?> planPorJCreateRequest(PlanPorJCreateRequest planPorJCreateRequest, UserDetailsImpl userDetails) {
        Account account = accountRepository.findByAccountUserId(userDetails.getUsername()).orElseThrow(
                () -> new CustomException(NOT_FOUND_ACCOUNT)
        );

        Group group = Group.builder()
                .groupType(GroupTypeEnum.INDIVIDUAL)
                .groupName(account.getAccountName())
                .build();

        AccountGroupConnect accountGroupConnect = AccountGroupConnect.builder()
                .account(account)
                .group(group)
                .isInvited(true)
                .accountGroupRoleEnum(CREATOR)
                .build();

        groupRepository.save(group);
        accountGroupConnectRepository.save(accountGroupConnect);

        Plan plan = planMapper.planPorJCreateRequestDtoToEntity(planPorJCreateRequest, group);
        planRepository.save(plan);

        PlanPorJCreateResponse planPorJCreateResponse = planMapper.entityToPlanProJResponseDto(plan);


        return StatusResponseDto.builder()
                .statusCode(P_OR_J_SELECT_SUCCESS.getHttpStatus().value())
                .data(planPorJCreateResponse)
                .build();
    }
}
