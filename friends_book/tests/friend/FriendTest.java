package friend;

import friend.Friend;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FriendTest {
    @Test
    void create_friend() {
        Friend whee = new Friend();
        whee.setId(123456);
        assertEquals(whee.getId(), 123456);
    }

}