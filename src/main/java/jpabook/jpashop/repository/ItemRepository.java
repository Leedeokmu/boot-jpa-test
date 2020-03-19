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
     * 상품 등록 / 업데이트
     * @param item
     */
    public void save(Item item){
        em.persist(item);
    }

    /**
     * 특정 상품 조회
     * @param id
     * @return
     */
    public Item findOne(Long id){
        return em.find(Item.class, id);
    }

    /**
     * 상품 전체 조회
     * @return
     */
    public List<Item> findAll(){
        return em.createQuery("select i from Item i", Item.class)
                .getResultList();
    }


}
