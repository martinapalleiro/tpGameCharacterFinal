
package Entities;

public class Weapon {
    protected String Name;
    protected int minDmg;
    protected int maxDmg;

    public Weapon(String Name, int minDmg, int maxDmg) {
        this.Name = Name;
        this.minDmg = minDmg;
        this.maxDmg = maxDmg;
    }

    public String getName() {
        return Name;
    }

    public int getMinDmg() {
        return minDmg;
    }

    public int getMaxDmg() {
        return maxDmg;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setMinDmg(int minDmg) {
        this.minDmg = minDmg;
    }

    public void setMaxDmg(int maxDmg) {
        this.maxDmg = maxDmg;
    }
    public int getDemage(){
         return (int) (Math.random() * (maxDmg - minDmg + 1)) + minDmg;
    }

    @Override
    public String toString() {
        return "Tu arma es una "+Name+" tiene un rango de dano entre "+minDmg+" y "+maxDmg;
    }
    
}
