package Lugares

import Campeones._
import Enemigos._

class Lugar() extends Serializable{
    // Atributos
    protected var _name         : String = ""
    protected var _nivel        : Int = 0
        
    // Metodos
    // Getters
    def name        = _name
    def nivel       = _nivel

    // Setters
    def name_(nName : String) {_name = nName}
    def nivel_(nNivel : Int) {_nivel = nNivel}
}