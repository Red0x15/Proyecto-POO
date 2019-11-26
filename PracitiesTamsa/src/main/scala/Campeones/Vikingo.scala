package Campeones
import Items._


class Vikingo() extends Campeon{
    
    def cloning() : Campeon = {
        var temp : Vikingo = new Vikingo()
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
        // fuerza Natura , devuelve tipo tierra
        // tierra le da estad + 10% de la estadis
        var temp : Int = this._atributos("Tierra")
        println("Fuerza Natura")
        return ("Tierra" , temp + ((temp*10)/100))
    }
    def ataque2() : (String, Int) ={
        // sacrificio Humano , devuelve tipo agua
        var temp : Int = this._atributos("Agua")
        println("Sacrificio Humano")
        return ("Agua" , temp )
    }
    def ataque3() : (String, Int) ={
        // Oracion divina  , aire
        var temp : Int = this._atributos("Aire")
        println("Oracion divina")
        return ("Aire" , temp )
    }
    def ataque4() : (String, Int) ={
        // fuerza celestial ; tierra 
        var temp : Int = this._atributos("Tierra")
        var temp2 : Int = this._resistencias("Tierra")
        println("Fuerza celestial")
        return ("Tierra" , (temp/(temp2+1)) + ((temp*30)/100))
    }
    
