package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    //회원 저장
    public void save(Member member) {
        //persist(insert)
        em.persist(member);
    }

    //회원 조회 -> 1명
    public Member findOne(Long id){
        //find(select : 단건조회)
        return em.find(Member.class, id);
    }

    //회원 조회 -> 전부
    public List<Member> findAll() {
        //JPQL -> from의 대상이 테이블이 아닌 엔티티 . 반환 타입
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    //회원 조회(name)으로 조회
    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }

}
