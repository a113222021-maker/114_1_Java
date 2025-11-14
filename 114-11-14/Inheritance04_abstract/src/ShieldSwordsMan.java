public class ShieldSwordsMan extends SwordsMan{
    private int defenseCapacity;
    public ShieldSwordsMan(String name, int health, int attackPower, int defenseCapacity) {
        super(name, health, attackPower);

    }
    @Override
    public void attack(Role opponent) {
        int reducedDamage = this.getAttackPower() - 5; // 減少5點傷害
        opponent.setHealth(opponent.getHealth() - reducedDamage);
        System.out.println(this.getName() + " 使用盾牌攻擊 " + opponent.getName() + " 造成 " +
                reducedDamage + " 點傷害。" + opponent);
    }
    public  int getDefenseCapacity() {
        return defenseCapacity;
    }
    public void defence() {
        System.out.println(this.getName() + " 使用盾牌進行防禦，提高防禦力 " + defenseCapacity + " 點。"+ this);
    }
}
