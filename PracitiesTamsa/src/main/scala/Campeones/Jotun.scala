package Campeones

import Items._

class Jotun() extends Campeon{
 
    def cloning() : Campeon ={
        var temp : Jotun = new Jotun()
        temp.raza_(this._raza)
        temp.nivel_(this._nivel)
        temp.atributos_(this._atributos)
        temp.resistencias_(this._resistencias)
        temp.inventario_(this._inventario)
        temp.lore_(this._lore)
        temp.experiencia_(this._experiencia)
        temp.vidaAct_(this._vidaAct)
        temp.vidaT_(this._vidaT)
        return temp
    } 

    def ataque1() : (String, Int) ={
        // agresividad , devuelve tipo fuego
        // los jotun hace su estadistica mas su resistencia a ese elemento 
        var temp : Int = this._atributos("Fuego")
        var temp2 : Int = this._resistencias("Fuego")
        println("Agresividad")
        return ("Fuego" , temp + ((temp2*50)/100))
    }

    def ataque2() : (String, Int) ={
        // Buholl! , devuelve tipo tierra
        var temp : Int = this._atributos("Tierra")
        var temp2 : Int = this._resistencias("Tierra")
        println("Buholl!")
        return ("Tierra" , temp + ((temp2*50)/100))
    }

    def ataque3() : (String, Int) ={
        // Aliento de Jotun  , aire
        var temp : Int = this._atributos("Aire")
        var temp2 : Int = this._resistencias("Aire")
        println("Aliento de Jotun")
        return ("Aire" , temp + ((temp2*50)/100))
    }
    
    def ataque4() : (String, Int) ={
        // Escupitajo ; Agua 
        var temp : Int = this._atributos("Agua")
        var temp2 : Int = this._resistencias("Agua")
        println("Escupitajo")
        return ("Agua" , (temp/(temp2+1)) + ((temp*30)/100))
    }

    def agregarItem(i : Item) : Unit = {
        var tempStats   : Map[String, Int] = Map()
        var tempResist  : Map[String, Int] = Map()
        if(i.tipo == "Mazo"){
            tempStats += ("Agua"       -> (this.atributos("Agua")       + i.atributos("Agua")))
            tempStats += ("Fuego"        -> (this.atributos("Fuego")      + i.atributos("Fuego") + ((i.atributos("Fuego")*25)/100)))
            tempStats += ("Aire"        -> (this.atributos("Aire")       + i.atributos("Aire") + ((i.atributos("Aire")*25)/100)))
            tempStats += ("Tierra"      -> (this.atributos("Tierra")     + i.atributos("Tierra")+ ((i.atributos("Tierra")*25)/100)))
            tempStats += ("Luz"         -> (this.atributos("Luz")        + i.atributos("Luz") + ((i.atributos("Luz")*25)/100)))
            tempStats += ("Oscuridad"   -> (this.atributos("Oscuridad")  + i.atributos("Oscuridad") + ((i.atributos("Oscuridad")*25)/100)))
            this.atributos_(tempStats)
        }
        else if(i.tipo == "Escudo"){
            tempResist += ("Agua"       -> (this._resistencias("Agua")       + i.resistencias("Agua") + ((i.atributos("Agua")*25)/100)))
            tempResist += ("Fuego"        -> (this._resistencias("Fuego")      + i.resistencias("Fuego") + ((i.atributos("Fuego")*25)/100)))
            tempResist += ("Aire"        -> (this._resistencias("Aire")       + i.resistencias("Aire") + ((i.atributos("Aire")*25)/100)))
            tempResist += ("Tierra"      -> (this._resistencias("Tierra")     + i.resistencias("Tierra")+ ((i.atributos("Tierra")*25)/100)))
            tempResist += ("Luz"         -> (this._resistencias("Luz")        + i.resistencias("Luz") + ((i.atributos("Luz")*25)/100)))
            tempResist += ("Oscuridad"   -> (this._resistencias("Oscuridad")  + i.resistencias("Oscuridad") + ((i.atributos("Aire")*25)/100)))
            this.resistencias_(tempResist)
        }
        else if(i.tipo != "Pocion") {
            tempStats += ("Agua"       -> (this.atributos("Agua")       + i.atributos("Agua")))
            tempStats += ("Fuego"        -> (this.atributos("Fuego")      + i.atributos("Fuego")))
            tempStats += ("Aire"        -> (this.atributos("Aire")       + i.atributos("Aire")))
            tempStats += ("Tierra"      -> (this.atributos("Tierra")     + i.atributos("Tierra")))
            tempStats += ("Luz"         -> (this.atributos("Luz")        + i.atributos("Luz")))
            tempStats += ("Oscuridad"   -> (this.atributos("Oscuridad")  + i.atributos("Oscuridad")))
            this.atributos_(tempStats)

            tempResist += ("Agua"       -> (this._resistencias("Agua")       + i.resistencias("Agua")))
            tempResist += ("Fuego"        -> (this._resistencias("Fuego")      + i.resistencias("Fuego")))
            tempResist += ("Aire"        -> (this._resistencias("Aire")       + i.resistencias("Aire")))
            tempResist += ("Tierra"      -> (this._resistencias("Tierra")     + i.resistencias("Tierra")))
            tempResist += ("Luz"         -> (this._resistencias("Luz")        + i.resistencias("Luz")))
            tempResist += ("Oscuridad"   -> (this._resistencias("Oscuridad")  + i.resistencias("Oscuridad")))
            this.resistencias_(tempResist)
        }
        _inventario += i
    }

