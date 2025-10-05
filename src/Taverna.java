//================================================================
// Estado: Taverna - Um lugar para um descanso garantido (se tiver ouro!)
//================================================================
public class Taverna implements Estado {


    @Override
    public void tick(RPGCharacter personagem) {
        System.out.println(personagem.getNome() + " chega aos portões de uma taverna movimentada, com cheiro de comida no ar.");
        Main.sleep(1500); // Pausa dramática

        // Verifica se o personagem tem ouro suficiente para pagar
        if (personagem.getOuro() >= 5) {
            System.out.println("O estalajadeiro sorri. 'Um quarto e uma refeição quente custam " + 5 + " moedas de ouro.'");
            Main.sleep(1000);

            // Realiza a transação e recuperação
            personagem.gastarOuro(5);
            personagem.recuperarFome(15);
            personagem.recuperarSono(15);

            System.out.println(personagem.getNome() + " come, bebe e descansa. As energias foram totalmente restauradas!");
        } else {
            System.out.println("'Sinto muito, amigo', diz o estalajadeiro. 'Sem ouro, sem serviço.'");
            Main.sleep(1000);
            System.out.println(personagem.getNome() + " sai da taverna, ainda cansado e com fome...");
        }

        Main.sleep(1500);
        System.out.println("Com o nascer do sol, é hora de voltar a explorar o mundo.");
        personagem.setEstado(new Exploring()); // Após a taverna, sempre volta a explorar
        System.out.println("-------------------------------------------------");
    }
}