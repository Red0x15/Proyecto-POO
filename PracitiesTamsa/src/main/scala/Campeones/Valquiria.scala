package Campeones

class Valquiria() extends Campeon{
   
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
}