    def agregarItem(i : Item) : Unit = {
        var tempStats   : Map[String, Int] = Map()
        var tempResist  : Map[String, Int] = Map()
        if(i.tipo == "Hacha" || i.tipo == "Talisman"){
            tempStats += ("Agua"       -> (this.atributos("Agua")       + i.atributos("Agua") + ((i.atributos("Agua")*15)/100)))
            tempStats += ("Fuego"        -> (this.atributos("Fuego")      + i.atributos("Fuego") + ((i.atributos("Fuego")*15)/100)))
            tempStats += ("Aire"        -> (this.atributos("Aire")       + i.atributos("Aire") + ((i.atributos("Aire")*15)/100)))
            tempStats += ("Tierra"      -> (this.atributos("Tierra")     + i.atributos("Tierra")+ ((i.atributos("Tierra")*50)/100)))
            tempStats += ("Luz"         -> (this.atributos("Luz")        + i.atributos("Luz") + ((i.atributos("Luz")*15)/100)))
            tempStats += ("Oscuridad"   -> (this.atributos("Oscuridad")  + i.atributos("Oscuridad") + ((i.atributos("Oscuridad")*15)/100)))
            this.atributos_(tempStats)
            if(i.tipo == "Talisman"){
                tempResist += ("Agua"       -> (this._resistencias("Agua")       + i.resistencias("Agua") + ((i.resistencias("Agua")*15)/100)))
                tempResist += ("Fuego"        -> (this._resistencias("Fuego")      + i.resistencias("Fuego") + ((i.resistencias("Fuego")*15)/100)))
                tempResist += ("Aire"        -> (this._resistencias("Aire")       + i.resistencias("Aire") + ((i.resistencias("Aire")*15)/100)))
                tempResist += ("Tierra"      -> (this._resistencias("Tierra")     + i.resistencias("Tierra") + ((i.resistencias("Tierra")*50)/100)))
                tempResist += ("Luz"         -> (this._resistencias("Luz")        + i.resistencias("Luz") + ((i.resistencias("Luz")*15)/100)))
                tempResist += ("Oscuridad"   -> (this._resistencias("Oscuridad")  + i.resistencias("Oscuridad") + ((i.resistencias("Oscuridad")*15)/100)))
                this.resistencias_(tempResist)
            }
        }
        else if(i.tipo == "Escudo"){
            tempResist += ("Agua"       -> (this._resistencias("Agua")       + i.resistencias("Agua") + ((i.resistencias("Agua")*15)/100)))
            tempResist += ("Fuego"        -> (this._resistencias("Fuego")      + i.resistencias("Fuego") + ((i.resistencias("Fuego")*15)/100)))
            tempResist += ("Aire"        -> (this._resistencias("Aire")       + i.resistencias("Aire") + ((i.resistencias("Aire")*15)/100)))
            tempResist += ("Tierra"      -> (this._resistencias("Tierra")     + i.resistencias("Tierra")+ ((i.resistencias("Tierra")*50)/100)))
            tempResist += ("Luz"         -> (this._resistencias("Luz")        + i.resistencias("Luz") + ((i.resistencias("Luz")*15)/100)))
            tempResist += ("Oscuridad"   -> (this._resistencias("Oscuridad")  + i.resistencias("Oscuridad") + ((i.resistencias("Aire")*15)/100)))
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

     def eliminarItem(i : Item) : Unit = {
        var tempStats   : Map[String, Int] = Map()
        var tempResist  : Map[String, Int] = Map()
        if(i.tipo == "Hacha" || i.tipo == "Talisman"){
            tempStats += ("Agua"       -> (this.atributos("Agua")       - i.atributos("Agua") - ((i.atributos("Agua")*15)/100)))
            tempStats += ("Fuego"        -> (this.atributos("Fuego")      - i.atributos("Fuego") - ((i.atributos("Fuego")*15)/100)))
            tempStats += ("Aire"        -> (this.atributos("Aire")       - i.atributos("Aire") - ((i.atributos("Aire")*15)/100)))
            tempStats += ("Tierra"      -> (this.atributos("Tierra")     - i.atributos("Tierra")- ((i.atributos("Tierra")*50)/100)))
            tempStats += ("Luz"         -> (this.atributos("Luz")        - i.atributos("Luz") - ((i.atributos("Luz")*15)/100)))
            tempStats += ("Oscuridad"   -> (this.atributos("Oscuridad")  - i.atributos("Oscuridad") - ((i.atributos("Oscuridad")*15)/100)))
            this.atributos_(tempStats)
            if(i.tipo == "Talisman"){
                tempResist += ("Agua"       -> (this._resistencias("Agua")       - i.resistencias("Agua") - ((i.resistencias("Agua")*15)/100)))
                tempResist += ("Fuego"        -> (this._resistencias("Fuego")      - i.resistencias("Fuego") - ((i.resistencias("Fuego")*15)/100)))
                tempResist += ("Aire"        -> (this._resistencias("Aire")       - i.resistencias("Aire") - ((i.resistencias("Aire")*15)/100)))
                tempResist += ("Tierra"      -> (this._resistencias("Tierra")     - i.resistencias("Tierra") - ((i.resistencias("Tierra")*50)/100)))
                tempResist += ("Luz"         -> (this._resistencias("Luz")        - i.resistencias("Luz") - ((i.resistencias("Luz")*15)/100)))
                tempResist += ("Oscuridad"   -> (this._resistencias("Oscuridad")  - i.resistencias("Oscuridad") - ((i.resistencias("Oscuridad")*15)/100)))
                this.resistencias_(tempResist)
            }
        }
        else if(i.tipo == "Escudo"){
            tempResist += ("Agua"       -> (this._resistencias("Agua")       - i.resistencias("Agua") - ((i.resistencias("Agua")*15)/100)))
            tempResist += ("Fuego"        -> (this._resistencias("Fuego")      - i.resistencias("Fuego") - ((i.resistencias("Fuego")*15)/100)))
            tempResist += ("Aire"        -> (this._resistencias("Aire")       - i.resistencias("Aire") - ((i.resistencias("Aire")*15)/100)))
            tempResist += ("Tierra"      -> (this._resistencias("Tierra")     - i.resistencias("Tierra")- ((i.resistencias("Tierra")*50)/100)))
            tempResist += ("Luz"         -> (this._resistencias("Luz")        - i.resistencias("Luz") - ((i.resistencias("Luz")*15)/100)))
            tempResist += ("Oscuridad"   -> (this._resistencias("Oscuridad")  - i.resistencias("Oscuridad") - ((i.resistencias("Aire")*15)/100)))
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