package Campeones

import Items._

class Elfo() extends Campeon{
    
    def cloning() : Campeon ={
        var temp : Elfo = new Elfo()
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
        // Compañero Natura , devuelve tipo tierra
        // escala con delta vida
        var temp : Int = this._atributos("Tierra")
        println("Compañero Natura")
        return ("Tierra" , temp )
    }
    def ataque2() : (String, Int) ={
        // Nado Elfico , devuelve tipo agua
        var temp : Int = this._atributos("Agua")
        println("Nado Elfico")
        return ("Agua" , temp )
    }
    def ataque3() : (String, Int) ={
        // Alas de luz  , aire
        var temp : Int = this._atributos("Aire")
        println("Alas de luz")
        return ("Aire" ,  temp  )
    }
    def ataque4() : (String, Int) ={
        // Aliento de Fenrir  ; Fuego 
        var temp : Int = this._atributos("Fuego")
        println("Mane Spiritu")
        return ("Fuego" ,  temp  )
    }

    def agregarItem(i : Item) : Unit = {
        var tempStats   : Map[String, Int] = Map()
        var tempResist  : Map[String, Int] = Map()
        if(i.tipo == "Espada" || i.tipo == "Varita"  || i.tipo == "Talisman"){
            tempStats += ("Agua"       -> (this.atributos("Agua")       + i.atributos("Agua")))
            tempStats += ("Fuego"        -> (this.atributos("Fuego")      + i.atributos("Fuego")))
            tempStats += ("Aire"        -> (this.atributos("Aire")       + i.atributos("Aire") + ((i.atributos("Aire")*25)/100)))
            tempStats += ("Tierra"      -> (this.atributos("Tierra")     + i.atributos("Tierra")+ ((i.atributos("Tierra")*10)/100)))
            tempStats += ("Luz"         -> (this.atributos("Luz")        + i.atributos("Luz") + ((i.atributos("Luz")*75)/100)))
            tempStats += ("Oscuridad"   -> (this.atributos("Oscuridad")  + i.atributos("Oscuridad")))
            this.atributos_(tempStats)
            
            if(i.tipo == "Talisman"){
                tempResist += ("Agua"       -> (this._resistencias("Agua")       + i.resistencias("Agua")))
                tempResist += ("Fuego"        -> (this._resistencias("Fuego")      + i.resistencias("Fuego")))
                tempResist += ("Aire"        -> (this._resistencias("Aire")       + i.resistencias("Aire") + ((i.atributos("Aire")*25)/100)))
                tempResist += ("Tierra"      -> (this._resistencias("Tierra")     + i.resistencias("Tierra")+ ((i.atributos("Tierra")*10)/100)))
                tempResist += ("Luz"         -> (this._resistencias("Luz")        + i.resistencias("Luz") + ((i.atributos("Luz")*75)/100)))
                tempResist += ("Oscuridad"   -> (this._resistencias("Oscuridad")  + i.resistencias("Oscuridad")))
                this.resistencias_(tempResist)
            }
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
        _inventario = i::_inventario
    }

    def eliminarItem(i : Item) : Unit = {
        var tempStats   : Map[String, Int] = Map()
        var tempResist  : Map[String, Int] = Map()
        if(i.tipo == "Espada" || i.tipo == "Varita"  || i.tipo == "Talisman"){
            tempStats += ("Agua"       -> (this.atributos("Agua")       - i.atributos("Agua")))
            tempStats += ("Fuego"        -> (this.atributos("Fuego")      - i.atributos("Fuego")))
            tempStats += ("Aire"        -> (this.atributos("Aire")       - i.atributos("Aire") - ((i.atributos("Aire")*25)/100)))
            tempStats += ("Tierra"      -> (this.atributos("Tierra")     - i.atributos("Tierra")- ((i.atributos("Tierra")*10)/100)))
            tempStats += ("Luz"         -> (this.atributos("Luz")        - i.atributos("Luz") - ((i.atributos("Luz")*75)/100)))
            tempStats += ("Oscuridad"   -> (this.atributos("Oscuridad")  - i.atributos("Oscuridad")))
            this.atributos_(tempStats)
            
            if(i.tipo == "Talisman"){
                tempResist += ("Agua"       -> (this._resistencias("Agua")       - i.resistencias("Agua")))
                tempResist += ("Fuego"        -> (this._resistencias("Fuego")      - i.resistencias("Fuego")))
                tempResist += ("Aire"        -> (this._resistencias("Aire")       - i.resistencias("Aire") - ((i.atributos("Aire")*25)/100)))
                tempResist += ("Tierra"      -> (this._resistencias("Tierra")     - i.resistencias("Tierra")- ((i.atributos("Tierra")*10)/100)))
                tempResist += ("Luz"         -> (this._resistencias("Luz")        - i.resistencias("Luz") - ((i.atributos("Luz")*75)/100)))
                tempResist += ("Oscuridad"   -> (this._resistencias("Oscuridad")  - i.resistencias("Oscuridad")))
                this.resistencias_(tempResist)
            }
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
         _inventario = elimE( _inventario , i)
    }
}