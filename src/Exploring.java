//==================================
// Estado: Explorando
//==================================
public class Exploring implements Estado {

    @Override
    public void tick(RPGCharacter personagem) {
        System.out.println(personagem.getNome() + " está explorando o mundo...");
        Main.sleep(1000);

        //Verifica se o personagem está com muito sono antes de qualquer outra coisa
        if (personagem.getSono() >= 10) {
            System.out.println(personagem.getNome() + " está exausto e decide procurar uma taverna para descansar.");
            personagem.setEstado(new Taverna());
            return; // Encerra a execução deste tick, pois a ação já foi decidida
        }

        int rolagem = Dice.rollD20();
        System.out.println("Rolagem de D20: " + rolagem);

        if (rolagem <= 5) {
            System.out.println("Está cansado... vai descansar um pouco.");
            personagem.setEstado(new Resting());
        } else if (rolagem >= 16) {
        System.out.println("Encontrou inimigos! Vai lutar.");

        Estado novoEstado = new Fighting(); // Cria o novo estado
        personagem.setEstado(novoEstado);   // Define o novo estado
        novoEstado.tick(personagem);        // Executa a lógica do novo estado IMEDIATAMENTE
        } else if (personagem instanceof Mago && rolagem >= 12) {
            System.out.println(personagem.getNome() + " encontrou um local com ervas raras!");
            personagem.setEstado(new ColetandoIngredientes());
        } else {
             System.out.println("A exploração continua tranquila.");
        }
        System.out.println("---------------");
        } 
    }
