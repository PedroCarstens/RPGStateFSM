//================================================
// Classe ABSTRATA que serve de modelo para todos os personagens
//================================================
public abstract class RPGCharacter {

    //========== Variáveis ==========
    private Estado estadoAtual;
    private String classe;
    private String nome;

    // Novos atributos essenciais
    private int vida;
    private int vidaMaxima;
    private int fome;
    private int sono;
    private int ouro;
    //===============================

    //========== Construtor ==========
    public RPGCharacter(String classe, String nome, int vidaInicial) {
        this.classe = classe;
        this.nome = nome;
        this.vidaMaxima = vidaInicial;
        this.vida = vidaInicial;
        this.fome = 0; // Começa sem fome
        this.sono = 0; // Começa descansado
        this.ouro = 5; // Uma ajudinha inicial
        this.estadoAtual = new Exploring(); 
    }
    //===============================

    //=========== Método Abstrato ===========
    public abstract void attack();
    //=====================================

    //=========== Lógica do "Tick" ===========
    public void tick() {
        // A cada "passo" no tempo, o personagem fica com mais fome e sono.
        this.fome++;
        this.sono++;
        estadoAtual.tick(this); // Delega a ação para o estado atual
    }
    //========================================

    //=========== Método para Exibir Status ===========
    public void displayStatus() {
        String status = String.format("--- STATUS de %s o %s ---\nVida: %d/%d | Fome: %d | Sono: %d | Ouro: %d",
                                      nome, classe, vida, vidaMaxima, fome, sono, ouro);

        status += getAtributosEspecificos();
        
        System.out.println(status);
        System.out.println("-------------------------------------");
    }
    //===============================================

    //=========== Métodos de Gerenciamento ===========
    public void receberDano(int dano) {
        this.vida -= dano;
        if (this.vida < 0) {
            this.vida = 0;
        }
        System.out.println(this.nome + " recebeu " + dano + " de dano! Vida restante: " + this.vida);
    }

    public boolean isVivo() {
        return this.vida > 0;
    }

    public void ganharOuro(int quantidade) {
        this.ouro += quantidade;
        System.out.println(nome + " ganhou " + quantidade + " moedas de ouro!");
    }

    public void gastarOuro(int quantidade) {
        this.ouro -= quantidade;
    }

    public void recuperarFome(int valor) {
        this.fome -= valor;
        if (this.fome < 0) this.fome = 0;
    }

    public void recuperarSono(int valor) {
        this.sono -= valor;
        if (this.sono < 0) this.sono = 0;
    }
    //================================================

    //=========== Ações Específicas dos Personagens ===========
    public void tentarColetar() {
        // Comportamento padrão para qualquer personagem que não seja Mago
        System.out.println(this.getNome() + " não tem habilidade para coletar itens mágicos e volta a explorar.");
        this.setEstado(new Exploring()); // Volta a explorar
    }
    //=====================================================

    //=========== Getters e Setters ==========
    public String getClasse() { return classe; }
    public String getNome() { return nome; }
    public int getVida() { return vida; }
    public int getVidaMaxima() { return vidaMaxima; }
    public int getFome() { return fome; }
    public int getSono() { return sono; }
    public int getOuro() { return ouro; }
    public void setEstado(Estado novoEstado) { this.estadoAtual = novoEstado; }
    //========================================

    public abstract String getAtributosEspecificos();
}