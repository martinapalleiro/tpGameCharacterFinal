
package Entities;

public class GameCharacter {
   protected int maxHp;
   protected int curHp;
   protected int y;
   protected int x;
   protected char Symbol;

    public GameCharacter(int maxHp, int curHp, int y, int x, char symbol) {
        this.maxHp = maxHp;
        this.curHp = curHp;
        this.y = y;
        this.x = x;
        this.Symbol=symbol;
    }

    public GameCharacter() {
    }

   

    public char getSymbol() {
        return Symbol;
    }

    public void setSymbol(char Symbol) {
        this.Symbol = Symbol;
    }
         
    public int getMaxHp() {
        return maxHp;
    }

    public int getCurHp() {
        return curHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public void setCurHp(int curHp) {
        this.curHp = curHp;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }
    public void reduceHealth(int damage) {
        curHp -= damage;
        if (curHp < 0) {
            curHp = 0;
        }
    }
   

}
