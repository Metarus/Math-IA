import java.io.File;

public class Player {
    String name;
    double rating=1400;
    Player(String _name) {
        name=_name;
    }
    public void logRating() {
        Main.appendToFile("data"+ File.separator+name, rating+"\n");
    }
}
