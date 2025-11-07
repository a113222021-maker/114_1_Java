// 檔案路徑: c:\Users\m306\Desktop\114_1_Java\114-11-07\Inheritamce01\src\Magician.java
public class Magician {
    private String name;
    private int health;
    private int attackPower;
    private int magicPower;
    private int HealPower;



    public Magician(String name, int health, int magicPower, int AttackPower, int HealPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
        this.magicPower = magicPower;
        this.HealPower = HealPower;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {

        return health;
    }

    public int getattackPower() {

        return attackPower;
    }
    public int getHealPower() {

        return HealPower;
    }
    public void attack(Magician opponent) {
        opponent.health -= this.magicPower;
        System.out.println(this.name + " casts a spell on " + opponent.name + " for " + this.magicPower + " damage.");
    }
    public void heal(Magician ally) {
        ally.health += this.magicPower;
        System.out.println(this.name + " heals " + ally.name + " for " + this.magicPower + " health.");
    }
    public boolean isAlive() {
        return health > 0;
    }


}
