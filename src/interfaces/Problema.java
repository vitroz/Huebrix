/*
 * Projeto: Exemplos de implementacao para disciplina 
 * Inteligencia Artificial do curso de SI (IFMA/Monte Castelo)
 *
 * Copyright 2015 by Josenildo Silva <jcsilva@ifma.edu.br>
 */

package interfaces;

import classes.Jogador;
import classes.Mapa;
import java.util.Set;

/**
 * Representa uma instancia de um problema formal.
 * @author Josenildo Silva <jcsilva@ifma.edu.br>
 */
public interface Problema {
    public Estado resultado(Acao a, Estado e);
    public Set<Acao> acoes(Estado e);
    public boolean testaObjetivo(Mapa MP, Jogador JG);

    /**
     * Informa o custo da ação a quando em um estado ei indo para estado ej.
     * @param a ação 
     * @param ei estado onde a acao foi aplicada
     * @param ej estado resultante da aplicação da acao
     * @return custo da aplicação da ação no estado ei
     */
    public double custo(Acao a, Estado ei, Estado ej);
    
    public Estado estadoInicial();
}
