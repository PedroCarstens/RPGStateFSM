//==================================
// Classe concreta para o Mago
//==================================
public class Mago extends RPGCharacter {

    // Atributo exclusivo do Mago
    private int ingredientesMagicos;

    //========== Construtor ==========
    public Mago(String nome) {
        // Chama o construtor da classe pai
        super("Mago", nome, 20); 
        this.ingredientesMagicos = 5;
    }
    //===============================

    //========== Implementação do Ataque ==========
    @Override 
    public void attack() {
        System.out.println(this.getNome() + " o Mago conjura e lança uma bola de fogo!");
    }
    //===========================================

    //========== Métodos Específicos do Mago ==========
    public int getIngredientesMagicos() {
        return ingredientesMagicos;
    }

    public void coletarIngredientes(int quantidade) {
        this.ingredientesMagicos += quantidade;
    }
    //===============================================
        @Override
    public String getAtributosEspecificos() {
        // O Mago retorna a string formatada com seus ingredientes.
        return " | Ingredientes: " + this.ingredientesMagicos;
    }
}