package hello.itemservice.domain.item;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ItemRepositoryTest {

    ItemRepository itemRepository = new ItemRepository();

    @AfterEach
    void after() {
        itemRepository.clearStore();
    }

    @Test
    void save() throws Exception {
        //given
        Item item = new Item("itemA", 10000, 10);
        //when
        Item saveItem = itemRepository.save(item);
        //then
        Item findItem = itemRepository.findById(saveItem.getId());
        assertThat(findItem).isEqualTo(saveItem);
    }

    @Test
    void findAll() throws Exception {
        //given
        Item item1 = new Item("item1", 10000, 10);
        Item item2 = new Item("item2", 20000, 20);
        //when
        itemRepository.save(item1);
        itemRepository.save(item2);
        //then
        List<Item> list = itemRepository.findAll();
        assertThat(list.size()).isEqualTo(2);
        assertThat(list).contains(item1, item2);
    }


    @Test
    void updateItem() throws Exception {
        //given
        Item item = new Item("item1", 10000, 10);
        Item save = itemRepository.save(item);
        Item tempItem = itemRepository.findById(save.getId());

        //when
        Item updateItem= new Item("item2", 20000, 20);
        itemRepository.update(tempItem.getId(), updateItem);

        //then
        Item findItem = itemRepository.findById(tempItem.getId());

        assertThat(findItem.getItemName()).isEqualTo(updateItem.getItemName());
        assertThat(findItem.getPrice()).isEqualTo(updateItem.getPrice());
        assertThat(findItem.getQuantity()).isEqualTo(updateItem.getQuantity());
    }
}