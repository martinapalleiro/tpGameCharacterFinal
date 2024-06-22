
package Entities;


public class Player extends GameCharacter implements Combatant{
     protected String nombre;
     protected Weapon weapon;

    public Player(String nombre, Weapon weapon, int maxHp, int curHp, int y, int x, char symbol) {
        super(maxHp, curHp, y, x, symbol);
        this.nombre = nombre;
        this.weapon = weapon;
    }

    public String getNombre() {
        return nombre;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getCurHp() {
        return curHp;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public void setCurHp(int curHp) {
        this.curHp = curHp;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setSymbol(char Symbol) {
        this.Symbol = Symbol;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public char getSymbol() {
        return Symbol;
    }

    @Override
    public int attack() {
     return weapon.getDemage();
    }

    @Override
    public String toString() {
        return "Player;" + nombre;
    }

    
}
