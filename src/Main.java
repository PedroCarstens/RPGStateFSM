//==================================
// Classe principal que executa a simulação
//==================================
public class Main {
    public static void main(String[] args) {

        //======== cria personagem ========
        RPGCharacter guerreiro = new RPGCharacter("Guerreiro");
        //=================================

        //======== executa 15 ciclos ========
        for (int i = 0; i < 15; i++) {
            guerreiro.tick();
        }
        //===================================
    }
}
