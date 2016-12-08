/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import interfaces.Acao;
import interfaces.Estado;
import interfaces.MapaDeTransicao;
import java.util.HashSet;
import java.util.Set;
import util.MatrixPrinter;

/**
 *
 * @author Vitor
 */
public class Jogador implements MapaDeTransicao {
    
    private double custo = 1;
    private int posicaoInicial;
    private int posicaoAtualPassos;
    
    private int posicaoAtualLinha;
    private int posicaoAtualColuna;
    
    public Set<Pintar> acoes(Mapa MP, String posicao){
        Set<Pintar> movimentosJogadas = new HashSet<Pintar>();
        Pintar pintarMovimento = new Pintar();
        pintarMovimento.setPosicao(posicao);
        movimentosJogadas.add(pintarMovimento);
        return movimentosJogadas;
    }
    public Estado resultado(Acao a, Estado e){
        return e;
    }
    public double custo(Acao a, Estado de, Estado para){
        return this.custo;
    }
    
    public void printPosicaoAtualJogador(Mapa MP, Jogador JG){
       MatrixPrinter.printMatrix(MP.getConfiguracao(), MatrixPrinter.padrao);
       
       System.out.println("O jogador está em:");
       System.out.println("Linha: "+JG.getPosicaoAtualLinha());
       System.out.println("Coluna: "+JG.getPosicaoAtualColuna());        
    }

    public int getPosicaoAtualLinha() {
        return posicaoAtualLinha;
    }

    public void setPosicaoAtualLinha(int posicaoAtualLinha) {
        this.posicaoAtualLinha = posicaoAtualLinha;
    }

    public int getPosicaoAtualColuna() {
        return posicaoAtualColuna;
    }

    public void setPosicaoAtualColuna(int posicaoAtualColuna) {
        this.posicaoAtualColuna = posicaoAtualColuna;
    }

    public int getPosicaoInicial() {
        return posicaoInicial;
    }

    public void setPosicaoInicial(int posicaoInicial) {
        this.posicaoInicial = posicaoInicial;
        setPosicao(posicaoInicial);
    }

    public int getPosicao() {
        return posicaoAtualPassos;
    }

    public void setPosicao(int posicao) {
        this.posicaoAtualPassos = posicao;
    }
    
}
