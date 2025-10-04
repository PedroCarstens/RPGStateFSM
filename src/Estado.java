//==================================
// Interface base para os estados
//==================================
public interface Estado {
    //========= método de atualização =========
    void tick(RPGCharacter personagem);
    //=========================================
}
