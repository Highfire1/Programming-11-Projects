package friend;


import java.io.Serializable;
import java.util.ArrayList;


public class FriendManager implements Serializable {
    private ArrayList<Friend> friends = new ArrayList<Friend>();
    int id = 0;

    public void add_blank_friend(){
        this.friends.add(new Friend(id));
        this.id++;
    }

    public void add_friend(Friend friend){
        friend.setId(this.id);
        this.friends.add(friend);
        this.id++;
    }

    public Friend get_friend(int id){
        for (Friend friend : this.friends) {
            if (friend.getId() == id) {
                return friend;
            }
        }
        return null;
    }



    public void delete_friend(Friend friend){
        this.friends.remove(friend);
    }

    public ArrayList<Friend> getArray(){
        return this.friends;
    }

    public void dump_info() {
        System.out.println("DUMPING FriendManager Info: (id: " + id + ")");
        for (Friend friend : this.friends) {
            System.out.println(friend.getId() + " " + friend.toString());
        }
    }

}
