/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import interfaces.Acao;
import interfaces.Estado;
import interfaces.Problema;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author Vitor
 */
public class Huebrix implements Problema {
    
    private double custo = 1;
    private Mapa mapa;
    private List<String> listaDeMovimentos = new ArrayList<String>();     

    public List<String> getListaDeMovimentos() {
        return listaDeMovimentos;
    }
    
    public Estado resultado(Acao a, Estado e){
        return e;
    }
    public Set<Acao> acoes(Estado e){
        return null;
    }
    
    public boolean testaObjetivo(Mapa MP, Jogador JG){
        Espaco espaco = new Espaco();
        Random randomizer = new Random();
        String direcaoRandomica;
        
        if(MP.contemCaminhos(MP, 0)){
            if(this.listaDeMovimentos.isEmpty()){
                return true;
            }else{
                 direcaoRandomica = this.listaDeMovimentos.get(randomizer.nextInt(this.listaDeMovimentos.size()));
            }
            for (int i = 0; i < MP.getConfiguracao().length; i++) {
                for (int j = 0; j < MP.getConfiguracao()[0].length; j++) {                    
                    if(this.listaDeMovimentos.isEmpty()){
                        return true;
                    }

                    if(jogadaValida(MP, JG, espaco, direcaoRandomica)){
                        return false;  
                    }else{
                        if(this.listaDeMovimentos.isEmpty()){
                            return true;
                        }
                        direcaoRandomica = this.listaDeMovimentos.get(randomizer.nextInt(this.listaDeMovimentos.size()));
                        break;
                    }
                }
            }            
        }
        System.out.println("Sucesso! Jogador venceu o nivel.");
        return true;
    }
    
    public boolean jogadaValida(Mapa mapa, Jogador JG,Espaco espaco, String direcaoRandomica){
        
        switch(direcaoRandomica){
            case "cima":
                if(JG.getPosicaoAtualLinha() >= 0){
                    int posicaoFuturaJogadorLinha = JG.getPosicaoAtualLinha();
                    posicaoFuturaJogadorLinha = posicaoFuturaJogadorLinha - 1;
                    if(posicaoFuturaJogadorLinha < 0){ // se estiver na linha 0
                        this.listaDeMovimentos.remove(direcaoRandomica);
                        break;
                    }   
                    int posicaoFuturaJogadorColuna = JG.getPosicaoAtualColuna();
                    int valorPosicaoFutura = espaco.getValorEspaco(mapa, posicaoFuturaJogadorLinha, posicaoFuturaJogadorColuna);
                    
                    if(valorPosicaoFutura == 0 && valorPosicaoFutura != -1){
                        completaListaDeMovimentos(this.listaDeMovimentos);
                        mapa.movimentarJogador(JG, direcaoRandomica);
                        JG.printPosicaoAtualJogador(mapa, JG);
                        return true;
                    }else{
                        this.listaDeMovimentos.remove(direcaoRandomica);
                        return true;
                    }                    
                } // fim case cima
            case "baixo":
                if(JG.getPosicaoAtualLinha() >= 0){
                    int posicaoFuturaJogadorLinha = JG.getPosicaoAtualLinha();
                    posicaoFuturaJogadorLinha = posicaoFuturaJogadorLinha + 1;
                    if(posicaoFuturaJogadorLinha > mapa.getNumMaxPosicaoLinhas()){
                        this.listaDeMovimentos.remove(direcaoRandomica);
                        break;
                    }
                    int posicaoFuturaJogadorColuna = JG.getPosicaoAtualColuna();
                    int valorPosicaoFutura = espaco.getValorEspaco(mapa, posicaoFuturaJogadorLinha, posicaoFuturaJogadorColuna);
                    
                    if(valorPosicaoFutura == 0 && valorPosicaoFutura != -1){
                        completaListaDeMovimentos(this.listaDeMovimentos);
                        mapa.movimentarJogador(JG, direcaoRandomica);
                        JG.printPosicaoAtualJogador(mapa, JG);
                        return true;
                    }else{
                        this.listaDeMovimentos.remove(direcaoRandomica);
                        return true;
                    }                    
                } // fim case baixo
            case "esquerda":
                if(JG.getPosicaoAtualColuna() >= 0){
                    int posicaoFuturaJogadorLinha = JG.getPosicaoAtualLinha();
                    int posicaoFuturaJogadorColuna = JG.getPosicaoAtualColuna();
                    posicaoFuturaJogadorColuna = posicaoFuturaJogadorColuna - 1;                    
                    if(posicaoFuturaJogadorColuna < 0){ // se estiver na coluna 0
                        this.listaDeMovimentos.remove(direcaoRandomica);
                        break;
                    }                    
                    int valorPosicaoFutura = espaco.getValorEspaco(mapa, posicaoFuturaJogadorLinha, posicaoFuturaJogadorColuna);
                    
                    if(valorPosicaoFutura == 0 && valorPosicaoFutura != -1){
                        completaListaDeMovimentos(this.listaDeMovimentos);
                        mapa.movimentarJogador(JG, direcaoRandomica);
                        JG.printPosicaoAtualJogador(mapa, JG);
                        return true;
                    }else{
                        this.listaDeMovimentos.remove(direcaoRandomica);
                        return true;
                    }                    
                } // fim case esquerda
            case "direita":
                if(JG.getPosicaoAtualColuna() >= 0){
                    int posicaoFuturaJogadorLinha = JG.getPosicaoAtualLinha();
                    int posicaoFuturaJogadorColuna = JG.getPosicaoAtualColuna();
                    posicaoFuturaJogadorColuna = posicaoFuturaJogadorColuna + 1;     
                    if(posicaoFuturaJogadorColuna > mapa.getNumMaxPosicaoColunas()){
                        this.listaDeMovimentos.remove(direcaoRandomica);
                        break;
                    }                    
                    int valorPosicaoFutura = espaco.getValorEspaco(mapa, posicaoFuturaJogadorLinha, posicaoFuturaJogadorColuna);
                    
                    if(valorPosicaoFutura == 0 && valorPosicaoFutura != -1){
                        completaListaDeMovimentos(this.listaDeMovimentos);
                        mapa.movimentarJogador(JG, direcaoRandomica);
                        JG.printPosicaoAtualJogador(mapa, JG);
                        return true;
                    }else{
                        this.listaDeMovimentos.remove(direcaoRandomica);
                        return true;
                    }                    
                } // fim case direita
        }
        return false;
    }

    public void completaListaDeMovimentos(List<String> lista){
        lista.clear();
        lista.add("cima");
        lista.add("baixo");
        lista.add("esquerda");
        lista.add("direita");
    }

    public double custo(Acao a, Estado ei, Estado ej){
        return this.custo;
    }
    
    public Estado estadoInicial(){
        return this.mapa;
    }    
 
}
