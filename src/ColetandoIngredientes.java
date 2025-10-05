//==================================
// Estado: Coletando Ingredientes (Mago)
//==================================
public class ColetandoIngredientes implements Estado {
    @Override
    public void tick(RPGCharacter personagem) {
        // Verifica se o personagem é realmente um Mago
        if (personagem instanceof Mago) {
            System.out.println(personagem.getNome() + " está coletando iMngredientes mágicos...");
            Main.sleep(1000);

            int quantidade = Dice.rollD6();
            // Acessa o método específico do Mago para adicionar ingredientes
            ((Mago) personagem).coletarIngredientes(quantidade);
            System.out.println("Coletou " + quantidade + " ingredientes!");

            personagem.recuperarFome(2); // Coletar também alimenta um pouco
        } else {
            // failsafe
            System.out.println(personagem.getNome() + " não sabe o que fazer com essas ervas e volta a explorar.");
        }

        personagem.setEstado(new Exploring()); // Sempre volta a explorar depois
        System.out.println("---------------");
    }
}