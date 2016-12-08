/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import interfaces.Estado;
import interfaces.TesteDeObjetivo;

/**
 *
 * @author Vitor
 */
public class WinLose implements TesteDeObjetivo {  
    public boolean ehObjetivo(Mapa mapa){ //Mapa implementa Interface Estado
        if(!mapa.contemCaminhos(mapa, 0)){
            System.out.println("Objetivo concluido!");
            return true;
        }else{
            System.out.println("Objetivo Fracassou");
            return false;
        }
    }
}
