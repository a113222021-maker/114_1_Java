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

    // 劍士沒有治療能力，但需實作父類別的抽象方法
    @Override
    public void heal(Role ally) {
        System.out.println(this.getName() + " 無法進行治療。");
    }
}
