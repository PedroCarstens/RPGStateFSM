//==================================
// Classe principal do personagem RPG
//==================================
public class RPGCharacter {

    //========== variáveis ==========
    private Estado estadoAtual;
    private String classe;
    //===============================

    //========== construtor ==========
    public RPGCharacter(String classe) {
        this.classe = classe;
        this.estadoAtual = new Exploring(); // estado inicial
    }
    //===============================

    //=========== Atualiza estado ============
    public void tick() {
        estadoAtual.tick(this);
    }
    //========================================

    //=========== Getters e Setters ==========
    public String getClasse() { return classe; }

    public void setEstado(Estado novoEstado) {
        this.estadoAtual = novoEstado;
    }
    //========================================
}
