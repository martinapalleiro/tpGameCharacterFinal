
package Entities;

import java.util.Random;

public class Enemy extends GameCharacter implements Combatant{
    protected int damage;

    public Enemy(int maxHp, int curHp, int y, int x, char symbol, int damage) {
        super(maxHp, curHp, y, x, symbol);
        this.damage=damage;
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


    public int getDamage() {
        return damage;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getCurHp() {
        return curHp;
    }

    public void setDamage(int damage) {
        this.damage = damage;
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

    @Override
    public int attack() {
        return damage;
    }

    @Override
    public String toString() {
        return "Enemigo";
    }
    
}
