/*
 * Projeto: Exemplos de implementacao para disciplina 
 * Inteligencia Artificial do curso de SI (IFMA/Monte Castelo)
 *
 * Copyright 2015 by Josenildo Silva <jcsilva@ifma.edu.br>
 */
package interfaces;

import classes.Mapa;

/**
 *
 * @author Josenildo Silva <jcsilva@ifma.edu.br>
 */
public interface TesteDeObjetivo {
    public boolean ehObjetivo(Mapa mapa); //Mapa implementa Interface Estado
}