    def eliminarItem( i : Item ) : Unit ={
        var tempStats   : Map[String, Int] = Map()
        var tempResist  : Map[String, Int] = Map()
        if(i.tipo == "Mazo"){
            tempStats += ("Agua"       -> (this.atributos("Agua")       - i.atributos("Agua")))
            tempStats += ("Fuego"        -> (this.atributos("Fuego")      - i.atributos("Fuego") - ((i.atributos("Fuego")*25)/100)))
            tempStats += ("Aire"        -> (this.atributos("Aire")       - i.atributos("Aire") - ((i.atributos("Aire")*25)/100)))
            tempStats += ("Tierra"      -> (this.atributos("Tierra")     - i.atributos("Tierra")- ((i.atributos("Tierra")*25)/100)))
            tempStats += ("Luz"         -> (this.atributos("Luz")        - i.atributos("Luz") - ((i.atributos("Luz")*25)/100)))
            tempStats += ("Oscuridad"   -> (this.atributos("Oscuridad")  - i.atributos("Oscuridad") - ((i.atributos("Oscuridad")*25)/100)))
            this.atributos_(tempStats)
        }
        else if(i.tipo == "Escudo"){
            tempResist += ("Agua"       -> (this._resistencias("Agua")       - i.resistencias("Agua") - ((i.atributos("Agua")*25)/100)))
            tempResist += ("Fuego"        -> (this._resistencias("Fuego")      - i.resistencias("Fuego") - ((i.atributos("Fuego")*25)/100)))
            tempResist += ("Aire"        -> (this._resistencias("Aire")       - i.resistencias("Aire") - ((i.atributos("Aire")*25)/100)))
            tempResist += ("Tierra"      -> (this._resistencias("Tierra")     - i.resistencias("Tierra")- ((i.atributos("Tierra")*25)/100)))
            tempResist += ("Luz"         -> (this._resistencias("Luz")        - i.resistencias("Luz") - ((i.atributos("Luz")*25)/100)))
            tempResist += ("Oscuridad"   -> (this._resistencias("Oscuridad")  - i.resistencias("Oscuridad") - ((i.atributos("Aire")*25)/100)))
            this.resistencias_(tempResist)
        }
        else if(i.tipo != "Pocion") {
            tempStats += ("Agua"       -> (this.atributos("Agua")       - i.atributos("Agua")))
            tempStats += ("Fuego"        -> (this.atributos("Fuego")      - i.atributos("Fuego")))
            tempStats += ("Aire"        -> (this.atributos("Aire")       - i.atributos("Aire")))
            tempStats += ("Tierra"      -> (this.atributos("Tierra")     - i.atributos("Tierra")))
            tempStats += ("Luz"         -> (this.atributos("Luz")        - i.atributos("Luz")))
            tempStats += ("Oscuridad"   -> (this.atributos("Oscuridad")  - i.atributos("Oscuridad")))
            this.atributos_(tempStats)

            tempResist += ("Agua"       -> (this._resistencias("Agua")       - i.resistencias("Agua")))
            tempResist += ("Fuego"        -> (this._resistencias("Fuego")      - i.resistencias("Fuego")))
            tempResist += ("Aire"        -> (this._resistencias("Aire")       - i.resistencias("Aire")))
            tempResist += ("Tierra"      -> (this._resistencias("Tierra")     - i.resistencias("Tierra")))
            tempResist += ("Luz"         -> (this._resistencias("Luz")        - i.resistencias("Luz")))
            tempResist += ("Oscuridad"   -> (this._resistencias("Oscuridad")  - i.resistencias("Oscuridad")))
            this.resistencias_(tempResist)
        }
        _inventario = elimE(_inventario.toList, i).toSet
    }
}