// 檔案路徑: c:\Users\m306\Desktop\114_1_Java\114-11-07\Inheritamce01\src\SwordsMan.java
import javax.swing.plaf.PanelUI;

// 檔案路徑: c:\Users\m306\IdeaProjects\Inheritamce01\src\SwordsMan.java
public class SwordsMan {
    private String name;
    private int health;
    private int attackPower;


    public SwordsMan(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

   public SwordsMan(){
       this.name = "Default SwordsMan";
       this.health = 100;
       this.attackPower = 15;}

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public static  void main(String[] args) {
        SwordsMan swordsMan1 = new SwordsMan("Arthur", 120, 20);
        SwordsMan swordsMan2 = new SwordsMan("Lancelot", 100, 25);

        while (swordsMan1.isAlive() && swordsMan2.isAlive()) {
            swordsMan1.attack(swordsMan2);
            if (swordsMan2.isAlive()) {
                swordsMan2.attack(swordsMan1);
            }
        }

        if (swordsMan1.isAlive()) {
            System.out.println(swordsMan1.getName() + " wins!");
        } else {
            System.out.println(swordsMan2.getName() + " wins!");
        }
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void attack(SwordsMan opponent) {
        opponent.health -= this.attackPower;
        System.out.println(this.name + " attacks " + opponent.name + " for " + this.attackPower + " damage.");
    }

    public boolean isAlive() {
        return health > 0;
    }


}
