/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import interfaces.Acao;

/**
 *
 * @author Vitor
 */
public class Pintar implements Acao {
    
    private String posicao;
    
    public void moverPintar(Jogador JG, String posicao){
        int novaPosicaoLinha;
        int novaPosicaoColuna;
        posicao = posicao.toLowerCase();
        
        if(posicao.equals("cima")){
            novaPosicaoLinha = JG.getPosicaoAtualLinha();
            novaPosicaoLinha = novaPosicaoLinha - 1;            
            JG.setPosicaoAtualLinha(novaPosicaoLinha);            
        }
        if(posicao.equals("baixo")){
            novaPosicaoLinha = JG.getPosicaoAtualLinha();
            novaPosicaoLinha = novaPosicaoLinha + 1;            
            JG.setPosicaoAtualLinha(novaPosicaoLinha);            
        }
        if(posicao.equals("esquerda")){
            novaPosicaoColuna = JG.getPosicaoAtualColuna();
            novaPosicaoColuna = novaPosicaoColuna - 1;            
            JG.setPosicaoAtualColuna(novaPosicaoColuna);            
        }
        if(posicao.equals("direita")){
            novaPosicaoColuna = JG.getPosicaoAtualColuna();
            novaPosicaoColuna = novaPosicaoColuna + 1;            
            JG.setPosicaoAtualColuna(novaPosicaoColuna);          
        }
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

}
