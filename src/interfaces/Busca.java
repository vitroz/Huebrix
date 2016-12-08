/*
 * Projeto: Exemplos de implementacao de busca em espaço de estados para 
 * disciplina Inteligencia Artificial do curso de SI (IFMA/Monte Castelo)
 *
 * Copyright 2015 by Josenildo Silva <jcsilva@ifma.edu.br>
 */
package interfaces;

import java.util.List;

/**
 *
 * @author Josenildo Silva <jcsilva@ifma.edu.br>
 */
public interface Busca {

    public List<Acao> buscar(Problema p);
}
