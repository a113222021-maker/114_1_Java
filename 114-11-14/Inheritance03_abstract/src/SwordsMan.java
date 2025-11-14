public class SwordsMan extends Role{
    // 建構子：初始化劍士的名稱、生命值和攻擊力
    public SwordsMan(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    // 攻擊對手(劍客/魔法師)，重寫父類別的方法
    @Override
    public void attack(Role opponent) {
        opponent.setHealth(opponent.getHealth() - this.getAttackPower());
        System.out.println(this.getName() + " 攻擊 " + opponent.getName() + " 造成 " +
                this.getAttackPower() + " 點傷害。" + opponent);
    }
    public void heal(Role target) {

        int healAmount = 10; // 固定治療量
        target.setHealth(target.getHealth() + healAmount);
        System.out.println(this.getName() + " 回復 " + target.getName()+ " " + healAmount + " 點生命值。" );
    }
}
