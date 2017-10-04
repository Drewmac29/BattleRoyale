/**
 * file: WoolieBattleRoyale.java
 * created: 4-27-17
 * author: Andrew Gingras
 */

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class WoolieBattleRoyale {

    //No Constructor
    public WoolieBattleRoyale(){}

    /**
     * Main function to simulate a Battle Royale
     * @param args - not used
     */
    public static void main(String[] args) throws java.io.FileNotFoundException, InterruptedException {
        Scanner scanner = new Scanner(new File(args[0]));
        SportsComplex sportsComplex = new SportsComplex(Integer.parseInt(scanner.nextLine()));
        ArrayList<Woolie> woolies = new ArrayList<>();
        while (scanner.hasNextLine()){
            String[] params = scanner.nextLine().split(",");
            Woolie woolie = new Woolie(params);
            woolies.add(woolie);
        }
        Troll troll = new Troll(woolies, sportsComplex);
        troll.beginBattleRoyale();
    }
}
