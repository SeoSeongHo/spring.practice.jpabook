package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ItemServiceTest {

    @Autowired private ItemRepository itemRepository;
    @Autowired private ItemService itemService;

    @Test
    public void 상품_등록() throws Exception {
        // given
        Book book = new Book();
        book.setAuthor("seo");
        book.setIsbn("2010");

        // when
        Long savedId = itemService.saveItem(book);

        // then
        assertEquals(book, itemRepository.findOne(savedId));
    }
}