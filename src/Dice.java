//==================================
// Classe utilitária para rolagem de dados
//==================================
import java.util.Random;

public class Dice {
    private static final Random random = new Random();

    //========= rolagem de D20 =========
    public static int rollD20() {
        return random.nextInt(20) + 1;
    }
    //==================================
    //========= rolagem de D10 =========
    public static int rollD10() {
        return random.nextInt(10) + 1;
    }
    //==================================
    //========= rolagem de D8 =========
    public static int rollD8() {
        return random.nextInt(8) + 1;
    }
    //==================================
    //========= rolagem de D6 =========
    public static int rollD6() {
        return random.nextInt(6) + 1;
    }
    //==================================
}
