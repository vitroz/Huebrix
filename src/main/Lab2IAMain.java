package main;

/**
 *
 * @author Vitor
 */
import classes.Espaco;
import classes.Huebrix;
import classes.Jogador;
import classes.Mapa;
import classes.Pintar;
import classes.WinLose;
import java.util.Arrays;
import java.util.function.Consumer;
import util.MatrixPrinter;

public class Lab2IAMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

    Huebrix game = new Huebrix();
    Mapa mapa = new Mapa();
    Jogador jogador = new Jogador();
    Espaco espaco = new Espaco();
    WinLose resultado = new WinLose();
    
    //Setup Inicial
    // Tamanho do Mapa
    // Posicao Inicial do Jogador
    // Posicao dos Obstaculos no Mapa
    
    mapa.setConfiguracao(4,4); // Quantidade de Espaços no Mapa. - Estado Inicial
    mapa.setPosicaoInicialJogador(3, 0);
    jogador.setPosicaoInicial(mapa.getQtdPassosJogador());
    espaco.colocaJogadorNoMapa(mapa, jogador);
    
    espaco.colocaObstaculoNoMapa(mapa,jogador, 0, 0);
    espaco.colocaObstaculoNoMapa(mapa,jogador, 0, 3);
    espaco.colocaObstaculoNoMapa(mapa,jogador, 2, 1);
    espaco.colocaObstaculoNoMapa(mapa,jogador, 3, 3);

    jogador.printPosicaoAtualJogador(mapa, jogador);    
    game.completaListaDeMovimentos(game.getListaDeMovimentos());  
    // Fim das configurações Iniciais
    
    while(!game.testaObjetivo(mapa,jogador));
    
    resultado.ehObjetivo(mapa); // Testa se a solução foi alcançada.
    
    }
    
}
