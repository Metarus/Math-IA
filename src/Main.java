import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Main {
    static Player[] players=new Player[8];
    static int k=8;
    public static void main(String[] args) {
        for(int i=0; i<players.length; i++) {
            players[i]=new Player("Player"+i);
        }
        for(int i=0; i<10000; i++) {
            int p1=(int)Math.floor(Math.random()*8);
            int p2=(int)Math.floor(Math.random()*7);
            if(p2>=p1) p2++;
            match(p1, p2);
            for(int j=0; j<players.length; j++) {
                players[j].logRating();
            }
        }
        for(int i=0; i<players.length; i++) {
            System.out.println(players[i].rating);
        }
    }
    public static void match(int p1, int p2) {
        double p=(p1-p2)*0.06+0.5;
//        boolean win=Math.random()<p; //boolean of p1 winning
        double pElo=(1/(1+Math.pow(10, ((players[p2].rating-players[p1].rating)/400))));
//        players[p1].rating+=k*(((win)?1:0)-pElo);
//        players[p2].rating+=k*(((win)?0:1)-(1-pElo));
        players[p1].rating+=k*(p-pElo);
        players[p2].rating+=k*((1-p)-(1-pElo));
    }
    public static void appendToFile(String loc, String data){
        try {
            File file1=new File(loc);
            FileWriter fr=new FileWriter(file1, true);
            BufferedWriter br=new BufferedWriter(fr);
            br.write(data);

            br.close();
            fr.close();
        } catch(Exception e){
            e.printStackTrace();
            System.out.println("Error has occurred");
        }
    }
}
