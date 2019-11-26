package Enemigos

class Enemigo extends Serializable{
    // Atributos
    protected var _id           : Int = -1
    protected var _raza         : String = ""
    protected var _nivel        : Int = 0
    protected var _vidaT        : Int = 0
    protected var _vidaAct      : Int = 0
    protected var _atributo     : String = ""
    protected var _valAtributo  : Int = 0
    protected var _resistencias : Map[String, Int] = Map("Agua" -> 0, "Aire" -> 0, "Fuego" -> 0, "Tierra" -> 0)
    protected var _lore         : String = ""

    // Metodos
    // Getters
    def id              = _id
    def raza            = _raza
    def nivel           = _nivel
    def vidaT           = _vidaT
    def vidaAct         = _vidaAct
    def atributo        = _atributo
    def valAtributo     = _valAtributo
    def resistencias    = _resistencias
    def lore            = _lore

    // Setters
    def id_(nId : Int) : Unit = {_id = nId}
    def raza_(nRaza : String) : Unit = {_raza = nRaza}
    def nivel_(nNivel : Int) : Unit = {{if (nNivel == 0) _nivel = 1 else _nivel = nNivel}}
    def vidaT_(nVidaT : Int) : Unit = {_vidaT = nVidaT}
    def vidaAct_(nVidaAct : Int) : Unit = {_vidaAct = nVidaAct}
    def atributo_(nAtributo : String) : Unit = {_atributo = nAtributo}
    def valAtributo_(nVal : Int) : Unit = {_valAtributo = nVal}
    def resistencias_(nResistencias : Map[String, Int]) : Unit = {_resistencias = nResistencias}
    def lore_(nLore : String) : Unit = {_lore = nLore}

    // Funcion de prueba
    def info() : Unit = {
        println("Id " +  id + "\n" +
                "Raza " + raza + "\n" +
                "Nivel " + nivel + "\n" +
                "Vida Total " + vidaT + "\n" +
                "Vida Actual " + vidaAct + "\n" +
                "Lore" + lore + "\n" +
                "Atributo " + atributo)
        for ((k, v) <- resistencias) {println(k + " -> " + v)}
    }

    // Funciones
    def ataque() : (String, Int) = {(_atributo, _valAtributo)}

    def cloning() : Enemigo = {
        var temp = new Enemigo()
        temp.raza_(this.raza)
        temp.nivel_(this.nivel)
        temp.vidaT_(this.vidaT)
        temp.vidaAct_(this.vidaAct)
        temp.atributo_(this.atributo)
        temp.valAtributo_(this.valAtributo)
        temp.resistencias_(this.resistencias)
        temp.lore_(this.lore)
        return temp
    }
}