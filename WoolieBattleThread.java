/**
 * file: WoolieBattleThread.java
 * created: 4-27-17
 * author: Andrew Gingras
 */

public class WoolieBattleThread extends Thread {

    private Woolie fighter1;
    private Woolie fighter2;
    private SportsComplex sportsComplex;
    private Woolie winner;

    /**
     * Constructor for WoolieBattleThread
     * @param fighter1 - a woolie to do battle
     * @param fighter2 - another woolie to do battle
     * @param sportsComplex - the sportsComplex the battles are occuring in
     */
    public WoolieBattleThread(Woolie fighter1, Woolie fighter2, SportsComplex sportsComplex){
        this.fighter1 = fighter1;
        this.fighter2 = fighter2;
        this.sportsComplex = sportsComplex;
    }

    /**
     * Getter for fighter 1
     * @return first fighter
     */
    public Woolie getFighter1(){
        return this.fighter1;
    }

    /**
     * Getter for fighter 2
     * @return second fighter
     */
    public Woolie getFighter2(){
        return this.fighter2;
    }

    /**
     * Starts the battle between the two woolies. Ends the battle once one is KO'd
     */
    public void run(){
        enterArena();
        System.out.println("The battle has begun between " + getFighter1().getName() +
                " and " + getFighter2().getName());
        System.out.println();
        int time = 1;
        while (fighter1.isOK() && fighter2.isOK()){
            if (time % fighter1.getHitTime() == 0){
                int dmg = fighter1.getAttackAmount();
                fighter2.takeDamage(dmg);
                System.out.println(fighter1.getName() + " does " + dmg + " damage to " + fighter2.getName());
                System.out.println(fighter2.getName() + " has " + fighter2.getCurrentHP() + " HP left");
                System.out.println();
                if (!fighter2.isOK()){
                    winner = fighter1;
                    break;
                }
            }
            if (time % fighter2.getHitTime() == 0){
                int dmg = fighter2.getAttackAmount();
                fighter1.takeDamage(dmg);
                System.out.println(fighter2.getName() + " does " + dmg + " damage to " + fighter1.getName());
                System.out.println(fighter1.getName() + " has " + fighter1.getCurrentHP() + " HP left");
                System.out.println();
                if (!fighter1.isOK()){
                    winner = fighter2;
                    break;
                }
            }
            time++;
        }
        System.out.println("The battle is over!");
        System.out.println(getWinner().getName() + " is the winner!");
        System.out.println();
        winner.reset();
        exitArena();
    }

    /**
     * Returns the winner
     * @return winner of battle. null if battle not over
     */
    public Woolie getWinner(){
        return this.winner;
    }

    /**
     * Called when the battle is requesting an arena to do battle in
     * Will request entry to an arena from the sports complex
     */
    public void enterArena(){
        sportsComplex.enterArena(this);
    }

    /**
     * Called when the battle has finished and it is giving up control of the arena
     * It will tell the sports complex it is leaving the arena
     */
    public void exitArena(){
        System.out.println("WOOLIE: " + getWinner().getName() + " leaves arena victorious!");
        sportsComplex.leaveArena();
    }


}
