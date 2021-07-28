package sample;

import java.io.Serializable;
import java.util.ArrayList;


public class FriendManager implements Serializable {
    private ArrayList<Friend> friends = new ArrayList<Friend>();
    int id = 0;

    public void add_blank_friend(){
        friends.add(new Friend(id));
        id++;
    }

    public Friend get_friend(int id){
        for (Friend friend : friends) {
            if (friend.getId() == id) {
                return friend;
            }
        }
        return null;
    }

    public void add_friend(Friend friend){
        friends.add(friend);
    }

    public void delete_friend(Friend friend){
        friends.remove(friend);
    }

    public ArrayList<Friend> getArray(){
        return this.friends;
    }

    public void dump_info() {
        System.out.println("DUMPING FriendManager Info:");
        System.out.println("id: " + id);
        for (Friend friend : friends) {
            System.out.println(friend.toString());
        }
    }

}
