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

    public void clear(){
        this.friends.clear();
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
            FileWriter fw = new FileWriter(save_path, false);
            BufferedWriter bw = new BufferedWriter(fw);

            for (Friend friend : friends) {
                bw.write(friend.save_values());
                bw.newLine();
            }
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load_data()  {
        if (!new File(save_path).exists()) {
            return;
        }

        try {
            FileReader fr = new FileReader(save_path);
            BufferedReader br = new BufferedReader(fr);
            String line;

            clear();

            while((line = br.readLine()) != null) {

                Friend tmp = new Friend();
                tmp.load_values(line);
                this.friends.add(tmp);
            }
            br.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
