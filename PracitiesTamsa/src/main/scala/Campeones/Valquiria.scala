package Campeones
import Items._


class Valquiria() extends Campeon with Serializable{
   
    def cloning() : Campeon ={
        var temp : Valquiria = new Valquiria()
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
        // Rezo Natura , devuelve tipo tierra
        // escala con delta vida
        var temp : Int = this._atributos("Tierra")
        var deltaV = this._vidaT - this._vidaAct
        println("Rezo Natura")
        return ("Tierra" , temp + ((deltaV*25)/100))
    }

    def ataque2() : (String, Int) ={
        // Protesta Acuatica , devuelve tipo agua
        var temp : Int = this._atributos("Agua")
        var deltaV = this._vidaT - this._vidaAct
        println("Protesta Acuatica")
        return ("Agua" , temp + ((deltaV*25)/100))
    }

    def ataque3() : (String, Int) ={
        // Susurro de Odin  , aire
        var temp : Int = this._atributos("Aire")
        var deltaV = this._vidaT - this._vidaAct
        println("Susurro de Odin")
        return ("Aire" ,  temp + ((deltaV*25)/100) )
    }

    def ataque4() : (String, Int) ={
        // Aliento de Fenrir  ; Fuego 
        var temp : Int = this._atributos("Fuego")
        var deltaV = this._vidaT - this._vidaAct
        println("Aliento de Fenrir")
        return ("Fuego" ,  temp + ((deltaV*25)/100) )
    }

     def agregarItem(i : Item) : Unit = {
        var tempStats   : Map[String, Int] = Map()
        var tempResist  : Map[String, Int] = Map()
        if(i.tipo == "Espada" || i.tipo == "Arco"){
            tempStats += ("Agua"       -> (this.atributos("Agua")       + i.atributos("Agua") ))
            tempStats += ("Fuego"        -> (this.atributos("Fuego")      + i.atributos("Fuego") ))
            tempStats += ("Aire"        -> (this.atributos("Aire")       + i.atributos("Aire") ))
            tempStats += ("Tierra"      -> (this.atributos("Tierra")     + i.atributos("Tierra")))
            tempStats += ("Luz"         -> (this.atributos("Luz")        + i.atributos("Luz") ))
            tempStats += ("Oscuridad"   -> (this.atributos("Oscuridad")  + i.atributos("Oscuridad") ))
            _vidaT = vidaT + (((tempStats("Agua") + tempStats("Fuego")+tempStats("Aire")+tempStats("Tierra")+tempStats("Luz")+tempStats("Oscuridad"))*20)/100)
            this.atributos_(tempStats)
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
        if(i.tipo == "Espada" || i.tipo == "Arco"){
            tempStats += ("Agua"       -> (this.atributos("Agua")       - i.atributos("Agua") ))
            tempStats += ("Fuego"        -> (this.atributos("Fuego")      - i.atributos("Fuego") ))
            tempStats += ("Aire"        -> (this.atributos("Aire")       - i.atributos("Aire") ))
            tempStats += ("Tierra"      -> (this.atributos("Tierra")     - i.atributos("Tierra")))
            tempStats += ("Luz"         -> (this.atributos("Luz")        - i.atributos("Luz") ))
            tempStats += ("Oscuridad"   -> (this.atributos("Oscuridad")  - i.atributos("Oscuridad") ))
            _vidaT = vidaT + (((tempStats("Agua") - tempStats("Fuego")-tempStats("Aire")-tempStats("Tierra")-tempStats("Luz")-tempStats("Oscuridad"))*20)/100)
            this.atributos_(tempStats)
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
