//package jpa.study.global;
//
//import jakarta.annotation.PostConstruct;
//import jakarta.persistence.EntityManager;
//import jpa.study.JpaStudyApplication;
//import jpa.study.member.domain.Member;
//import jpa.study.team.domain.Team;
//import lombok.RequiredArgsConstructor;
//import org.springframework.boot.context.event.ApplicationReadyEvent;
//import org.springframework.context.event.EventListener;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.crypto.MacSpi;
//
//@Deprecated
//@Component
//@Transactional
//@RequiredArgsConstructor
//public class InitDb {
//
//    private final EntityManager em;
//
//    @Transactional
////    @EventListener(ApplicationReadyEvent.class)
//    public void insert(){
//        Team team = Team.builder().build();
//        team.setName("teamA");
//        em.persist(team);
//
//        Member member = new Member();
//        member.setName("memberA");
//        member.setTeam(team);
//        em.persist(member);
//
//        em.flush();
//
//        System.out.println(em.find(Team.class, member.getTeam().getId()));
//
//    }
//}
