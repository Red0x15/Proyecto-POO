package Campeones

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


}