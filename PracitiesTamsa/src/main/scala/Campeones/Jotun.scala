package Campeones

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

}