import java.util.ArrayList;
import java.util.List;

//================================================================
// Classe principal que executa a simulação
//stateMachine
//================================================================
public class Main {

    // Método para pausar a execução
    public static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {

        ////=============== Setup dos personagens ====================
        List<RPGCharacter> aventureiros = new ArrayList<>();
        aventureiros.add(new Guerreiro("Pedro"));
        aventureiros.add(new Mago("Bob"));

        System.out.println("=========================================");
        System.out.println("UMA NOVA AVENTURA COMEÇA!");
        System.out.println(aventureiros.get(0).getNome() + " o Guerreiro e " + aventureiros.get(1).getNome() + " o Mago partem em sua jornada.");
        System.out.println("=========================================");
        sleep(2500);

        //=============== Loop inicial de 20 dias ====================
        int diasDeAventura = 20;
        for (int dia = 1; dia <= diasDeAventura; dia++) {
            System.out.println("\n\n=============== DIA " + dia + " ===============");
            sleep(2000);

            //===============  Loop dos turnos =============== 
            for (RPGCharacter personagem : aventureiros) {
                // A ação só ocorre se o personagem estiver vivo
                if (personagem.isVivo()) {
                    personagem.displayStatus(); // Mostra o status atual
                    sleep(1500);
                    personagem.tick(); 
                    sleep(2000); 
                } else {
                    // Mensagem para personagens que foram derrotados
                    System.out.println(personagem.getNome() + " o " + personagem.getClasse() + " foi derrotado e não pode mais agir.");
                    sleep(1000);
                }
            }
        }
        
        System.out.println("\n\n=========================================");
        System.out.println("A JORNADA CHEGOU AO FIM!");
        System.out.println("=========================================");
        System.out.println("\n--- RESULTADO FINAL DOS AVENTUREIROS ---");
        for (RPGCharacter personagem : aventureiros) {
            personagem.displayStatus();
        }
    }
}