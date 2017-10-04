/**
 * file: Woolie.java
 * created: 4-27-17
 * author: Andrew Gingras
 */

public class Woolie {

    private String name;
    private int minAtk;
    private int maxAtk;
    private int hitTime;
    private int maxHP;
    private int currHP;

    /**
     * Constructor for a woolie object
     * @param name - name of a Woolie
     * @param minAtk - minimum attack of the Woolie
     * @param maxAtk - maximum attack of the Woolie
     * @param hitTime - time between hits of the Woolie
     * @param maxHP - max hit points of the Woolie
     */
    public Woolie(String name, int minAtk, int maxAtk, int hitTime, int maxHP){
        this.name = name;
        this.minAtk = minAtk;
        this.maxAtk = maxAtk;
        this.hitTime = hitTime;
        this.maxHP = maxHP;
        this.currHP = maxHP;
    }

    /**
     * Use an array of strings to make a woolie
     * @param params - order of params
     */
    public Woolie(String[] params){
        this.name = params[0];
        this.minAtk = Integer.parseInt(params[1]);
        this.maxAtk = Integer.parseInt(params[2]);
        this.hitTime = Integer.parseInt(params[3]);
        this.maxHP = Integer.parseInt(params[4]);
        this.currHP = maxHP;
    }

    /**
     * Getter for the name
     * @return woolie name
     */
    public String getName(){
        return this.name;
    }

    /**
     * Getter for the current HP
     * @return hitpoints for woolie
     */
    public int getCurrentHP(){
        return this.currHP;
    }

    /**
     * Gets a random attack between woolies min/max attacks
     * @return random attack value
     */
    public int getAttackAmount(){
        return minAtk + (int)(Math.random() * ((maxAtk - minAtk) + 1));
    }

    /**
     * Subtracts the amount of damage from currHP
     * @param damage - amount of damage done
     */
    public void takeDamage(int damage){
        this.currHP = this.currHP - damage;
    }

    /**
     * Is the woolie alright?
     * @return true if HP above zero, false otherwise
     */
    public boolean isOK(){
        return currHP > 0;
    }

    /**
     * Get Woolie's time between hits
     * @return Woolie's time between hits
     */
    public int getHitTime(){
        return hitTime;
    }

    /**
     * Reset the woolie's state
     */
    public void reset(){
        this.currHP = this.maxHP;
    }

    /**
     * toString to represent a woolie
     * @return string representation of a woolie
     */
    @Override
    public String toString() {
        return getName() + ": Max HP " + this.maxHP + ", Min Attack " + this.minAtk + ", Max Attack " +
                this.maxAtk + ", Hit Time " + getHitTime();
    }


}
