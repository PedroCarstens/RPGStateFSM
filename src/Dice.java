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
}
