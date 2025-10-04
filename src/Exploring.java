//==================================
// Estado: Explorando
//==================================
public class Exploring implements Estado {

    //=========== Atualiza estado ============
    @Override
    public void tick(RPGCharacter personagem) {
        System.out.println(personagem.getClasse() + " está explorando o mundo...");
        int rolagem = Dice.rollD20();
        System.out.println("Rolagem de D20: " + rolagem);

        //====== lógica de transição ======
        if (rolagem <= 8) {
            personagem.setEstado(new Resting());
            System.out.println("Está cansado... vai descansar.");
        } else if (rolagem >= 15) {
            personagem.setEstado(new Fighting());
            System.out.println("Encontrou inimigos! Vai lutar.");
        }
        //==================================

        System.out.println("---------------");
    }
    //=========================================
}
