package friend;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;

// pshhh why serialize an object when you can serialize it yourself :D
public class FriendManager implements Serializable {

    private ObservableList<Friend> friends = FXCollections.observableArrayList();
    private final String save_path = "data/friends.txt";

    public void add_blank_friend(){
        this.friends.add(new Friend());
    }

    public void delete_friend(Friend friend){
        this.friends.remove(friend);
    }

    public ObservableList<Friend> getObservableList(){
        return this.friends;
    }

    // save and load data to file
    // uses "␟" as a parameter separator and " " as a line separator
    public void save_data() {
        try {
            FileWriter fw = new FileWriter(save_path, false);
            BufferedWriter bw = new BufferedWriter(fw);

            for (Friend friend : friends) {
                bw.write(friend.save_values());
                bw.write("\u2028");
                bw.newLine();
            }
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load_data()  {
        File testfile = new File(save_path);
        if (!testfile.exists() || testfile.length() == 0) {
            add_blank_friend();
            return;
        }

        try {
            this.friends.clear();

            FileReader fr = new FileReader(save_path);
            BufferedReader br = new BufferedReader(fr);
            String line;
            String actualline = "";

            // reads lines until it encounters a line separator then it sends the data to a new Friend to parse

            while((line = br.readLine()) != null) {
                actualline += line + "\n"; // absolutely atrocious and i need to learn how to use stringBuilder but it works

                if (actualline.contains("\u2028")) {

                    actualline.replace("\u2028", "");

                    Friend tmp = new Friend();
                    tmp.load_values(actualline);
                    this.friends.add(tmp);

                    actualline = "";
                }
            }
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
