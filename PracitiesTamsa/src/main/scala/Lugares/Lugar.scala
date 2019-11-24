package Lugares

import Campeones._
import Enemigos._

class Lugar() {
    // Atributos
    protected var _name         : String = ""
    protected var _nivel        : Int = 0
    protected var _enemigos     : List[Enemigo] = List()
    protected var _campeones    : List[Campeon] = List()
    
    // Metodos
    // Getters
    def name        = _name
    def nivel       = _nivel
    def enemigos    = _enemigos
    def campeones   = _campeones

    // Setters
    def name_(nName : String) {_name = nName}
    def nivel_(nNivel : Int) {_nivel = nNivel}
    def enemigos_(nEnemigos : List[Enemigo]) {_enemigos = nEnemigos}

    // Funciones
    def entrarCampeon(campeon : Campeon) {
        if (campeon.nivel < _nivel)
            println("El campeon no tiene el nivel necesario para entrar a " + _name)
        else
            _campeones = campeon::_campeones
    }

    def salirCampeon(cId : Int) {
        _campeones = _campeones.filter(_.id != cId)
    }
}