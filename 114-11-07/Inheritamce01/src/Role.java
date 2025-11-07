// 檔案路徑: c:\Users\m306\Desktop\114_1_Java\114-11-07\Inheritamce01\src\Role.java
public class Role {
    private String name;
    private int health;
    private int attackPower;
    public Role(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }
    public String getName() {
        return name;
    }
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public int getAttackPower() {
        return attackPower;
    }
    public void attack(Role opponent) {
        opponent.health -= this.attackPower;
        System.out.println(this.name + " attacks " + opponent.name + " for " + this.attackPower + " damage.");
    }
    public boolean isAlive() {
        return health > 0;
    }
// 檢視角色狀態
    public void displayStatus() {
        System.out.println("Name: " + name + ", Health: " + health + ", Attack Power: " + attackPower);
    }
}
