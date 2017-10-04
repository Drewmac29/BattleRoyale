/**
 * file: Troll.java
 * created: 4-27-17
 * author: Andrew Gingras
 */

import java.util.ArrayList;
import java.util.Random;

public class Troll {

    public static int seed;
    private ArrayList<Woolie> woolies;
    private SportsComplex sportsComplex;

    /**
     * Troll constructor
     * @param woolies - the list of Woolies that will battle
     * @param sportsComplex - the sports complex the battle will occur in
     */
    public Troll (ArrayList<Woolie> woolies, SportsComplex sportsComplex){
        this.woolies = woolies;
        this.sportsComplex = sportsComplex;
        seed = 1;
    }


    /**
     * Tells the troll to begin the Battle Royale w/
     * the current list of woolies
     */
    public void beginBattleRoyale() throws InterruptedException {
        Random random = new Random();
        random.setSeed(seed);
        int round = 1;
        while (woolies.size() > 1){
            System.out.println("Round " + round + " is about to begin!");
            System.out.println("The contestants for this round are:");
            for (Woolie woolie : woolies){
                System.out.println("        " + woolie);
            }
            System.out.println();
            ArrayList<Woolie> winners = new ArrayList<>();
            ArrayList<WoolieBattleThread> battles = new ArrayList<>();
            while (woolies.size() > 0){
                if (woolies.size() == 1) {
                    Woolie w = woolies.get(0);
                    winners.add(w);
                    woolies.remove(w);
                }
                else {
                    Woolie w1 = woolies.get(random.nextInt(woolies.size()));
                    woolies.remove(w1);
                    Woolie w2 = woolies.get(random.nextInt(woolies.size()));
                    woolies.remove(w2);
                    WoolieBattleThread battleThread = new WoolieBattleThread(w1, w2, this.sportsComplex);
                    battleThread.start();
                    battles.add(battleThread);
                }
            }
            //Wait for all battles to be done
            for (WoolieBattleThread battle : battles)
                battle.join();
            //Add winners to winners list
            for (WoolieBattleThread battle: battles)
                winners.add(battle.getWinner());
            System.out.println("Round " + round + " has ended!");
            System.out.println("The contestants left after this round are:");
            for (Woolie woolie : winners){
                System.out.println("        " + woolie);
                woolies.add(woolie);
            }
            System.out.println();
            round++;
        }
        System.out.println("The winner is " + woolies.get(0).getName());
    }

}
