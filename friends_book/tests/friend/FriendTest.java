package friend;

import friend.Friend;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class FriendTest {
    public Friend bob;
    String content = "Bob the Builder␟1970-01-01␟123-456-7890␟default.png␟big fan of apple pie␟true␟ ";

    @BeforeEach
    void BeforeEach(){
        bob = new Friend();
    }

    @Test
    void load_values() {
        bob.load_values(content);

        assertEquals(bob.getName(), "Bob the Builder");
        assertEquals(bob.getBirthdate(), LocalDate.of(1970, 1, 1));
        assertEquals(bob.getPhone_number(), "123-456-7890");
        assertEquals(bob.getProfile_image(), "default.png");
        assertEquals(bob.getNotes(), "big fan of apple pie");
        assertEquals(bob.getFavorite(), true);

    }

    @Test
    void save_values(){

        bob.load_values(content);

        // what do you meaaan it defeats the purpose of the test if you copy paste output from the test
        String expected = "Bob the Builder␟1970-01-01␟123-456-7890␟default.png␟big fan of apple pie␟true\u2028";

        assertEquals(bob.save_values(), expected);
    }

}