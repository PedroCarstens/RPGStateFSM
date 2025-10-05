//================================================================
// Estado: Combate - batalha por turnos
//================================================================
public class Fighting implements Estado {

    //=========== Atualiza estado ============

    @Override
    public void tick(RPGCharacter personagem) {
        //====== setup ======
        int vidaInimigo = Dice.rollD10() + 10; // Define a vida do inimigo
        System.out.println(personagem.getNome() + " encontra um Inimigo com " + vidaInimigo + " de vida e o combate começa!");
        Main.sleep(1500);

        //====== Loop de batalha ======

        // O loop continua enquanto ambos estiverem vivos.
        while (personagem.isVivo() && vidaInimigo > 0) {

            // -- Turno do Personagem --
            System.out.println("\n--- Turno de " + personagem.getNome() + " ---");
            personagem.attack(); // Mostra a mensagem de ataque da classe (Guerreiro/Mago)
            int rolagemAtaque = Dice.rollD20();
            System.out.println(personagem.getNome() + " rola um " + rolagemAtaque + " para atacar...");
            Main.sleep(1000);

            if (rolagemAtaque >= 10) { // Precisa de 10 ou mais para acertar
                int danoCausado = (personagem instanceof Guerreiro) ? Dice.rollD8() : Dice.rollD10(); // Guerreiro D8, Mago D10
                vidaInimigo -= danoCausado;
                if (vidaInimigo < 0) vidaInimigo = 0;
                System.out.println("ACERTOU! Causou " + danoCausado + " de dano. Vida do inimigo: " + vidaInimigo);
            } else {
                System.out.println("ERROU o ataque!");
            }
            Main.sleep(1500);

            if (vidaInimigo <= 0) break; // Se o inimigo foi derrotado, sai do loop

            // -- Turno do Inimigo --
            System.out.println("\n--- Turno do Inimigo ---");
            rolagemAtaque = Dice.rollD20();
            System.out.println("O Inimigo rola um " + rolagemAtaque + " para atacar...");
            Main.sleep(1000);

            if (rolagemAtaque >= 12) { // Inimigo precisa de 12
                int danoSofrido = Dice.rollD6();
                System.out.println("O Inimigo ACERTOU!");
                personagem.receberDano(danoSofrido);
            } else {
                System.out.println("O Inimigo ERROU o ataque!");
            }
            Main.sleep(1500);
        }

        // ====== Resultado ======
        System.out.println("\n--- Fim do Combate ---");
        if (personagem.isVivo()) {
            System.out.println(personagem.getNome() + " venceu a batalha!");
            int ouroGanho = Dice.rollD10();
            personagem.ganharOuro(ouroGanho);

            // Transição de estado baseada na vida
            if (personagem.getVida() < personagem.getVidaMaxima() / 2) { // Se tiver menos da metade da vida
                 System.out.println("Ferido após a luta, " + personagem.getNome() + " precisa descansar.");
                 personagem.setEstado(new Resting());
            } else {
                 System.out.println("Vitória! " + personagem.getNome() + " continua sua jornada.");
                 personagem.setEstado(new Exploring());
            }
        } else {
            System.out.println(personagem.getNome() + " foi derrotado em combate...");
        }
        System.out.println("-------------------------------------------------");
    }
}