//==================================
// Estado: Descansando
//==================================
public class Resting implements Estado {

    //=========== Atualiza estado ============
    @Override
    public void tick(RPGCharacter personagem) {
        System.out.println(personagem.getClasse() + " está descansando...");
        int rolagem = Dice.rollD20();
        System.out.println("Rolagem de D20: " + rolagem);

        //====== lógica de transição ======
        if (rolagem >= 10) {
            personagem.setEstado(new Exploring());
            System.out.println("Recuperado! Vai explorar.");
        }
        //==================================

        System.out.println("---------------");
    }
    //=========================================
}
