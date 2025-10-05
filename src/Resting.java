//==================================
// Estado: Descansando
//==================================
public class Resting implements Estado {

    @Override
    public void tick(RPGCharacter personagem) {
        System.out.println(personagem.getNome() + " está descansando...");
        personagem.recuperarSono(Dice.rollD20()); 

        int rolagem = Dice.rollD20();
        System.out.println("Rolagem de D20: " + rolagem);

        // A chance de se recuperar aumentou para 65% (13/20 resultados)
        if (rolagem >= 8) {
            personagem.setEstado(new Exploring());
            System.out.println("Recuperado! Vai explorar.");
        } else {
            System.out.println("O descanso ainda não foi suficiente...");
        }
        System.out.println("---------------");
    }
}