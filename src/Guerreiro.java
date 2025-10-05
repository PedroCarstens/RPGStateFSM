//==================================
// Classe concreta para o Guerreiro
//==================================
public class Guerreiro extends RPGCharacter {

    //========== Construtor ==========
    public Guerreiro(String nome) {
        // Chama o construtor da classe pai 
        super("Guerreiro", nome, 30);
    }
    //===============================

    //========== Implementação do Ataque ==========
    @Override
    public void attack() {
        System.out.println(this.getNome() + " o Guerreiro avança e ataca com sua espada!");
    }

        @Override
    public String getAtributosEspecificos() {
        //sem atributos extras, retorna vazio. (talvez adicione algo?)
        return "";
    //===========================================
}
    }