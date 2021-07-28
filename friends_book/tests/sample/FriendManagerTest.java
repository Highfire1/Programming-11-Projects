package sample;


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

        assertEquals(friends.getArray().size(), 1);
    }

    @Test
    void get_friend() {
        friends.add_blank_friend();
        Friend tmp = friends.get_friend(0);
        assertEquals(tmp.getName().toString(), "NO_NAME");
    }

    @Test
    void get_missing_friend(){
        Friend tmp = friends.get_friend(999);
        assertNull(tmp);
    }

    @Test
    void add_friend() {
        Friend bob = new Friend();
        Name name = new Name();
        name.setName("bob");
        bob.setName(name);

        friends.add_friend(bob);

        assertEquals(friends.getArray().size(), 1);
    }

    @Test
    void delete_friend() {
        Friend bob = new Friend(123);
        Name name = new Name();
        name.setName("bob");
        bob.setName(name);

        friends.add_friend(bob);

        assertEquals(friends.getArray().size(), 1);

        friends.delete_friend(bob);

        assertEquals(friends.getArray().size(), 0);

    }

    @Test
    void getArray() {

        assertEquals(friends.getArray().size(), 0);

        friends.add_blank_friend();

        assertEquals(friends.getArray().size(), 1);

    }

}