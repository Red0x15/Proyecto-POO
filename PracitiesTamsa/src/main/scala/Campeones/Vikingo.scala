package Campeones

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
}