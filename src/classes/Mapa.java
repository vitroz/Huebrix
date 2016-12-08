package classes;

import interfaces.Estado;
import java.util.Arrays;

/**
 *
 * @author Vitor
 */
public class Mapa implements Estado {
    
    private Mapa mapa;
    private int[][] configuracao;
    private int qtdPassosJogador;
    private int numMaxPosicaoLinhas;
    private int numMaxPosicaoColunas;

    public int getNumMaxPosicaoLinhas() {
        return numMaxPosicaoLinhas;
    }

    public void setNumMaxPosicaoLinhas(int numMaxPosicaoLinhas) {
        this.numMaxPosicaoLinhas = numMaxPosicaoLinhas;
    }

    public int getNumMaxPosicaoColunas() {
        return numMaxPosicaoColunas;
    }

    public void setNumMaxPosicaoColunas(int numMaxPosicaoColunas) {
        this.numMaxPosicaoColunas = numMaxPosicaoColunas;
    }   
  
    public boolean estadoValido(){
        if(!contemCaminhos(mapa, qtdPassosJogador)){
            return false;
        }
        return true;
    }
    public boolean igual(Mapa MP){
        return this.getMapa().getConfiguracao().equals(MP.getConfiguracao());
    }

    public Mapa getMapa() {
        return mapa;
    }

    public void setMapa(Mapa mapa) {
        this.mapa = mapa;
    }
   
    public int[][] getConfiguracao() {
        return configuracao;
    }

    public void setConfiguracao(int numLinhas, int numColunas) {
        this.configuracao = new int[numLinhas][numColunas];
        int numMaxPosLinhas = numLinhas - 1;
        int numMaxPosColunas = numColunas - 1;
        setNumMaxPosicaoLinhas(numMaxPosLinhas);
        setNumMaxPosicaoColunas(numMaxPosColunas);
    }
    
    public void setPosicaoInicialJogador(int numLinha, int numColuna) {
        int numeroDeEspacosNoMapa = this.configuracao.length * this.configuracao[0].length;
        
        this.configuracao[numLinha][numColuna] = numeroDeEspacosNoMapa;
        setQtdPassosJogador(numeroDeEspacosNoMapa);
    }
    
    public void movimentarJogador(Jogador JG,String posicao) {
        JG.getPosicaoAtualLinha();
        JG.getPosicaoAtualColuna(); 
        
        Pintar pintar = new Pintar();
        pintar.moverPintar(JG, posicao);
        
        int novaQtdPassosJogador;
        novaQtdPassosJogador = JG.getPosicao();
        novaQtdPassosJogador = novaQtdPassosJogador - 1;        
        setQtdPassosJogador(novaQtdPassosJogador);
        JG.setPosicao(novaQtdPassosJogador);
        
        this.configuracao[JG.getPosicaoAtualLinha()][JG.getPosicaoAtualColuna()] =  getQtdPassosJogador();
    }
    
    public  boolean contemCaminhos(Mapa MP, int targetValue) {
            for (int i = 0; i < MP.getConfiguracao().length; i++) {
                for (int j = 0; j < MP.getConfiguracao()[0].length; j++) { 
                     if(MP.getConfiguracao()[i][j] == 0){
                         return true;
                     }
                }
            }
            return false;
    }
    
    public int getQtdPassosJogador(){
        return qtdPassosJogador;
    }
    
    public void setQtdPassosJogador(int qtd) {
        this.qtdPassosJogador = qtd;
    }
    
}
