package friend;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;


public class FriendManager implements Serializable {
    private ObservableList<Friend> friends = FXCollections.observableArrayList();
    int id = 0;
    private final String save_path = "data/friends.txt";

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

    public ObservableList<Friend> getObservableList(){
        return this.friends;
    }

    public void dump_info() {
        System.out.println("DUMPING FriendManager Info: (id: " + id + ")");
        for (Friend friend : this.friends) {
            System.out.println(friend.getId() + " " + friend.toString());
        }
    }

    public void save_data() {
        try {

            System.out.println("SAVING DATA");

            FileWriter fw = new FileWriter(save_path, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("ohno");
            bw.write("ohn2o");

            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load_data()  {
        try {

            System.out.println("LOADING DATA");

            FileReader fr = new FileReader(save_path);
            BufferedReader br = new BufferedReader(fr);
            System.out.println(br.readLine());

            br.close();



        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
