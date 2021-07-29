package friend;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


class FriendManagerTest {
    public FriendManager friends;

    @BeforeEach
    void beforeEach() {
        friends = new FriendManager();
    }

    @Test
    void add_blank_friend() {

        friends.add_blank_friend();

        assertEquals(friends.getObservableList().size(), 1);
    }

    @Test
    void get_friend() {
        friends.add_blank_friend();
        assertEquals(friends.getObservableList().get(0).getName(), "BLANK_NAME");
    }

    @Test
    void delete_friend() {
        friends.add_blank_friend();

        assertEquals(friends.getObservableList().size(), 1);

        Friend bye = friends.getObservableList().get(0);

        friends.delete_friend(bye);

        assertEquals(friends.getObservableList().size(), 0);

    }

    @Test
    void getArray() {

        assertEquals(friends.getObservableList().size(), 0);

        friends.add_blank_friend();

        assertEquals(friends.getObservableList().size(), 1);

    }

}