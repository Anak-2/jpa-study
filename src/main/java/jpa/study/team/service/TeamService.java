package jpa.study.team.service;


import jpa.study.member.domain.Member;
import jpa.study.team.domain.Team;

import java.util.List;

public interface TeamService {

    List<Member> getMembers(Team team);
}
