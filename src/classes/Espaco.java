/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import interfaces.Acao;
import interfaces.Busca;
import interfaces.Problema;
import java.util.List;

/**
 *
 * @author Vitor
 */
public class Espaco implements Busca {
    
    public List<Acao> buscar(Problema p){
        return null;
    }
    
    public void colocaJogadorNoMapa(Mapa MP, Jogador JG){ 
        for (int i = 0; i < MP.getConfiguracao().length; i++) {
            for (int j = 0; j < MP.getConfiguracao()[0].length; j++) {
                if(MP.getConfiguracao()[i][j] == JG.getPosicao()){
                    JG.setPosicaoAtualLinha(i);
                    JG.setPosicaoAtualColuna(j);
                }
            }
        }        
    }
 
    public void decrementaPassosJogadorNoMapa(Mapa MP, Jogador JG, int novaQtdPassos){ 
        int valorDoEspacoNoMapa;
        for (int i = 0; i < MP.getConfiguracao().length; i++) {
            for (int j = 0; j < MP.getConfiguracao()[0].length; j++) {
                valorDoEspacoNoMapa = MP.getConfiguracao()[i][j];
                if(valorDoEspacoNoMapa == JG.getPosicaoInicial()){
                    MP.getConfiguracao()[i][j] = novaQtdPassos;
                    JG.setPosicaoInicial(novaQtdPassos);
                }
            }
        }        
    }
    
    public boolean colocaObstaculoNoMapa(Mapa MP,Jogador JG,int numLinha, int numColuna){ 
        if(MP.getConfiguracao()[numLinha][numColuna] == 0){
            MP.getConfiguracao()[numLinha][numColuna] = -1;
            
            int novaQtdPassosJogador = getValorEspaco(MP,JG.getPosicaoAtualLinha(), JG.getPosicaoAtualColuna()) - 1;
            JG.setPosicao(novaQtdPassosJogador);
            decrementaPassosJogadorNoMapa(MP, JG, novaQtdPassosJogador);
            
            return true;
        }
        System.out.println("Jogador localizado nesta posição");
        return false;
    }
    
    public int getValorEspaco(Mapa mapa,int linha,int coluna){
        int valorEspaco;
        valorEspaco = mapa.getConfiguracao()[linha][coluna];
        return valorEspaco;
    }
    
}
