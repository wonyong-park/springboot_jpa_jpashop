package jpabook.jpashop.repository;

import jpabook.jpashop.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {

    private final EntityManager em;

    /**
     *  상품 저장
     */
    public void save(Item item) {
        if (item.getId() == null) {
            //새로 생성한 객체일 때
            em.persist(item);
        }else {
            //이미 DB에 등록할때
            em.merge(item);
        }
    }

    /**
     * 상품 단건 조회
     */
    public Item findOne(Long id) {
        return em.find(Item.class, id);
    }

    /**
     * 상품 모두 조회
     */
    public List<Item> findAll() {
        return em.createQuery("select i from Item i", Item.class)
                .getResultList();
    }
}
