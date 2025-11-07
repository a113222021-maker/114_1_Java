public class RPG {
    public static  void main(String[] args) {
        SwordsMan swordsMan1 = new SwordsMan("Arthur", 120, 20);
        SwordsMan swordsMan2 = new SwordsMan("Lancelot", 100, 25);


        while (swordsMan1.isAlive() && swordsMan2.isAlive()) {
            swordsMan1.attack(swordsMan2);
            if (swordsMan2.isAlive()) {
                swordsMan2.attack(swordsMan1);
            }
        }
    }

}
