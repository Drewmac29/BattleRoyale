/**
 * file: SportsComplex.java
 * created: 4-27-17
 * author: Andrew Gingras
 */

public class SportsComplex {

    private int maxInUse;
    private int inUse;

    /**
     * Initializes the sports complex
     */
    public SportsComplex(int maxInUse){
        this.maxInUse = maxInUse;
        this.inUse = 0;
    }

    /**
     * Battle thread attempts to enterArena an arena
     * @param t - the battle thread requesting an arena
     */
    public synchronized void enterArena(WoolieBattleThread t) {
        System.out.println("WOOLIES: " + t.getFighter1().getName() + " and " + t.getFighter2().getName() +
                " enterArena line to battle.");
        while (inUse >= maxInUse) {
            try {
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        inUse++;
        System.out.println("WOOLIES: " + t.getFighter1().getName() + " and " + t.getFighter2().getName() +
                " enterArena arena to battle.");
    }


    /**
     * When a battle is complete the battle will notify the arena that
     * the arena is free
     */
    public synchronized void leaveArena(){
        inUse--;
        notifyAll();
    }

}
