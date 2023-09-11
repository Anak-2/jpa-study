package jpa.study.member.service;

import jpa.study.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

public interface MemberService {
    Long saveMember(Member member);
}
