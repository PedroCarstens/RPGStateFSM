//==================================
// Estado: Combatendo
//==================================
public class Fighting implements Estado {

    //=========== Atualiza estado ============
    @Override
    public void tick(RPGCharacter personagem) {
        System.out.println(personagem.getClasse() + " está em combate!");
        int rolagem = Dice.rollD20();
        System.out.println("Rolagem de D20: " + rolagem);

        //====== lógica de transição ======
        if (rolagem <= 8) {
            personagem.setEstado(new Resting());
            System.out.println("Ficou exausto após a luta... vai descansar.");
        } else if (rolagem <= 14) {
            personagem.setEstado(new Exploring());
            System.out.println("A luta acabou. Hora de explorar.");
        }
        //==================================

        System.out.println("---------------");
    }
    //=========================================
}
